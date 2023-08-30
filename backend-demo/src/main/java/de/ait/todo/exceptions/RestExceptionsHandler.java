package de.ait.todo.exceptions;

import de.ait.todo.dto.StandardResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 8/8/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@ControllerAdvice
public class RestExceptionsHandler {

    @ExceptionHandler(RestException.class)
    public ResponseEntity<StandardResponseDto> handleRestException(RestException e) {
        return ResponseEntity
                .status(e.getHttpStatus())
                .body(StandardResponseDto.builder()
                        .message(e.getMessage())
                        .build());
    }
}
