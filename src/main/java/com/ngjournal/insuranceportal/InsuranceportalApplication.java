package com.ngjournal.insuranceportal;

import com.ngjournal.insuranceportal.converter.ContractDtoToContractConverter;
import com.ngjournal.insuranceportal.converter.ContractToContractDtoConverter;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InsuranceportalApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceportalApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addConverter(new ContractToContractDtoConverter());
		modelMapper.addConverter(new ContractDtoToContractConverter());
		return modelMapper;
	}
}
