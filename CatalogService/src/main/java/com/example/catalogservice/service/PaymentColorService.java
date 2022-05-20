package com.example.catalogservice.service;

import com.example.catalogservice.entity.PaymentColor;
import com.example.catalogservice.payload.ApiResponse;
import com.example.catalogservice.repository.PaymentColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentColorService {

    final PaymentColorRepository paymentColorRepository;


    public ApiResponse addPaymentColor(PaymentColor paymentColor) {
        if (paymentColorRepository.existsByName(paymentColor.getName())) {
            return new ApiResponse("paymentColor already exists with this name",false);
        }
        if (paymentColorRepository.existsByCode( paymentColor.getCode())) {
            return new ApiResponse("PaymentColor with this code already exists",false);
        }
        PaymentColor addPaymentColor=new PaymentColor(paymentColor.getName(), paymentColor.getCode());
        PaymentColor save = paymentColorRepository.save(addPaymentColor);
        return new ApiResponse("Added successfully",true,save);

    }

    public ApiResponse editPaymentColor(PaymentColor paymentColor ,Integer id){
        if (paymentColorRepository.existsByNameAndIdNot(paymentColor.getName(), id)) {
            return new ApiResponse("paymentColor already exists with this name",false);

        }
        if (paymentColorRepository.existsByCodeAndIdNot(paymentColor.getCode(), id)) {
            return new ApiResponse("PaymentColor with this code already exists",false);

        }
        Optional<PaymentColor> optionalPaymentColor = paymentColorRepository.findById(id);

        if (!optionalPaymentColor.isPresent()) {
            return new ApiResponse("PaymentColor not found",false);
        }
        PaymentColor editingPaymentColor = optionalPaymentColor.get();
        editingPaymentColor.setCode(paymentColor.getCode());
        editingPaymentColor.setName(paymentColor.getName());
        PaymentColor save = paymentColorRepository.save(editingPaymentColor);
        return new ApiResponse("Updated",true,save);


    }

}
