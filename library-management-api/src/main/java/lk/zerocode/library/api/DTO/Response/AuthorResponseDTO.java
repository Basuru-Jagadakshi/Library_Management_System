package lk.zerocode.library.api.DTO.Response;

import jakarta.validation.constraints.NotNull;

public class AuthorResponseDTO {


    private Long id;
    private String authorName;
    private String bio;

    public AuthorResponseDTO() {
    }

    public AuthorResponseDTO(Long id, String authorName, String bio) {
        this.id = id;
        this.authorName = authorName;
        this.bio = bio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
