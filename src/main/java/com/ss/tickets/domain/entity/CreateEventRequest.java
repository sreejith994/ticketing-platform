package com.ss.tickets.domain.entity;

import com.ss.tickets.domain.entity.event.EventStatusEnum;
import com.ss.tickets.domain.entity.user.Organizer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record CreateEventRequest(
        String name,
        LocalDateTime start,
        LocalDateTime end,
        String venue,
        LocalDateTime salesStart,
        LocalDateTime salesEnd,
        EventStatusEnum status,
        List<CreateTicketTypeRequest> ticketTypes
            ) {
}
