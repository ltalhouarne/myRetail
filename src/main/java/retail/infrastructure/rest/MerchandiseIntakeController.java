package retail.infrastructure.rest;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import retail.core.dtos.MerchandiseItemDTO;
import retail.core.exception.InvalidMerchandiseItemRequestException;
import retail.infrastructure.services.MerchandiseIntakeService;

/**
 * @author Loic Talhouarne
 * 
 *         Represents Intake {@code Controller}
 *
 */
@RestController
@RequestMapping(value = "/merchandise")
public class MerchandiseIntakeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MerchandiseIntakeController.class);

	@Autowired
	private MerchandiseIntakeService intakeService;

	@RequestMapping(value = "/items", method = RequestMethod.POST)
	public ResponseEntity<String> saveItem(@RequestBody @Valid MerchandiseItemDTO merchandiseItem, Errors errors) {
		LOGGER.debug("saveItem request received...");

		if (errors.hasErrors()) {
			throw new InvalidMerchandiseItemRequestException("Invalid item: " + merchandiseItem.toString(), errors);
		}

		intakeService.saveMerchandiseItem(merchandiseItem);

		LOGGER.debug("Item saved properly...");

		return new ResponseEntity<String>(HttpStatus.OK);
	}
}