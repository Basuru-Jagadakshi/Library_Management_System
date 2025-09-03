package lk.zerocode.library.api.DTO.Request;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lk.zerocode.library.api.Model.Authority;

import java.util.List;

public class CreateMemberRequestDTO {

    @NotBlank(message = "Member name is required")
    private String memberName;
    @Email(message = "Valid  email is required")
    private String email;

    private String userName;


    private String password;


    private boolean enabled;


    public CreateMemberRequestDTO() {
    }

    public CreateMemberRequestDTO(String memberName, String email,  String userName, String password) {
        this.memberName = memberName;
        this.email = email;
        this.userName = userName;
        this.password = password;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
