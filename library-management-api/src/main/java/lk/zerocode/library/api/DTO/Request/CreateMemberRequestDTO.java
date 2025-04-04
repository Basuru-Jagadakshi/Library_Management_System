package lk.zerocode.library.api.DTO.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class CreateMemberRequestDTO {

    @NotBlank(message = "Member name is required")
    private String memberName;
    @Email(message = "Valid  email is required")
    private String email;

    public CreateMemberRequestDTO() {
    }

    public CreateMemberRequestDTO(String memberName, String email) {
        this.memberName = memberName;
        this.email = email;
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
