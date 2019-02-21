package com.ttn.assignment.feb_20.exercise1;

/**
 * An interface used to make implementing class to agree on some behaviour and allows it to do it as per needs
 * This helps in achieving abstraction;
 */
public interface Issuable {
    int RETURN_IN_DAYS=15;
    IssueBook issue(Book book, Borrower borrower);
}
