package phone.shop.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException e){
		// Extract the constraint violation message
		Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		List<String> violationMessages = violations.stream()
				.map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
				.collect(Collectors.toList());

		// Create ApiResponse with a custom message
		ApiResponse response = new ApiResponse(HttpStatus.BAD_REQUEST, "Validation failed: " + violationMessages);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(response);
	}

//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
//		List<String> errors = ex.getBindingResult().getFieldErrors()
//				.stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
//		return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
//	}
//
//	private Map<String, List<String>> getErrorsMap(List<String> errors) {
//		Map<String, List<String>> errorResponse = new HashMap<>();
//		errorResponse.put("errors", errors);
//		return errorResponse;
//	}
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
		ApiResponse r = new ApiResponse(HttpStatus.NOT_FOUND,e.getMessage());

		return ResponseEntity.badRequest().body(r);
	}


	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<?> dataIntegrity(ResourceNotFoundResponse e) {
//		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), "Malformed JSON request");
		ApiResponse r = new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());

		return ResponseEntity.badRequest().body(r);
	}


}
