package com.example.clientservice.service;

import com.example.clientservice.entity.Payment;
import com.example.clientservice.entity.PaymentType;
import com.example.clientservice.entity.User;
import com.example.clientservice.feignClient.CatalogFeignClient;
import com.example.clientservice.payload.ApiResponse;
import com.example.clientservice.payload.PaymentDto;
import com.example.clientservice.repository.PaymentRepository;
import com.example.clientservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    final PaymentRepository paymentRepository;
    final UserRepository userRepository;
    final CatalogFeignClient catalogFeignClient;

    public ApiResponse makePayment(PaymentDto dto) {
        if (dto.getAmount() < 0) {
            return new ApiResponse("Enter positive value", false);
        }
        Payment payment = new Payment();
        payment.setAmount(dto.getAmount());
        payment.setUser(userRepository.findById(dto.getUserId()).get());
        User user = userRepository.findById(dto.getUserId()).get();
        user.setBalance(user.getBalance() + dto.getAmount());
        userRepository.save(user);
        //feign client
        ApiResponse response = catalogFeignClient.getPaymentType(dto.getPaymentTypeId());
        PaymentType paymentType = (PaymentType) response.getObject();
        payment.setPaymentType(paymentType);
        payment.setDate(dto.getDate());
        Payment save = paymentRepository.save(payment);
        return new ApiResponse("Payment Done", true, save);
    }
}
