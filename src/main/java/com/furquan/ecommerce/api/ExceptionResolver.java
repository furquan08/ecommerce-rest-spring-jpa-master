package com.furquan.ecommerce.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.furquan.ecommerce.exception.NotFoundException;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
 * Exception Resolver.
 * Unhandled exceptions in Controller will be formatted here.
 *
 * @author furquan
 */
@ControllerAdvice
public class ExceptionResolver {

    @ExceptionHandler(value = NotFoundException.class)
    public void handleNotFoundException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
    public void handleIllegalArgumentException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

}
