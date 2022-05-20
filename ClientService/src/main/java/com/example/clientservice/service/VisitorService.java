package com.example.clientservice.service;

import com.example.clientservice.entity.Visitor;
import com.example.clientservice.payload.ApiResponse;
import com.example.clientservice.repository.VisitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class VisitorService {
    final VisitorRepository visitorRepository;

    public ApiResponse addVisitor( Visitor visitor){
        if (visitorRepository.existsByPhoneNumber(visitor.getPhoneNumber())) {
            return new ApiResponse("Visitor with this PhoneNumber already exists",false );

        }
        Visitor addVisitor=new Visitor();
        addVisitor.setFirstName(visitor.getFirstName());
        addVisitor.setLastName(visitor.getLastName());
        addVisitor.setOrganization(visitor.getOrganization());
        addVisitor.setPhoneNumber(visitor.getPhoneNumber());
        addVisitor.setGender(visitor.getGender());
        Visitor save = visitorRepository.save(addVisitor);
        return new ApiResponse("Added successfully",true);
    }
    public ApiResponse addVisitorEvent( Visitor eventSeatResp){
        visitorRepository.save(eventSeatResp);
        return new ApiResponse("Added successfully",true);
    }

    public ApiResponse editVisitor(Long id,Visitor visitor){
        if (visitorRepository.existsByPhoneNumberAndIdNot(visitor.getPhoneNumber(),id)) {
            return new ApiResponse("Visitor with this PhoneNumber already exists",false );

        }

        Optional<Visitor> optionalVisitor = visitorRepository.findById(id);
        if (optionalVisitor.isPresent()) {
            Visitor editingVisitor = optionalVisitor.get();
            editingVisitor.setFirstName(visitor.getFirstName());
            editingVisitor.setLastName(visitor.getLastName());
            editingVisitor.setPhoneNumber(visitor.getPhoneNumber());
            editingVisitor.setOrganization(visitor.getOrganization());
            editingVisitor.setGender(visitor.getGender());
            Visitor save = visitorRepository.save(editingVisitor);
            return new ApiResponse("Updated",true,save);
        }
        return new ApiResponse("Visitor not found",false);
    }
}
