package retail.infrastructure.services;

import java.math.BigDecimal;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.SpringApplicationConfiguration;

import retail.Application;
import retail.core.dtos.MerchandiseItemDTO;
import retail.core.repositories.MerchandiseRespository;



/**
 * @author Loic Talhouarne
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class MerchandiseIntakeServiceTest {
	@Mock
    private static MerchandiseRespository repository;
	
	@InjectMocks
	private static MerchandiseIntakeService service = new MerchandiseIntakeService();
	
	private static MerchandiseItemDTO product;
	
	@Before
	public void setup() {
	        MockitoAnnotations.initMocks(this);
			product = new MerchandiseItemDTO("productName", new BigDecimal(100.99), 123456789, "Description", "Category", "available", new BigDecimal(0), "http://google.com", "bundle", "N"); 
	}
	
	@AfterClass
	public static void tearDown() {
		repository.deleteAll();
	}
	
	@Test
	public void testMerchandiseIntakePostItem(){
		service.saveMerchandiseItem(product);
		Mockito.verify(repository).save(product);
	}
}
