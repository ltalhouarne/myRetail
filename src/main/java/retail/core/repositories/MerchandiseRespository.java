package retail.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import retail.core.dtos.MerchandiseItemDTO;

/**
 * @author Loic Talhouarne
 *         <p>
 *         Holds {@code MerchandiseItemDTO} data.
 */
public interface MerchandiseRespository extends JpaRepository<MerchandiseItemDTO, Integer> {
    /**
     * @param featured
     * @return featured {@code MerchandiseItemDTO}.
     */
    MerchandiseItemDTO findByFeatured(String featured);

    /**
     * @param barCode
     * @return {@code MerchandiseItemDTO} with corresponding barCode.
     */
    MerchandiseItemDTO findByBarCode(int barCode);
}
