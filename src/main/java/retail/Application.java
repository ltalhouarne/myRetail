package retail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Loic Talhouarne
 *
 */
@SpringBootApplication
@EnableJpaRepositories
public class Application {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.setBanner(new AppCustomBanner());
		app.run(args);
	}
}
