package lk.zerocode.library.api.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateBorrowedBookRequestDTO {

    @NotNull(message = "ID is required")
    private Long id;
    @NotNull(message = "Member ID is required")
    private Long memberId;
    @NotNull(message = "Book ID is required")
    private Long bookId;

    public UpdateBorrowedBookRequestDTO(Long id, Long memberId, Long bookId) {
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
