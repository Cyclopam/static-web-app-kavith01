package com.dxc.bankingapi.exception;
import com.dxc.bankingapi.dto.MessageResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BankException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public  MessageResponse handleBankingException(BankException ex)
    {
       return new MessageResponse(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageResponse handleValidationException(MethodArgumentNotValidException ex)
    {
        String errorMessage = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        return new MessageResponse(errorMessage);

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public MessageResponse handleGenericException(Exception ex){
        return new MessageResponse("Something went wrong: "+ex.getMessage());

    }
}
