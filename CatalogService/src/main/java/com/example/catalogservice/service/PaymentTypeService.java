package com.example.catalogservice.service;

import com.example.catalogservice.entity.PaymentColor;
import com.example.catalogservice.entity.PaymentType;
import com.example.catalogservice.payload.ApiResponse;
import com.example.catalogservice.payload.PaymentTypeDto;
import com.example.catalogservice.repository.PaymentColorRepository;
import com.example.catalogservice.repository.PaymentTyPeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentTypeService {
    final PaymentTyPeRepository paymentTypeRepository;
    final PaymentColorRepository paymentColorRepository;

    public ApiResponse add(PaymentTypeDto dto) {
        if (paymentTypeRepository.existsByName(dto.getName())) {
            return new ApiResponse("This paymentType already exists", false);
        }

        Optional<PaymentColor> optionalPaymentColor = paymentColorRepository.findById(dto.getPaymentColorId());
        if (optionalPaymentColor.isPresent()) {
            PaymentColor paymentColor = optionalPaymentColor.get();
            PaymentType paymentType = new PaymentType();
            paymentType.setPaymentColor(paymentColor);
            paymentType.setName(dto.getName());
            PaymentType save = paymentTypeRepository.save(paymentType);
            return new ApiResponse("Added successfully", true, save);

        }
        return new ApiResponse("PaymentColor not found", false);

    }

    public ApiResponse edit(Integer id, PaymentTypeDto dto) {
        if (paymentTypeRepository.existsByNameAndIdNot(dto.getName(), id)) {
            return new ApiResponse("This paymentType already exists", false);

        }
        Optional<PaymentType> optionalPaymentType = paymentTypeRepository.findById(id);
        if (optionalPaymentType.isPresent()) {
            PaymentType paymentType = optionalPaymentType.get();
            paymentType.setName(dto.getName());
            paymentType.setActive(dto.isActive());
            paymentType.setPaymentColor(paymentColorRepository.findById(dto.getPaymentColorId()).get());
            PaymentType save = paymentTypeRepository.save(paymentType);

            return new ApiResponse("Updated", true, save);

        }
        return new ApiResponse("PaymentType not found", true);


    }

    public ApiResponse getAll() {
        List<PaymentType> all = paymentTypeRepository.findAll();
        return new ApiResponse("All", true, all);
    }

    public ApiResponse getOne(Integer id) {
        Optional<PaymentType> byId = paymentTypeRepository.findById(id);
        if (byId.isEmpty()) {
            return new ApiResponse("not found", false);
        }
        return new ApiResponse("topildi", true, byId.get());
    }

}
