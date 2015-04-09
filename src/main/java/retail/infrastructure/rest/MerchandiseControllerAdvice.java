package retail.infrastructure.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import retail.core.exception.InvalidMerchandiseItemRequestException;
import retail.core.exception.MerchandiseItemNotFoundException;
import retail.core.validation.ErrorGlobal;
import retail.core.validation.ErrorResource;
import retail.core.validation.FieldErrorResource;

/**
 * @author Loic Talhouarne
 * 
 *         Controller advice for all thrown {@code Exception} instances.
 *
 */
@ControllerAdvice
public class MerchandiseControllerAdvice extends ResponseEntityExceptionHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(MerchandiseControllerAdvice.class);
	private HttpHeaders headers = new HttpHeaders();

	/**
	 * @param {@code InvalidMerchandiseItemRequestException} ire
	 * @return {@code ResponseEntity} with
	 *         {@code HttpStatus.UNPROCESSABLE_ENTITY} when
	 *         {@code InvalidMerchandiseItemRequestException} {@code Exception}
	 *         is caught.
	 */
	@ExceptionHandler({ InvalidMerchandiseItemRequestException.class })
	@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
	@ResponseBody
	public ResponseEntity<Object> handleInvalidRequest(InvalidMerchandiseItemRequestException ire) {
		LOGGER.debug("Invalid Request...");

		List<FieldErrorResource> fieldErrorResources = new ArrayList<>();

		List<FieldError> fieldErrors = ire.getErrors().getFieldErrors();

		for (FieldError fieldError : fieldErrors) {
			FieldErrorResource fieldErrorResource = new FieldErrorResource();
			fieldErrorResource.setResource(fieldError.getObjectName());
			fieldErrorResource.setField(fieldError.getField());
			fieldErrorResource.setCode(fieldError.getCode());
			fieldErrorResource.setMessage(fieldError.getDefaultMessage());
			fieldErrorResources.add(fieldErrorResource);
		}

		ErrorResource error = new ErrorResource("InvalidRequest", ire.getMessage());
		error.setFieldErrors(fieldErrorResources);

		return new ResponseEntity<Object>(error, getHeaders(), HttpStatus.UNPROCESSABLE_ENTITY);
	}

	/**
	 * @param {@code MerchandiseItemNotFoundException} ire
	 * @return {@code ResponseEntity} with {@code HttpStatus.BAD_REQUEST} when
	 *         {@code MerchandiseItemNotFoundException} {@code Exception} is
	 *         caught.
	 */
	@ExceptionHandler({ MerchandiseItemNotFoundException.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ResponseEntity<Object> handleREcordNotFound(MerchandiseItemNotFoundException ire) {
		LOGGER.debug("Invalid Request: record not found...");

		ErrorGlobal error = new ErrorGlobal("RecordNotFound", ire.getMessage());

		return new ResponseEntity<Object>(error, getHeaders(), HttpStatus.BAD_REQUEST);
	}

	/**
	 * @param {@code Exception} ire
	 * @return {@code ResponseEntity} with {@code HttpStatus.BAD_REQUEST} when
	 *         general {@code Exception} is caught.
	 */
	@ExceptionHandler({ Exception.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ResponseEntity<Object> handleFatalError(Exception ire) {
		LOGGER.debug("Invalid Request: Fatal error...");

		ErrorGlobal error = new ErrorGlobal("FatalException", ire.getMessage());

		return new ResponseEntity<Object>(error, getHeaders(), HttpStatus.BAD_REQUEST);
	}

	/**
	 * @return {@code HttpHeaders} with {@code MediaType.APPLICATION_JSON}
	 */
	private HttpHeaders getHeaders() {
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}
}
