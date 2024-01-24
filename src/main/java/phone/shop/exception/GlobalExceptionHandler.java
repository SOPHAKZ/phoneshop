package phone.shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException e){
		//ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), e.getMessage());
		ApiResponse r = new ApiResponse(HttpStatus.BAD_REQUEST,e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(r);
	}

	@ExceptionHandler(ApiException.class)
	public ResponseEntity<?> handleApiException(ApiException e) {
//		ErrorResponse errorResponse = new ErrorResponse(e.getStatus().getReasonPhrase(),e.getMessage());
		ApiResponse r = new ApiResponse(e.getStatus(),e.getMessage());

		return ResponseEntity.status(e.getStatus()).body(r);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
//		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), "Malformed JSON request");
		ApiResponse r = new ApiResponse(HttpStatus.BAD_REQUEST,e.getMessage());

		return ResponseEntity.badRequest().body(r);
	}

	@ExceptionHandler(ResourceNotFoundResponse.class)
	public ResponseEntity<?> handleHttpMessageNotReadableException(ResourceNotFoundResponse e) {
//		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), "Malformed JSON request");
		ApiResponse r = new ApiResponse(HttpStatus.BAD_REQUEST,e.getMessage());

		return ResponseEntity.badRequest().body(r);
	}




}
