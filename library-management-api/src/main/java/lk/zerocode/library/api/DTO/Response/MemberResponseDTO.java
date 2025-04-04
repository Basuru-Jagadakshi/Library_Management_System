package lk.zerocode.library.api.DTO.Response;

public class MemberResponseDTO {

    private String memberName;
    private String email;

    public MemberResponseDTO() {
    }

    public MemberResponseDTO(String memberName, String email) {
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
