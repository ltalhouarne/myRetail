package retail.core.domain;

import java.math.BigDecimal;

/**
 * @author Loic Talhouarne
 *
 *         {@code Interface} representing a product sold by myRetail.
 *         
 */
public interface Product {

	public String getProductName();

	public BigDecimal getPrice();

	public int getBarCode();

	public String getDescription();
}
