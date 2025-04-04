package lk.zerocode.library.api.Exceptions;

public class MemberNotFoundException extends ResourceNotFoundException{

    public MemberNotFoundException(){
        super("Member not found");
    }
}
