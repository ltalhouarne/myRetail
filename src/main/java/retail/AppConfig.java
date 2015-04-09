package retail;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import retail.infrastructure.services.MerchandiseIntakeService;
import retail.infrastructure.services.MerchandiseOutflowService;

/**
 * @author Loic Talhouarne
 *
 *         {@code bean} configuration.
 */
@Component
public class AppConfig {

	@Bean
	public MerchandiseIntakeService intakeService() {
		return new MerchandiseIntakeService();
	}

	@Bean
	public MerchandiseOutflowService outflowService() {
		return new MerchandiseOutflowService();
	}
}
