package com.example.adminservice.service;

import com.example.adminservice.entity.Attachment;
import com.example.adminservice.entity.Event;
import com.example.adminservice.entity.Speaker;
import com.example.adminservice.entity.User;
import com.example.adminservice.feignClient.BotFeignClient;
import com.example.adminservice.feignClient.ClientFeignClient;
import com.example.adminservice.payload.ApiResponse;
import com.example.adminservice.payload.EventDto;
import com.example.adminservice.payload.EventResponse;
import com.example.adminservice.repository.AttachmentRepository;
import com.example.adminservice.repository.EventRepository;
import com.example.adminservice.repository.SeatRepository;
import com.example.adminservice.repository.SpeakerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {

    final BotFeignClient botFeignClient;
    final EventRepository eventRepository;
    final AttachmentRepository attachmentRepository;
    final SpeakerRepository speakerRepository;
    final SeatRepository seatRepository;

    final ClientFeignClient clientFeignClient;

    public ApiResponse add(EventDto eventDto) {

        Integer speakerId = eventDto.getSpeakerId();
        Optional<Speaker> speakerOptional = speakerRepository.findById(speakerId);
        if (!speakerOptional.isPresent()) {
            return new ApiResponse("There is no speaker in such an id", false);
        }
        Speaker speaker = speakerOptional.get();

        Integer attachmentId = eventDto.getAttachmentId();
        Optional<Attachment> attachmentOptional = attachmentRepository.findById(attachmentId);
        Attachment attachment = attachmentOptional.get();

        String description = eventDto.getDescription();
        String name = eventDto.getName();
        Timestamp startTime = eventDto.getStartTime();
        Boolean byPlace = eventDto.getByPlace();


        //TODO biriktirish kerak templatega

        Event event = new Event();
        event.setSpeaker(speaker);
        event.setAttachment(attachment);
        event.setDescription(description);
        event.setName(name);
        event.setStartTime(startTime);
        event.setByPlace(byPlace);


        eventRepository.save(event);

// hamma foydalanuvchiga yuborish kerak
        //tadbirmni botga beryapmz
        botFeignClient.setAllMessage(event);

        return new ApiResponse("Succesfully added", true);
    }

    public ApiResponse findById(Integer id) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if (!optionalEvent.isPresent()) {
            return new ApiResponse("Bunday id li event mavjud emas", false );
        }
        return new ApiResponse("Mana",true,optionalEvent.get());
    }

    public ApiResponse findAll() {
        List<Event> all = eventRepository.findAll();
        List<EventResponse> eventDtoList = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            Event event = all.get(i);
            EventResponse eventResponse = new EventResponse();
            eventResponse.setAttachmentId(event.getAttachment().getId());
            eventResponse.setName(event.getName());
            eventResponse.setSpeaker(event.getSpeaker().getFirstName() + " " + event.getSpeaker().getLastName());
            eventResponse.setStartTime(event.getStartTime());
        }
        return new ApiResponse("Mana" , true,all);
    }
}
