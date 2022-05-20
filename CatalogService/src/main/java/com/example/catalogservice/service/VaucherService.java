package com.example.catalogservice.service;

import com.example.catalogservice.entity.Vaucher;
import com.example.catalogservice.mapper.VaucherMapper;
import com.example.catalogservice.payload.ApiResponse;
import com.example.catalogservice.payload.VaucherDto;
import com.example.catalogservice.repository.VaucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VaucherService {
    @Autowired
    VaucherRepository vaucherRepository;
    @Autowired
    VaucherMapper vaucherMapper;

    public ApiResponse getAll() {
        List<Vaucher> all = vaucherRepository.findAll();
        return new ApiResponse("all", true, all);
    }

    public ApiResponse getById(Integer id) {
        Optional<Vaucher> byId = vaucherRepository.findById(id);
        if (byId.isEmpty()) {
            return new ApiResponse("not found", false);
        }
        return new ApiResponse("found", true, byId.get());
    }

    public ApiResponse addVaucher(VaucherDto vaucherDto) {
        Vaucher vaucher = vaucherMapper.toEntity(vaucherDto);
        Vaucher save = vaucherRepository.save(vaucher);
        return new ApiResponse("added", true, save);
    }

    public ApiResponse edit(Integer id, VaucherDto vaucherDto) {
//        Vaucher vaucher = null;
        Optional<Vaucher> byId = vaucherRepository.findById(id);
        if (byId.isPresent()) {
            Vaucher test = byId.get();
            Vaucher vaucher = vaucherMapper.toEntity(vaucherDto);
            vaucher.setId(test.getId());
            vaucherRepository.save(vaucher);
            return new ApiResponse("Edited!", true);

        } else {
            return new ApiResponse("Not found!", false);
        }
    }
}
