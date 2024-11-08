package com.ll.sbkafka20240227.domain.noti.noti.eventListner;

import com.ll.sbkafka20240227.domain.noti.noti.service.NotiService;
import com.ll.sbkafka20240227.global.dto.chat.ChatMessageDto;
import com.ll.sbkafka20240227.global.event.PostCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class NotiEventListener {

    private final NotiService notiService;


    @EventListener
    @Async
    public void listen(PostCreatedEvent event) {
        notiService.postCreated(event.getPost());
    }

    @KafkaListener(topics = "chat-room-1", groupId = "1")
    public void consume1(ChatMessageDto request) {
        System.out.println("Consumed message1: " + request.getMessage());
    }

    @KafkaListener(topics = "chat-room-1", groupId = "2")
    public void consume2(ChatMessageDto request) {
        System.out.println("Consumed message2: " + request.getMessage());
    }
}
