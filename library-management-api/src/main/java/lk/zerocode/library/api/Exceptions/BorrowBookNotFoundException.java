package lk.zerocode.library.api.Exceptions;

public class BorrowBookNotFoundException extends ResourceNotFoundException{

    public BorrowBookNotFoundException(){
        super("Borrowed book not found");
    }
}
