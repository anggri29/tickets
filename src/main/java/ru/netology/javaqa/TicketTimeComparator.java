package ru.netology.javaqa;

import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {


    @Override
    public int compare(Ticket t1, Ticket t2) {
        int flight1 = t1.getTimeTo() - t1.getTimeFrom();
        int flight2 = t2.getTimeTo() - t2.getTimeFrom();

        if (flight1 < flight2) {
            return -1;
        } else if (flight1 > flight2) {
            return 1;
        } else {
            return 0;
        }
    }
}
