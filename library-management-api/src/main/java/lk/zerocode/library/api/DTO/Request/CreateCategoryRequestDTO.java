package lk.zerocode.library.api.DTO.Request;

import jakarta.validation.constraints.NotBlank;

public class CreateCategoryRequestDTO {

    @NotBlank(message = "Category Name is required")
    private String categoryName;
    private String description;

    public CreateCategoryRequestDTO() {
    }

    public CreateCategoryRequestDTO(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
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
