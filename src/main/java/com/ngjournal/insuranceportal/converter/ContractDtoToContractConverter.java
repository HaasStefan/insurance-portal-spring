package com.ngjournal.insuranceportal.converter;

import com.ngjournal.insuranceportal.domain.Contract;
import com.ngjournal.insuranceportal.domain.ContractStatus;
import com.ngjournal.insuranceportal.model.ContractDto;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ContractDtoToContractConverter implements Converter<ContractDto, Contract> {
    @Override
    public Contract convert(MappingContext<ContractDto, Contract> mappingContext) {
        ContractDto source = mappingContext.getSource();
        Contract destination = mappingContext.getDestination();

        if (destination == null) {
            destination = new Contract();
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        destination.setId(source.getId());
        destination.setPolicyNumber(source.getPolicyNumber());
        try {
            destination.setInsuranceStartOn(
                    source.getInsuranceStartOn() == null
                            ? null
                            : dateFormat.parse(source.getInsuranceStartOn())
            );
        } catch (ParseException e) {
            // todo create custom exception
            throw new RuntimeException(e);
        }
        destination.setCustomerId(source.getCustomer());
        destination.setStatus(ContractStatus.valueOf(source.getStatus().name()));

        return destination;
    }
}
