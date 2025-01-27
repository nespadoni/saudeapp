package saude.app.api.exceptions;

import jakarta.persistence.MapsId;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// Forma do Spring encontrar a classe automaticamente na hora de tratar um erro
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Tratamento de erros de validação: campos ausentes ou inválidos
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
            MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();

        // Reúne todos os erros de validação do corpo da requisição
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        // Retorna uma resposta com detalhes dos erros
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    // Tratamento de erros de restrição (ex: ‘IDs’ obrigatórios, valores fora de padrão)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro de validação: " + ex.getMessage());
    }

    // Tratamento de outros erros (opcional)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro inesperado: " + ex.getMessage());
    }


}
