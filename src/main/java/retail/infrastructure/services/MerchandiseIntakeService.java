package retail.infrastructure.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DuplicateKeyException;
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
		try {
			repository.save(merchandiseItem);
		}catch(DuplicateKeyException e){
			LOGGER.error("The merchandise item already exists");
		}
		LOGGER.debug("MerchandiseItem saved.");
	}
}