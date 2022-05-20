package com.example.catalogservice.mapper;

import com.example.catalogservice.entity.AdsSource;
import com.example.catalogservice.payload.AdsSourceDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface AdsSourceMapper {

    // @Mapping(source = "active",target = "isActive")
    AdsSourceDto toDto(AdsSource adsSource);

    //@Mapping(source = "isActive",target = "active")
    AdsSource fromDto(AdsSourceDto adsSourceDto);


}
