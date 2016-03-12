package retail.infrastructure.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import retail.core.dtos.MerchandiseItemDTO;
import retail.core.repositories.MerchandiseRespository;
import retail.core.services.MerchandiseActionService;

import java.util.Collection;

/**
 * @author Loic Talhouarne
 *         <p>
 *         Represents outflow services.
 */
public class MerchandiseOutflowService implements MerchandiseActionService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MerchandiseActionService.class);

    @Autowired
    private MerchandiseRespository repository;

    public Collection<MerchandiseItemDTO> returnMerchandiseItems() {
        LOGGER.debug("Finding all merchandise items from repository...");
        return repository.findAll();
    }

    public MerchandiseItemDTO returnMerchandiseItem(int barCode) {
        LOGGER.debug("Finding merchandiseItem by barCode...");
        return repository.findByBarCode(barCode);
    }

    public MerchandiseItemDTO returnFeaturedMerchandiseItem() {
        LOGGER.debug("Finding featured item...");
        return repository.findByFeatured("Y");
    }
}
