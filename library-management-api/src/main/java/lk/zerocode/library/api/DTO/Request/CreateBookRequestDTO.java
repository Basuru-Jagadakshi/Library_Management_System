package lk.zerocode.library.api.DTO.Request;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateBookRequestDTO {

    @NotBlank(message = "Title is required")
    private String title;
    @NotBlank(message = "ISBN is required")
    private String isbn;
    private String publishedYear;
    @NotNull(message = "Total copies is required")
    @Min(value = 0)
    private Integer totalCopies;

    @NotNull(message = "Available copies is required")
    @Min(value = 0)
    private Integer availableCopies;

    private String description;
    @NotNull(message = "Author ID is required")
    private Long authorId;
    @NotNull(message = "Category ID is required")
    private Long categoryId;

    public CreateBookRequestDTO() {
    }

    public CreateBookRequestDTO(String title, String isbn, String publishedYear, Integer totalCopies, Integer availableCopies, String description, Long authorId, Long categoryId) {
        this.title = title;
        this.isbn = isbn;
        this.publishedYear = publishedYear;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
        this.description = description;
        this.authorId = authorId;
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(String publishedYear) {
        this.publishedYear = publishedYear;
    }

    public Integer getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(Integer totalCopies) {
        this.totalCopies = totalCopies;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
