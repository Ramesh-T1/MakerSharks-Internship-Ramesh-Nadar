package makersharks.RESTAPI_Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@SpringBootApplication
//@SecurityScheme(name = "MakerSharks_API", scheme = "bearer", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class RestapiProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapiProjectApplication.class, args);
	}

}
