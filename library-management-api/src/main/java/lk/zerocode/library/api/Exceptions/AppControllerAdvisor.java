package lk.zerocode.library.api.Exceptions;


import lk.zerocode.library.api.DTO.Response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppControllerAdvisor {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler({ResourceNotFoundException.class})
    public ErrorResponse handleResourceNotFoundException(ResourceNotFoundException ex){
        return new ErrorResponse(ex.getMessage());
    }


    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleGeneralException(Exception ex){
        return new ErrorResponse("An unexpected error occurred: " + ex.getMessage());
    }
}
