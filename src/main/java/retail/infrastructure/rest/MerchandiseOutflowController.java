package retail.infrastructure.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import retail.core.dtos.MerchandiseItemDTO;
import retail.core.exception.MerchandiseItemNotFoundException;
import retail.infrastructure.services.MerchandiseOutflowService;

import java.util.Collection;

/**
 * @author Loic Talhouarne
 *         <p>
 *         Represents Outflow {@code Controller}
 */
@RestController
@RequestMapping(value = "/merchandise")
public class MerchandiseOutflowController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MerchandiseOutflowController.class);

    @Autowired
    private MerchandiseOutflowService outflowService;

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public Collection<MerchandiseItemDTO> findItems() {
        LOGGER.debug("findItems request received...");

        Collection<MerchandiseItemDTO> listOfMerchandiseItems = outflowService.returnMerchandiseItems();

        if (listOfMerchandiseItems == null || listOfMerchandiseItems.isEmpty()) {
            LOGGER.debug("Items could not be found");
            throw new MerchandiseItemNotFoundException("Items could not be found");
        }

        LOGGER.debug("Request processed properly.");

        return listOfMerchandiseItems;
    }

    @RequestMapping(value = "/items/{barCode}", method = RequestMethod.GET)
    public MerchandiseItemDTO findItem(@PathVariable Integer barCode) {
        LOGGER.debug("findItem request received with barCode: " + barCode + "...");
        MerchandiseItemDTO merchandiseItem = outflowService.returnMerchandiseItem(barCode);

        if (merchandiseItem == null) {
            LOGGER.debug("Item could not be found");
            throw new MerchandiseItemNotFoundException("Item could not be found");
        }

        LOGGER.debug("Request processed properly.");

        return merchandiseItem;
    }

    @RequestMapping(value = "/items/featured", method = RequestMethod.GET)
    public MerchandiseItemDTO findItem() {
        LOGGER.debug("findItem request received...");
        MerchandiseItemDTO merchandiseItem = outflowService.returnFeaturedMerchandiseItem();

        if (merchandiseItem == null) {
            LOGGER.debug("Featured item could not be found.");
            throw new MerchandiseItemNotFoundException("Featured item could not be found.");
        }

        LOGGER.debug("Request processed properly.");

        return merchandiseItem;
    }
}
