package lk.zerocode.library.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableCaching
@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Library Management System",
				version = "1.0",
				description = "Library Management System Documentation"
		),

		servers = @Server(
				url = "http://localhost:8080",
				description = "Library Management System Documentation url"
		)
)
public class LibraryManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApiApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
