package lk.zerocode.library.api.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class CreateBorrowedBookRequestDTO {

    @NotNull(message = "Member ID is required")
    private Long memberId;
    @NotNull(message = "Book ID is required")
    private Long bookId;

    public CreateBorrowedBookRequestDTO(Long memberId, Long bookId) {
        this.memberId = memberId;
        this.bookId = bookId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
