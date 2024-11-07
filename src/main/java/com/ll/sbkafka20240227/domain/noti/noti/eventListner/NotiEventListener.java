package com.ll.sbkafka20240227.domain.noti.noti.eventListner;

import com.ll.sbkafka20240227.domain.noti.noti.service.NotiService;
import com.ll.sbkafka20240227.global.event.PostCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class NotiEventListener {

    private final NotiService notiService;


    @EventListener
    public void listen(PostCreatedEvent event) {
        notiService.postCreated(event.getPost());
    }

}
