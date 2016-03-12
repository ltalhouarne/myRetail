package retail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import retail.infrastructure.services.MerchandiseIntakeService;
import retail.infrastructure.services.MerchandiseOutflowService;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Loic Talhouarne
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTest {
    @Autowired
    ApplicationContext context;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testThatApplicationContextContainsOutflowService() {
        assertNotNull(context.getBean("outflowService"));
        assertTrue(context.getBean("outflowService") instanceof MerchandiseOutflowService);
    }

    @Test
    public void testThatApplicationContextContainsIntakeService() {
        assertNotNull(context.getBean("intakeService"));
        assertTrue(context.getBean("intakeService") instanceof MerchandiseIntakeService);
    }
}
