package retail.core.domain;

import java.math.BigDecimal;

/**
 * @author Loic Talhouarne
 *         <p>
 *         {@code Interface} representing a product sold by myRetail.
 */
public interface Product {

    String getProductName();

    BigDecimal getPrice();

    int getBarCode();

    String getDescription();
}
