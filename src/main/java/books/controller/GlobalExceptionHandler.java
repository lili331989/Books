package books.controller;

import books.exception.ResourceNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({EmptyResultDataAccessException.class})
    public String noObject(Model model) {
        model.addAttribute("message", "Данный объект не существует, обновите таблицу");
        return "error";
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public String resourceNotFound(Model model, ResourceNotFoundException ex ) {
        model.addAttribute("message", ex.getMessage());
        return "error";
    }

    @ExceptionHandler({IOException.class})
    public String fileNotFound(Model model) {
        model.addAttribute("message", "Проблемы при загрузке файла");
        return "error";
    }
}
