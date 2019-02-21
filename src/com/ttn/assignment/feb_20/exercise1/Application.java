package com.ttn.assignment.feb_20.exercise1;

import java.util.*;

/**
 * Create Java classes having suitable attributes for Library management system.Use OOPs concepts in your design
 * Also try to use interfaces and abstract classes.
 */
public class Application {
    static Map<Integer, Book> books = new HashMap<>();
    static Map<Integer, Borrower> borrowers = new HashMap<>();
    static List<IssueBook> booksIssued = new ArrayList<>();

    public static void main(String[] args) {
        addBorrower();
        System.out.println("1.Add Book");
        System.out.println("2.Issue a book");
        System.out.println("3.Delete book");
        System.out.println("4.Print complete issue details");
        System.out.println("5.Exit");
        System.out.print("Enter Choice :");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        do {
            switch (choice) {
                case 1:
                    System.out.println(addBook() ? "Book Added." : "Some Error Occurred.");
                    break;
                case 2:
                    System.out.print("Enter Book's ISBN : ");
                    int isbn = scanner.nextInt();
                    System.out.println("Select Borrower's Id : ");
                    for (Map.Entry<Integer, Borrower> borrowerMap : borrowers.entrySet()) {
                        System.out.println(borrowerMap.getValue().getId() + "." + borrowerMap.getValue().getName());
                    }
                    System.out.print("Enter Borrower's Id : ");
                    int id = scanner.nextInt();
                    System.out.println(issueBook(isbn, id) ? "Book Issued." : "Some Error Occurred.");
                    break;
                case 3:
                    isbn = scanner.nextInt();
                    System.out.println(deleteBook(isbn) ? "Book Deleted" : "Some Error Occurred.");
                    break;
                case 4:
                    if (booksIssued.size() != 0)
                        booksIssued.forEach(book -> System.out.println(book.book.getTitle() + " is Issued to : " +
                                book.borrower.getName()));
                    else System.out.println("No book issued yet.");
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid input");
                    break;
            }
            scanner = new Scanner(System.in);
            System.out.print("Enter Choice :");
            choice = scanner.nextInt();
        } while (choice > 0 && choice < 6);
    }

    private static void addBorrower() {
        Borrower borrower = new Borrower("Yatin", 24, 9654773125L, 1);
        Borrower borrower1 = new Borrower("Yatika", 22, 9654673125L, 2);
        Borrower borrower2 = new Borrower("Harsh", 22, 9845654459L, 3);
        Borrower borrower3 = new Borrower("Harsha", 24, 9845654462L, 4);
        Borrower borrower4 = new Borrower("Naman", 25, 98456455559L, 5);
        borrowers.put(1, borrower);
        borrowers.put(2, borrower1);
        borrowers.put(3, borrower2);
        borrowers.put(4, borrower3);
        borrowers.put(5, borrower4);
        System.out.println("Borrowers Added.");
    }

    private static boolean issueBook(int isbn, int id) {
        IssueBook issueBook = new IssueBook();
        if (books.containsKey(isbn)) {
            booksIssued.add(issueBook.issue(books.get(isbn), borrowers.get(id)));
            return true;
        }
        return false;
    }

    private static boolean addBook() {
        System.out.println("Enter Book's title,Author Name ,price and ISBN");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        String author = scanner.nextLine();
        float price = scanner.nextFloat();
        Integer isbn = scanner.nextInt();
        Book book = new Book(isbn, title, author, price);
        if (!books.containsValue(book)) {
            books.put(book.getISBN(), book);
            return true;
        }
        return false;
    }

    public static boolean deleteBook(int isbn) {
        if (books.containsKey(isbn)) {
            books.remove(books.get(isbn));
            return true;
        }
        return false;
    }
}
