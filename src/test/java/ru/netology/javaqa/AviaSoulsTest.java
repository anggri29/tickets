package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class AviaSoulsTest {
    AviaSouls aviaSouls = new AviaSouls();
    TicketTimeComparator timeComparator = new TicketTimeComparator();
    Ticket ticket1 = new Ticket("Boston", "Moscow", 100, 9, 15); // 6
    Ticket ticket2 = new Ticket("Boston", "New York", 150, 10, 13); // 3
    Ticket ticket3 = new Ticket("Boston", "New York", 120, 8, 11); // 3
    Ticket ticket4 = new Ticket("Boston", "New York", 120, 7, 16); // 9

    @BeforeEach
    public void setup() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
    }

    @Test
    public void CompareToLess() {

        Assertions.assertEquals(-1, ticket1.compareTo(ticket2));
        Assertions.assertEquals(-1, ticket3.compareTo(ticket2));
    }

    @Test
    public void CompareToHigh() {

        Assertions.assertEquals(1, ticket2.compareTo(ticket1));
        Assertions.assertEquals(1, ticket2.compareTo(ticket3));
    }

    @Test
    public void CompareToEqual() {

        Assertions.assertEquals(0, ticket3.compareTo(ticket4));
    }

    @Test
    public void SearchFindAll() {

        Ticket[] tickets = aviaSouls.findAll();
        Arrays.sort(tickets);

        Ticket[] expected = {ticket1, ticket3, ticket4, ticket2};
        Ticket[] actual = aviaSouls.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TicketTimeComparatorLess() {

        Assertions.assertEquals(-1, timeComparator.compare(ticket2, ticket1));
        Assertions.assertEquals(-1, timeComparator.compare(ticket1, ticket4));

    }

    @Test
    public void TicketTimeComparatorHigh() {

        Assertions.assertEquals(1, timeComparator.compare(ticket1, ticket2));
        Assertions.assertEquals(1, timeComparator.compare(ticket1, ticket3));

    }

    @Test
    public void TicketTimeComparatorEqual() {

        Assertions.assertEquals(0, timeComparator.compare(ticket2, ticket3));


    }

    @Test
    public void SearchAndSortBy() {
        Ticket[] tickets = aviaSouls.findAll();
        Arrays.sort(tickets, timeComparator);

        Ticket[] expected = {ticket2, ticket3, ticket4};
        Ticket[] actual = aviaSouls.searchAndSortBy("Boston", "New York", timeComparator);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void SearchAndSortByFew() {

        Ticket[] expected = {ticket2, ticket3, ticket4};
        Ticket[] actual = aviaSouls.searchAndSortBy("Boston", "New York", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchAndSortByOne() {

        Ticket[] expected = {ticket1};
        Ticket[] actual = aviaSouls.searchAndSortBy("Boston", "Moscow", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchAndSortByNone() {

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.searchAndSortBy("Moscow", "Saint-Petersburg", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
