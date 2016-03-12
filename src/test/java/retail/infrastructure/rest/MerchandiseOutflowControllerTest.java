package retail.infrastructure.rest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import retail.Application;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Loic Talhouarne
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class MerchandiseOutflowControllerTest {
    @Autowired
    private WebApplicationContext ctx;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testValidGetCall() throws Exception {
        mockMvc.perform(get("/merchandise/items"))
                .andExpect(status().isOk());
    }

    @Test
    public void testValidGetCallWithExistingId() throws Exception {
        mockMvc.perform(get("/merchandise/items/339222908"))
                .andExpect(status().isOk());
    }

    @Test
    public void testInvalidGetCallWithNonExistingId() throws Exception {
        MvcResult result = mockMvc.perform(get("/merchandise/items/99"))
                .andExpect(status().isBadRequest()).andReturn();

        assertEquals(result.getResponse().getContentAsString(), RetailConstants.NOT_FOUND_ERROR);
    }

    @Test
    public void testValidGetCallFeaturedItem() throws Exception {
        mockMvc.perform(get("/merchandise/items/featured"))
                .andExpect(status().isOk());
    }
}
