package lk.zerocode.library.api.Exceptions;

public class CategoryNotFoundException extends ResourceNotFoundException{

    public CategoryNotFoundException(){
        super("Category not found");
    }
}
