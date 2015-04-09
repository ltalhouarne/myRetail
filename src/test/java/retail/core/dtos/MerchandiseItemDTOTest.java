package retail.core.dtos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import retail.core.domain.Product;


/**
 * @author Loic Talhouarne
 *
 */
public class MerchandiseItemDTOTest {
	private Validator localValidatorFactory;
	
	@Before
	public void setup(){
		localValidatorFactory = Validation.buildDefaultValidatorFactory().getValidator();
	}
	
	@Test
	public void testValidMerchandiseDTO(){
		Product product = new MerchandiseItemDTO("productName", new BigDecimal(100.99), 123456789, "Description", "Category", "available", new BigDecimal(0), "http://google.com", "bundle", "N"); 
		Set<ConstraintViolation<Product>> violations = localValidatorFactory.validate(product);
		assertTrue(violations.isEmpty());
	}
	
	@Test
	public void testInvalidMerchandiseDTOProductNameTooShort(){
		Product product = new MerchandiseItemDTO("p", new BigDecimal(100.99), 123456789, "Description", "Category", "available", new BigDecimal(0), "http://google.com", "bundle", "N"); 
		Set<ConstraintViolation<Product>> violations = localValidatorFactory.validate(product);
		assertFalse(violations.isEmpty());

		assertEquals(1, violations.size());
		
		assertEquals(violations.iterator().next().getMessage(), "productName must be at least 2 characters long.");
	}
	
	@Test
	public void testInvalidMerchandiseDTOProductPriceTooLarge(){
		Product product = new MerchandiseItemDTO("productName", new BigDecimal(1000000.99), 123456789, "Description", "Category", "available", new BigDecimal(0), "http://google.com", "bundle", "N"); 
		Set<ConstraintViolation<Product>> violations = localValidatorFactory.validate(product);
		assertFalse(violations.isEmpty());

		assertEquals(1, violations.size());
		
		assertEquals(violations.iterator().next().getMessage(), "The decimal value can not be more than 99999.99.");
	}
	
	@Test
	public void testInvalidMerchandiseDTOProductBarCodeIsTooLong(){
		Product product = new MerchandiseItemDTO("productName", new BigDecimal(10000.99), 1234567899, "Description", "Category", "available", new BigDecimal(0), "http://google.com", "bundle", "N"); 
		Set<ConstraintViolation<Product>> violations = localValidatorFactory.validate(product);
		assertFalse(violations.isEmpty());

		assertEquals(1, violations.size());
		
		assertEquals(violations.iterator().next().getMessage(), "numeric value out of bounds (<9 digits>.<0 digits> expected)");
	}
	
	@Test
	public void testInvalidMerchandiseDTOProductDescriptionIsTooShort(){
		Product product = new MerchandiseItemDTO("productName", new BigDecimal(10000.99), 123456789, "a", "Category", "available", new BigDecimal(0), "http://google.com", "bundle", "N"); 
		Set<ConstraintViolation<Product>> violations = localValidatorFactory.validate(product);
		assertFalse(violations.isEmpty());

		assertEquals(1, violations.size());
		
		assertEquals(violations.iterator().next().getMessage(), "description must be between 2 and 4000 characters long.");
	}
	
	@Test
	public void testInvalidMerchandiseDTOProductCategoryIsTooShort(){
		Product product = new MerchandiseItemDTO("productName", new BigDecimal(10000.99), 123456789, "aaa", "c", "available", new BigDecimal(0), "http://google.com", "bundle", "N"); 
		Set<ConstraintViolation<Product>> violations = localValidatorFactory.validate(product);
		assertFalse(violations.isEmpty());

		assertEquals(1, violations.size());
		
		assertEquals(violations.iterator().next().getMessage(), "merchandiseCategory must be at least 2 characters long.");
	}

	@Test
	public void testInvalidMerchandiseDTOProductAvailibityIsNotAvailableOrUnavailable(){
		Product product = new MerchandiseItemDTO("productName", new BigDecimal(10000.99), 123456789, "aaa", "ca", "availablee", new BigDecimal(0), "http://google.com", "bundle", "N"); 
		Set<ConstraintViolation<Product>> violations = localValidatorFactory.validate(product);
		assertFalse(violations.isEmpty());

		assertEquals(1, violations.size());
		
		assertEquals(violations.iterator().next().getMessage(), "Availability can only be 'Available/Unavailable'");
	}
	
	@Test
	public void testInvalidMerchandiseDTOProductShippingCostIsTooHigh(){
		Product product = new MerchandiseItemDTO("productName", new BigDecimal(10000.99), 123456789, "aaa", "ca", "available", new BigDecimal(1111111111), "http://google.com", "bundle", "N"); 
		Set<ConstraintViolation<Product>> violations = localValidatorFactory.validate(product);
		assertFalse(violations.isEmpty());

		assertEquals(1, violations.size());
		
		assertEquals(violations.iterator().next().getMessage(), "The decimal value can not be more than 99999.99.");
	}
	
	@Test
	public void testInvalidMerchandiseDTOProductImageUrlIsTooShort(){
		Product product = new MerchandiseItemDTO("productName", new BigDecimal(10000.99), 123456789, "aaa", "ca", "available", new BigDecimal(1), "h", "bundle", "N"); 
		Set<ConstraintViolation<Product>> violations = localValidatorFactory.validate(product);
		assertFalse(violations.isEmpty());

		assertEquals(1, violations.size());
		
		assertEquals(violations.iterator().next().getMessage(), "imageUrl must be at least 5 characters long.");
	}
	
	@Test
	public void testInvalidMerchandiseDTOProductFeatureIsTooShort(){
		Product product = new MerchandiseItemDTO("productName", new BigDecimal(10000.99), 123456789, "aaa", "ca", "available", new BigDecimal(1), "http://", "bundle", ""); 
		Set<ConstraintViolation<Product>> violations = localValidatorFactory.validate(product);
		assertFalse(violations.isEmpty());

		assertEquals(1, violations.size());
		
		assertEquals(violations.iterator().next().getMessage(), "Featured can only be 'Y/N'");
	}
	
	@Test
	public void testInvalidMerchandiseDTOProductFeatureIsTooLong(){
		Product product = new MerchandiseItemDTO("productName", new BigDecimal(10000.99), 123456789, "aaa", "ca", "available", new BigDecimal(1), "http://", "bundle", "NN"); 
		Set<ConstraintViolation<Product>> violations = localValidatorFactory.validate(product);
		assertFalse(violations.isEmpty());

		assertEquals(1, violations.size());
		
		assertEquals(violations.iterator().next().getMessage(), "Featured can only be 'Y/N'");
	}
}
