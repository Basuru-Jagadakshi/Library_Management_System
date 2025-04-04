package lk.zerocode.library.api.DTO.Response;

import java.time.LocalDate;

public class BorrowedBookResponseDTO {

    private Long userId;
    private Long bookId;
    private String status;
    private LocalDate borrowedDate;
    private LocalDate dueDate;

    public BorrowedBookResponseDTO(Long userId, Long bookId, String status, LocalDate borrowedDate, LocalDate dueDate) {
        this.userId = userId;
        this.bookId = bookId;
        this.status = status;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
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
}
