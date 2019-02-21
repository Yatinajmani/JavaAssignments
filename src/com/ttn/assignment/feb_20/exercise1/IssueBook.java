package com.ttn.assignment.feb_20.exercise1;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

/**
 * This class implements Issuable interface and overrides the abstract methods.
 */
public class IssueBook implements Issuable {
    UUID uuid;
    Book book;
    Borrower borrower;
    Date date;

    @Override
    public IssueBook issue(Book book, Borrower borrower) {
        this.book = book;
        this.borrower = borrower;
        this.uuid = UUID.randomUUID();
        this.date = Date.from(LocalDate.now().plusDays(RETURN_IN_DAYS).atStartOfDay(ZoneId.systemDefault())
                .toInstant());
        return this;
    }
}
