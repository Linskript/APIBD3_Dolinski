package bd0706.bd3.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import bd0706.bd3.common.ConversorData;
import bd0706.bd3.domain.exception.ResourceBadRequestException;
import bd0706.bd3.domain.exception.ResourceNotFoundException;
import bd0706.bd3.domain.model.ErroResposta;

@ControllerAdvice
public class RestExceptionHandler {
  
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErroResposta> handlerResourceNotFoundExecption(ResourceNotFoundException ex){
        String dataHora = ConversorData.converterDateParaDataHora(new Date());
        ErroResposta erro =  new ErroResposta(dataHora, 
        HttpStatus.NOT_FOUND.value(), "Not Found", ex.getMessage());
        return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceBadRequestException.class)
    public ResponseEntity<ErroResposta> handlerBadRequestResourceNotFoundExecption(ResourceBadRequestException ex){
        String dataHora = ConversorData.converterDateParaDataHora(new Date());
        ErroResposta erro =  new ErroResposta(dataHora, 
        HttpStatus.BAD_REQUEST.value(), "Bad Request", ex.getMessage());
        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResposta> handlerRequestExecption(Exception ex){
        String dataHora = ConversorData.converterDateParaDataHora(new Date());
        ErroResposta erro =  new ErroResposta(dataHora, 
        HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error", ex.getMessage());
        return new ResponseEntity<>(erro, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}