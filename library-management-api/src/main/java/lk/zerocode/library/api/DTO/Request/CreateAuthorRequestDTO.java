package lk.zerocode.library.api.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateAuthorRequestDTO {

    @NotBlank(message = "Name is required")
    private String authorName;
    private String bio;

    public CreateAuthorRequestDTO() {
    }

    public CreateAuthorRequestDTO(String authorName, String bio) {
        this.authorName = authorName;
        this.bio = bio;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
