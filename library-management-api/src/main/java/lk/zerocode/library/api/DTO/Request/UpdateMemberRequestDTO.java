package lk.zerocode.library.api.DTO.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateMemberRequestDTO {

    @NotNull(message = "ID is required")
    private Long id;
    @NotBlank(message = "Member name is required")
    private String memberName;
    @Email(message = "Valid  email is required")
    private String email;

    public UpdateMemberRequestDTO() {
    }

    public UpdateMemberRequestDTO(Long id, String memberName, String email) {
        this.id = id;
        this.memberName = memberName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
