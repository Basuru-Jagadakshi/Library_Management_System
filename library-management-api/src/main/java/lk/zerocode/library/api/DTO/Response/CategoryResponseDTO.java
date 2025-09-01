package lk.zerocode.library.api.DTO.Response;

import java.io.Serializable;

public class CategoryResponseDTO implements Serializable {


    private Long id;
    private String categoryName;
    private String description;

    public CategoryResponseDTO() {
    }

    public CategoryResponseDTO(Long id, String categoryName, String description) {
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
