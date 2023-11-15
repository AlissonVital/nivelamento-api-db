package projetos.spring.nivelamento_sb.handler;
//É UMA CLASSE AONDE TERÁ INFORMAÇÕES QUE O CONTROLER PRECISA UTILIZAR

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import projetos.spring.nivelamento_sb.exception.BadRequestException;
import projetos.spring.nivelamento_sb.exception.BadRequestExceptionDetails;

import java.time.LocalDateTime;

@ControllerAdvice//ESTA SENDO INFORMADO PARA TODOS OS CONTROLLERS QUE PRECISA UTILIZAR O QUE FOR COLOCADO DENTRO DESTA CLASSE
public class RestExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handlerBadRequestException(BadRequestException bre){
        return new ResponseEntity<>(
                BadRequestExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Bad Request Exception, Check the Documentation")
                        .details(bre.getMessage())
                        .developerMessage(bre.getClass().getName())
                        .build(), HttpStatus.BAD_REQUEST);
    }
}