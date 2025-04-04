package lk.zerocode.library.api.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "borrowed_books")
public class BorrowBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private LocalDate borrowedDate;

    private LocalDate dueDate;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Book book;

    public BorrowBook() {
        this.status = "Borrowed";
        this.borrowedDate = LocalDate.now();
        this.dueDate = borrowedDate.plusDays(14);
    }

    public BorrowBook(Member member, Book book) {
        this.member = member;
        this.book = book;
        this.status = "Borrowed";
        this.borrowedDate = LocalDate.now();
        this.dueDate = borrowedDate.plusDays(14);
    }

    public BorrowBook(Long id, Member member, Book book) {
        this.id = id;
        this.member = member;
        this.book = book;
        this.status = "Borrowed";
        this.borrowedDate = LocalDate.now();
        this.dueDate = borrowedDate.plusDays(14);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
