package lk.zerocode.library.api.DTO.Response;

public class MemberResponseDTO {

    private Long id;
    private String memberName;
    private String email;

    public MemberResponseDTO() {
    }

    public MemberResponseDTO(Long id, String memberName, String email) {
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
