package retail.infrastructure.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import retail.Application;

/**
 * @author Loic Talhouarne
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class MerchandiseIntakeControllerTest {
	@Autowired
	private WebApplicationContext ctx;
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testValidPostCall() throws Exception{
		mockMvc.perform(post("/merchandise/items")
		.contentType(MediaType.APPLICATION_JSON)
		.content(validJson()))
		.andExpect(status().isOk());
	}
	
	@Test
	public void testInvalidPostCallProductNameTooShort() throws Exception{
		MvcResult result = mockMvc.perform(post("/merchandise/items")
		.contentType(MediaType.APPLICATION_JSON)
		.content(invalidJsonProductNameTooShort()))
		.andExpect(status().isUnprocessableEntity()).andReturn();
		
		assertEquals(result.getResponse().getContentAsString(), RetailConstants.PRODUCT_NAME_TOO_SHORT_ERROR);
	}
	
	@Test
	public void testInvalidPostCallBarCodeTooLong() throws Exception{
		MvcResult result = mockMvc.perform(post("/merchandise/items")
		.contentType(MediaType.APPLICATION_JSON)
		.content(invalidJsonBarCodeTooLong()))
		.andExpect(status().isUnprocessableEntity()).andReturn();
		
		assertEquals(result.getResponse().getContentAsString(), RetailConstants.BAR_CODE_TOO_LONG_ERROR);
	}
	
	@Test
	public void testInvalidCategoryTooShort() throws Exception{
		MvcResult result = mockMvc.perform(post("/merchandise/items")
		.contentType(MediaType.APPLICATION_JSON)
		.content(invalidJsonCategoryTooShort()))
		.andExpect(status().isUnprocessableEntity()).andReturn();
		
		assertEquals(result.getResponse().getContentAsString(), RetailConstants.CATEGORY_TOO_SHORT_ERROR);
	}
	
	@Test
	public void testInvalidDescriptionCategoryTooShort() throws Exception{
		MvcResult result = mockMvc.perform(post("/merchandise/items")
		.contentType(MediaType.APPLICATION_JSON)
		.content(invalidJsonDescriptionTooShort()))
		.andExpect(status().isUnprocessableEntity()).andReturn();
		
		assertEquals(result.getResponse().getContentAsString(), RetailConstants.DESCRIPTION_TOO_SHORT_ERROR);
	}
	
	@Test
	public void testInvalidPriceTooLarge() throws Exception{
		MvcResult result = mockMvc.perform(post("/merchandise/items")
		.contentType(MediaType.APPLICATION_JSON)
		.content(invalidJsonPriceTooLarge()))
		.andExpect(status().isUnprocessableEntity()).andReturn();
		
		assertEquals(result.getResponse().getContentAsString(), RetailConstants.PRICE_TOO_LARGE_ERROR);
	}
	
	@Test
	public void testInvalidLinkIsTooShort() throws Exception{
		MvcResult result = mockMvc.perform(post("/merchandise/items")
		.contentType(MediaType.APPLICATION_JSON)
		.content(invalidJsonLinkIsTooShort()))
		.andExpect(status().isUnprocessableEntity()).andReturn();
		
		assertEquals(result.getResponse().getContentAsString(), RetailConstants.LINK_TOO_SHORT_ERROR);
	}
	
	@Test
	public void testInvalidPostCallAvailabilityIsNotExpectedValue() throws Exception{
		MvcResult result = mockMvc.perform(post("/merchandise/items")
		.contentType(MediaType.APPLICATION_JSON)
		.content(invalidJsonAvailabilityIsNotAnExpectedValue()))
		.andExpect(status().isUnprocessableEntity()).andReturn();
		
		assertEquals(result.getResponse().getContentAsString(), RetailConstants.AVAILABLE_ERROR);
	}
	
	@Test
	public void testInvalidPostCallFeaturedIsNotExpectedValue() throws Exception{
		MvcResult result = mockMvc.perform(post("/merchandise/items")
		.contentType(MediaType.APPLICATION_JSON)
		.content(invalidJsonFeaturedIsNotExpectedValue()))
		.andExpect(status().isUnprocessableEntity()).andReturn();
		
		assertEquals(result.getResponse().getContentAsString(), RetailConstants.WRONG_FEATURED_ERROR);
	}
	
	@Test
	public void testInvalidPostCallMissingAllArguments() throws Exception{
		MvcResult result = mockMvc.perform(post("/merchandise/items")
				.contentType(MediaType.APPLICATION_JSON)
				.content(invalidJsonNoArguments()))
				.andExpect(status().isUnprocessableEntity()).andReturn();
		
		//There is a need to check whether it contains pieces of String because the validation's order changes
		//every time it runs
		assertTrue(result.getResponse().getContentAsString().contains(RetailConstants.AVAILABILITY_NULL_ERROR)
				   && result.getResponse().getContentAsString().contains(RetailConstants.DESCRIPTION_NULL_ERROR)
				   && result.getResponse().getContentAsString().contains(RetailConstants.FEATURED_NULL_ERROR)
				   && result.getResponse().getContentAsString().contains(RetailConstants.IMAGE_URL_NULL_ERROR)
				   && result.getResponse().getContentAsString().contains(RetailConstants.MERCHANDISE_CATEGORY_NULL_ERROR)
				   && result.getResponse().getContentAsString().contains(RetailConstants.PRICE_NULL_ERROR)
				   && result.getResponse().getContentAsString().contains(RetailConstants.INVALID_REQUEST)
				   && result.getResponse().getContentAsString().contains(RetailConstants.PRODUCT_NAME_NULL_ERROR)
				   && result.getResponse().getContentAsString().contains(RetailConstants.SHIPPING_COST_NULL_ERROR)
				   && result.getResponse().getContentAsString().length() == 1312);
	}
	
	
	private String validJson(){
		return "{\"productName\":\"product\", \"price\": 100, \"barCode\": 123456789, \"description\": \"this is a description\", \"merchandiseCategory\": \"category\", \"availability\": \"available\", \"shippingCost\": 100,  \"featured\":\"N\",\"imageUrl\": \"http://test.com\"}";
	}
	
	private String invalidJsonProductNameTooShort(){
		return "{\"productName\":\"p\", \"price\": 100, \"barCode\": 123456789, \"description\": \"this is a description\", \"merchandiseCategory\": \"category\", \"availability\": \"available\", \"shippingCost\": 100,  \"featured\":\"Y\",\"imageUrl\": \"http://test.com\"}";
	}
	
	private String invalidJsonPriceTooLarge(){
		return "{\"productName\":\"product\", \"price\": 1000000000, \"barCode\": 123456789, \"description\": \"this is a description\", \"merchandiseCategory\": \"category\", \"availability\": \"available\", \"shippingCost\": 100,  \"featured\":\"Y\",\"imageUrl\": \"http://test.com\"}";
	}
	
	private String invalidJsonBarCodeTooLong(){
		return "{\"productName\":\"product\", \"price\": 10000, \"barCode\": 1234567899, \"description\": \"this is a description\", \"merchandiseCategory\": \"category\", \"availability\": \"available\", \"shippingCost\": 100,  \"featured\":\"Y\",\"imageUrl\": \"http://test.com\"}";
	}
	
	private String invalidJsonDescriptionTooShort(){
		return "{\"productName\":\"productName\", \"price\": 1000, \"barCode\": 123456789, \"description\": \"t\", \"merchandiseCategory\": \"category\", \"availability\": \"available\", \"shippingCost\": 100,  \"featured\":\"Y\",\"imageUrl\": \"http://test.com\"}";
	}
	
	private String invalidJsonCategoryTooShort(){
		return "{\"productName\":\"productName\", \"price\": 1000, \"barCode\": 123456789, \"description\": \"this is a description\", \"merchandiseCategory\": \"c\", \"availability\": \"available\", \"shippingCost\": 100,  \"featured\":\"Y\",\"imageUrl\": \"http://test.com\"}";
	}
	
	private String invalidJsonAvailabilityIsNotAnExpectedValue(){
		return "{\"productName\":\"productName\", \"price\": 1000, \"barCode\": 123456789, \"description\": \"this is a description\", \"merchandiseCategory\": \"category\", \"availability\": \"a\", \"shippingCost\": 100,  \"featured\":\"Y\",\"imageUrl\": \"http://test.com\"}";
	}
	
	private String invalidJsonFeaturedIsNotExpectedValue(){
		return "{\"productName\":\"productName\", \"price\": 1000, \"barCode\": 123456789, \"description\": \"this is a description\", \"merchandiseCategory\": \"category\", \"availability\": \"available\", \"shippingCost\": 100,  \"featured\":\"something\",\"imageUrl\": \"http://test.com\"}";
	}
	
	private String invalidJsonLinkIsTooShort(){
		return "{\"productName\":\"productName\", \"price\": 1000, \"barCode\": 123456789, \"description\": \"this is a description\", \"merchandiseCategory\": \"category\", \"availability\": \"available\", \"shippingCost\": 100,  \"featured\":\"Y\",\"imageUrl\": \"http\"}";
	}
	private String invalidJsonNoArguments(){
		return "{}";
	}
}
