package com.example.adminservice.repository;

import com.example.adminservice.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment,Integer> {
    Optional<Attachment> findById(Integer id);


}
