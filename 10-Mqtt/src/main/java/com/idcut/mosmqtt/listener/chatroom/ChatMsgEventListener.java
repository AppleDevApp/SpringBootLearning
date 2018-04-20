package com.idcut.mosmqtt.listener.chatroom;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.Subscribe;
import com.idcut.mosmqtt.event.ChatMsgSendEvent;
import com.idcut.mosmqtt.event.ChatUserEntryEvent;
import com.idcut.mosmqtt.event.ChatUserLeaveEvent;
import com.idcut.mosmqtt.event.SystemResponseEvent;
import com.idcut.mosmqtt.service.ChatRoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Component
public class ChatMsgEventListener {

    @Autowired
    private AsyncEventBus asyncEventBus;

    @Autowired
    private ChatRoomService chatRoomService;

    //注册这个监听器
    @PostConstruct
    public void register() {
        asyncEventBus.register(this);
    }

    //解除这个监听器
    @PreDestroy
    public void unregister() {
        asyncEventBus.unregister(this);
    }

    @Subscribe
    @AllowConcurrentEvents
    public void operateResponse(SystemResponseEvent responseEvent) {
        log.info("System Response Event:{}", responseEvent);
        chatRoomService.systemResponse(responseEvent);
    }

    @Subscribe
    @AllowConcurrentEvents
    public void sendChatMsg(ChatMsgSendEvent msgSendEvent) {
        log.info("ChatMsg Event Listen:{}", msgSendEvent);
        chatRoomService.sendChatMsg(msgSendEvent);
    }

    @Subscribe
    @AllowConcurrentEvents
    public void addUserToRoom(ChatUserEntryEvent userEntryEvent) {
        log.info("ChatRoom User Entry Event:{}", userEntryEvent);
        chatRoomService.addUserToRoom(userEntryEvent);
    }

    @Subscribe
    @AllowConcurrentEvents
    public void delUserFromRoom(ChatUserLeaveEvent userLeaveEvent) {
        log.info("ChatRoom User Leave Event:{}", userLeaveEvent);
        chatRoomService.delUserFromRoom(userLeaveEvent);
    }

}
