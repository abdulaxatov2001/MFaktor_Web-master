package com.example.catalogservice.service;

import com.example.catalogservice.entity.AdsSource;
import com.example.catalogservice.mapper.AdsSourceMapper;
import com.example.catalogservice.payload.AdsSourceDto;
import com.example.catalogservice.payload.ApiResponse;
import com.example.catalogservice.repository.AdsSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdsSourceService {

    @Autowired
    AdsSourceRepository adsSourceRepository;

    @Autowired
    AdsSourceMapper adsSourceMapper;

    public ApiResponse add(AdsSourceDto dto) {
        AdsSource adsSource = adsSourceMapper.fromDto(dto);
        Optional<AdsSource> byName = adsSourceRepository.findByName(dto.getName());
        if (!byName.isEmpty()) {
            return new ApiResponse("This Add source already exists",false);
        }
        adsSourceRepository.save(adsSource);
        return new ApiResponse("Added", true);
    }

    public ApiResponse getOne(Integer id) {
        Optional<AdsSource> optionalAdsSource = adsSourceRepository.findById(id);
        if (!optionalAdsSource.isPresent()) {
            return new ApiResponse("Error", false);
        }
        AdsSource adsSource = optionalAdsSource.get();
        AdsSourceDto adsSourceDto = adsSourceMapper.toDto(adsSource);
        return new ApiResponse("Mana", true, adsSourceDto);
    }

    public ApiResponse edit(Integer id, AdsSourceDto dto) {
        Optional<AdsSource> optionalAdsSource = adsSourceRepository.findById(id);
        boolean exists = adsSourceRepository.existsByName(dto.getName());
        if (optionalAdsSource.isPresent()) {
            AdsSource adsSource = optionalAdsSource.get();
            if (!exists) {
                adsSource.setName(dto.getName());
                adsSourceRepository.save(adsSource);
                return new ApiResponse("Successfully edited!", true);
            }
        }
        return new ApiResponse("This ads source already exists!", false);
    }

 /*   public ApiResponse add(AdsSourceDto dto) {
        if (adsSourceRepository.existsByName(dto.getName())) {
            return new ApiResponse("Bunday nomli reklama turi mavjud",false);
        }
        AdsSource adsSource=new AdsSource();
        adsSource.setName(dto.getName());
        adsSource.setActive(dto.isActive());
        AdsSource save = adsSourceRepository.save(adsSource);
        return new ApiResponse("Save",true,save);
    }


    public ApiResponse edit(Integer id , AdsSourceDto dto){
        boolean byNameAndIdNot = adsSourceRepository.existsByNameAndIdNot(dto.getName(), id);

        if (byNameAndIdNot) {
            return new ApiResponse("Mavjud emas",false);
        }
        Optional<AdsSource> adsSourceOptional = adsSourceRepository.findById(id);
        if (!adsSourceOptional.isPresent()) {
            return new ApiResponse("Mavjud emas",false);
        }
        AdsSource adsSource =adsSourceOptional.get();
        adsSource.setActive(dto.isActive());
        adsSource.setName(dto.getName());
        AdsSource save = adsSourceRepository.save(adsSource);
        return new ApiResponse("Edited", true,save);
    }

    public ApiResponse delete(Integer id){
        Optional<AdsSource> adsSourceOptional = adsSourceRepository.findById(id);
        if (!adsSourceOptional.isPresent()) {
            return new ApiResponse("Bunday id li reklama mavjud emas",false);
        }
        adsSourceRepository.deleteById(id);

        return new ApiResponse("Delete",true);
    }
*/

    public ApiResponse getAll(){
        List<AdsSource> adsSourceList = adsSourceRepository.findAll();
        if (adsSourceList.isEmpty()) {
            return new ApiResponse("List bo'sh",false);
        }
        return new ApiResponse("Mana",true,adsSourceList);
    }

    public ApiResponse delete(Integer id) {
        Optional<AdsSource> byId = adsSourceRepository.findById(id);
        if (byId.isPresent()) {
            AdsSource adsSource = byId.get();
           adsSourceRepository.delete(adsSource);
           return new ApiResponse("Deleted",true);
        }return new ApiResponse("Add source not found", false);
    }
}

