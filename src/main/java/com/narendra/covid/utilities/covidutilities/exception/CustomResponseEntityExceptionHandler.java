package com.narendra.covid.utilities.covidutilities.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.narendra.covid.utilities.covidutilities.util.CommonResponseDTO;
import com.narendra.covid.utilities.covidutilities.util.ErrorDTO;

@RestControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	public final ResponseEntity<CommonResponseDTO> handleException(CovidUtilsException flashSaleException, WebRequest req ) {
		ErrorDTO error = new ErrorDTO();
		flashSaleException.printStackTrace();
		error.setMessage(flashSaleException.getMessage());
		return new ResponseEntity<CommonResponseDTO>(new CommonResponseDTO(null, error, false), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public final ResponseEntity<CommonResponseDTO> handleAuthException(RuntimeException flashSaleException, WebRequest req ) {
		ErrorDTO error = new ErrorDTO();
		flashSaleException.printStackTrace();
		error.setMessage(flashSaleException.getMessage());
		return new ResponseEntity<CommonResponseDTO>(new CommonResponseDTO(null, error, false), HttpStatus.BAD_REQUEST);
	}
}
