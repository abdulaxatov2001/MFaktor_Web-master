package com.example.adminservice.repository;

import com.example.adminservice.entity.AttachmentContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttachmentContentRepository extends JpaRepository<AttachmentContent,Integer> {


    Optional<AttachmentContent> findByAttachmentId(Integer attachment_id);
}
