package lk.zerocode.library.api.Exceptions;

public class BookNotFoundException extends ResourceNotFoundException {

    public BookNotFoundException(){
        super("Book not found");
    }
}
