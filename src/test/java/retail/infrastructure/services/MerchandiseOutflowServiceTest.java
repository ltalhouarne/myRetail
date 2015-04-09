package retail.infrastructure.services;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.SpringApplicationConfiguration;

import retail.Application;
import retail.core.repositories.MerchandiseRespository;



/**
 * @author Loic Talhouarne
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class MerchandiseOutflowServiceTest {
	
	@Mock
    private static MerchandiseRespository repository;
	
	@InjectMocks
	private static MerchandiseOutflowService service = new MerchandiseOutflowService();
	
	@After
	public void tearDown() {
		repository.deleteAll();
	}
	
	@Test
	public void testMerchandiseOutflowServiceFindByFeatured(){
		service.returnFeaturedMerchandiseItem();
		Mockito.verify(repository).findByFeatured("Y");
	}
	
	@Test
	public void testMerchandiseOutflowServiceFindByBarCode(){
		service.returnMerchandiseItem(339222908);
		Mockito.verify(repository).findByBarCode(339222908);
	}
	
	@Test
	public void testMerchandiseOutflowServiceFindAll(){
		service.returnMerchandiseItems();
		Mockito.verify(repository).findAll();
	}
}
