package lk.zerocode.library.api.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateCategoryRequestDTO {

    @NotNull(message = "ID is required")
    private Long id;
    @NotBlank(message = "Category name is required")
    private String categoryName;
    private String description;

    public UpdateCategoryRequestDTO() {
    }

    public UpdateCategoryRequestDTO(Long id, String categoryName, String description) {
        this.id = id;
        this.categoryName = categoryName;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
