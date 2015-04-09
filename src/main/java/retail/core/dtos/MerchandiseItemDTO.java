package retail.core.dtos;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import retail.core.domain.Product;
import retail.core.validation.Available;
import retail.core.validation.Featured;

/**
 * @author Loic Talhouarne
 *
 *         Represents a merchandise item sold by myRetail.
 *         
 */
@Entity
@Table(name = "merchandise_products")
public class MerchandiseItemDTO implements Product {
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	@Size(min = 2, message = "productName must be at least 2 characters long.")
	@Column
	private String productName;

	@NotNull
	@DecimalMax(value = "99999.99", message = "The decimal value can not be more than 99999.99.")
	@Column
	private BigDecimal price;

	@NotNull
	@Digits(fraction = 0, integer = 9)
	@Column
	private int barCode;

	@NotNull
	@Size(min = 2, max = 4000, message = "description must be between 2 and 4000 characters long.")
	@Column
	private String description;

	@NotNull
	@Size(min = 2, max = 100, message = "merchandiseCategory must be at least 2 characters long.")
	@Column
	private String merchandiseCategory;

	@NotNull
	@Available
	@Column
	private String availability;

	@NotNull
	@DecimalMax(value = "99999.99", message = "The decimal value can not be more than 99999.99.")
	@Column
	private BigDecimal shippingCost;

	@NotNull
	@Size(min = 5, message = "imageUrl must be at least 5 characters long.")
	@Column
	private String imageUrl;

	@Size(min = 0, max = 1000, message = "bundle must be between 2 and 1000 characters long.")
	@Column
	private String bundle;

	@NotNull
	@Featured
	@Column
	private String featured;

	public MerchandiseItemDTO() {
	}

	public MerchandiseItemDTO(String productName, BigDecimal price, int barcode, String description, String merchandiseCategory, String availability, BigDecimal shippingCost, String imageUrl, String bundle, String featured) {
		this.productName = Objects.requireNonNull(productName, "productName cannot be null.");
		this.price = Objects.requireNonNull(price, "price cannot be null.");
		this.barCode = Objects.requireNonNull(barcode, "barCode cannot be null.");
		this.description = Objects.requireNonNull(description, "description cannot be null.");
		this.merchandiseCategory = Objects.requireNonNull(merchandiseCategory, "merchandiseCategory cannot be null.");
		this.availability = Objects.requireNonNull(availability, "availability cannot be null.");
		this.shippingCost = Objects.requireNonNull(shippingCost, "shipping cannot be null.");
		this.imageUrl = Objects.requireNonNull(imageUrl, "imageUrl cannot be null.");
		this.bundle = bundle;
		this.featured = Objects.requireNonNull(featured, "featured cannot be null");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String getProductName() {
		return productName;
	}

	@Override
	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public int getBarCode() {
		return barCode;
	}

	@Override
	public String getDescription() {
		return description;
	}

	public String getMerchandiseCategory() {
		return merchandiseCategory;
	}

	public String getAvailability() {
		return availability;
	}

	public BigDecimal getShippingCost() {
		return shippingCost;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getBundle() {
		return bundle;
	}

	public String getFeatured() {
		return featured;
	}

	public void setFeatured(String featured) {
		this.featured = featured;
	}

	@Override
	public String toString() {
		return "MerchandiseItem [id=" + id + ", productName=" + productName + ", price=" + price + ", barcode=" + barCode + ", description=" + description + ", merchandiseCategory=" + merchandiseCategory + ", availability=" + availability + ", shippingCost=" + shippingCost + ", imageUrl="
				+ imageUrl + ", bundle=" + bundle + ", featured=" + featured + "]";
	}
}
