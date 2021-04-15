package ru.bellintegrator;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BellIntegratorProjectApplication {

	/**
	 * Бин ModelMapper, который отвечает за маппинг между DTO и Entity
	 * @return объект класса ModelMapper
	 */
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setSkipNullEnabled(true);
		return modelMapper;
	}

	public static void main(String[] args) {
		SpringApplication.run(BellIntegratorProjectApplication.class, args);
	}

}
