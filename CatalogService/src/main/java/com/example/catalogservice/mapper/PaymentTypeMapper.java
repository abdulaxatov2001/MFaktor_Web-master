package com.example.catalogservice.mapper;

import com.example.catalogservice.entity.PaymentType;
import com.example.catalogservice.payload.PaymentTypeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentTypeMapper {
    @Mapping(source = "paymentColor.id",target ="paymentColorId" )
    PaymentTypeDto toDto(PaymentType paymentType);
    @Mapping(source = "paymentColorId",target ="paymentColor.id" )
    PaymentType toEntity(PaymentTypeDto paymentTypeDto);
}
