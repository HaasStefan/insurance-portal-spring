package com.ngjournal.insuranceportal.converter;

import com.ngjournal.insuranceportal.domain.Contract;
import com.ngjournal.insuranceportal.model.ContractDto;
import com.ngjournal.insuranceportal.model.ContractStatusDto;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

public class ContractToContractDtoConverter implements Converter<Contract, ContractDto> {
    @Override
    public ContractDto convert(MappingContext<Contract, ContractDto> context) {
        Contract source = context.getSource();
        ContractDto destination = context.getDestination();

        if (destination == null) {
            destination = new ContractDto();
        }

        destination.setId(source.getId());
        destination.setPolicyNumber(source.getPolicyNumber());
        destination.setInsuranceStartOn(source.getInsuranceStartOn().toString());
        destination.setCustomer(source.getCustomerId());
        destination.setStatus(ContractStatusDto.valueOf(source.getStatus().name()));

        return destination;
    }
}
