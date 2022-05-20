package com.example.adminservice.payload;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TemplateDto {

    @NotNull(message = "required field")
    private String name;

    @NotNull(message = "required field")
    private Integer count; // default

    @NotNull(message = "required field")
    private boolean priceByPlace;  // joy bo'yicha

    @NotNull(message = "required field")
    private Double maxPrice;

    @NotNull(message = "required field")
    private Double minPrice;

//    @NotNull(message = "required field")
//        private Integer countOfChairsInRaw;

    private List<RawDto> rawDtoList;
}
