package lk.zerocode.library.api.DTO.Response;

import jakarta.validation.constraints.NotNull;

public class AuthorResponseDTO {


    private String authorName;
    private String bio;

    public AuthorResponseDTO() {
    }

    public AuthorResponseDTO(String authorName, String bio) {
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
