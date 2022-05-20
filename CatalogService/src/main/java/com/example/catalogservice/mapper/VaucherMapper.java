package com.example.catalogservice.mapper;

import com.example.catalogservice.entity.Vaucher;
import com.example.catalogservice.payload.VaucherDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VaucherMapper {
   VaucherDto toDto(Vaucher vaucher);
   Vaucher toEntity(VaucherDto vaucherDto);
}
