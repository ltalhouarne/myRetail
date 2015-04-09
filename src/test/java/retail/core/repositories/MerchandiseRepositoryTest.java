package retail.core.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import retail.Application;
import retail.core.dtos.MerchandiseItemDTO;

/**
 * @author Loic Talhouarne
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class MerchandiseRepositoryTest {

	@Autowired
	MerchandiseRespository repository;

	@After
	public void tearDown() {
		repository.deleteAll();
	}

	@Test
	public void testSave() {
		MerchandiseItemDTO merchandiseItem = new MerchandiseItemDTO("productName", new BigDecimal(100), 123456789, "Description", "Category", "available", new BigDecimal(0), "http://google.com", "bundle", "N");

		repository.save(merchandiseItem);
		assertNotNull(merchandiseItem.getId());

		assertTrue(repository.findAll().iterator().hasNext());
	}

	@Test
	public void testFindAll() {
		List<MerchandiseItemDTO> results = repository.findAll();
		assertTrue(results.iterator().hasNext());
	}

	@Test
	public void testDeleteID() {
		MerchandiseItemDTO merchandiseItem = new MerchandiseItemDTO("productName", new BigDecimal(100), 123456789, "Description", "Category", "available", new BigDecimal(0), "http://google.com", "bundle", "N");
		repository.save(merchandiseItem);
		assertTrue(repository.findAll().iterator().hasNext());
		repository.delete(merchandiseItem.getId());
		assertFalse(repository.findAll().iterator().hasNext());
	}
	
	@Test
	public void testFeaturedFinding() {
		MerchandiseItemDTO featuredMerchandiseItem = new MerchandiseItemDTO("featuredProductName", new BigDecimal(100), 123456789, "Description", "Category", "available", new BigDecimal(0), "http://google.com", "bundle", "Y");
		repository.save(featuredMerchandiseItem);
		MerchandiseItemDTO notFeaturedMerchandiseItem = new MerchandiseItemDTO("productName", new BigDecimal(100), 123456789, "Description", "Category", "available", new BigDecimal(0), "http://google.com", "bundle", "N");
		repository.save(notFeaturedMerchandiseItem);
		assertEquals(featuredMerchandiseItem.toString(), repository.findByFeatured("Y").toString());
	}
	
	@Test
	public void testFindingByBarCode() {
		MerchandiseItemDTO featuredMerchandiseItem = new MerchandiseItemDTO("featuredProductName", new BigDecimal(100), 123456789, "Description", "Category", "available", new BigDecimal(0), "http://google.com", "bundle", "Y");
		repository.save(featuredMerchandiseItem);
		MerchandiseItemDTO notFeaturedMerchandiseItem = new MerchandiseItemDTO("productName", new BigDecimal(100), 123456790, "Description", "Category", "available", new BigDecimal(0), "http://google.com", "bundle", "N");
		repository.save(notFeaturedMerchandiseItem);
		assertEquals(featuredMerchandiseItem.toString(), repository.findByBarCode(123456789).toString());
	}
}