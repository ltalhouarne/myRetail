package retail.infrastructure.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import retail.core.dtos.MerchandiseItemDTO;
import retail.core.repositories.MerchandiseRespository;
import retail.core.services.MerchandiseActionService;

/**
 * @author Loic Talhouarne
 * 
 *         Represents Intake Services.
 *
 */
public class MerchandiseIntakeService implements MerchandiseActionService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MerchandiseIntakeService.class);

	@Autowired
	private MerchandiseRespository repository;

	public void saveMerchandiseItem(MerchandiseItemDTO merchandiseItem) {
		LOGGER.debug("Saving MerchandiseItem: " + merchandiseItem.toString());
		merchandiseItem.setId(null);
		repository.save(merchandiseItem);
		LOGGER.debug("MerchandiseItem saved.");

	}
}