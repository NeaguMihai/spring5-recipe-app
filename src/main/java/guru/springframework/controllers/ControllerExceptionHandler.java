package guru.springframework.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import guru.springframework.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView badNumberFormat(Exception e) {
    	log.error("NumberFormat not found");
    	log.error(e.getMessage());
    	ModelAndView mav = new ModelAndView();

    	mav.setViewName("400error");
    	mav.addObject("exception", e);
    	
    	return mav;
    }
    
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception e) {
    	log.error("Handling not found");
    	log.error(e.getMessage());
    	ModelAndView mav = new ModelAndView();
    	
    	mav.setViewName("404error");
    	mav.addObject("exception", e);
    	
    	return mav;
    }
    

}
