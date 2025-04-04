package lk.zerocode.library.api.Exceptions;

public class AuthorNotFoundException extends ResourceNotFoundException{

    public AuthorNotFoundException(){
        super("Author not found");
    }
}
