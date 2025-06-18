package org.example.kbspring.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Arrays;

@ControllerAdvice
@Slf4j
public class CommonExceptionAdvice {

    //매개 변수로서 어느 예외를 줄건지 담당.
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String Handle404(NoHandlerFoundException e) {
        return "/exception/404";
    }

    @ExceptionHandler(Exception.class)
    public String Handle500(Exception e, Model model) {
        e.printStackTrace();

        model.addAttribute("errorMessage", e.getMessage());
        model.addAttribute("stackTrace", Arrays.asList(e.getStackTrace()));

        return "/exception/500";
    }





}
