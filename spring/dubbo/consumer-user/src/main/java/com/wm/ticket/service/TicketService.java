package com.wm.ticket.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Component
@Service//将服务发布出去
public interface TicketService {

    public String getTicket();
}
