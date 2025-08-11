package com.ss.tickets.service.impl;

import com.ss.tickets.domain.entity.CreateEventRequest;
import com.ss.tickets.domain.entity.event.Event;
import com.ss.tickets.domain.entity.ticket.TicketType;
import com.ss.tickets.domain.entity.user.Organizer;
import com.ss.tickets.domain.entity.user.User;
import com.ss.tickets.exception.UserNotFoundException;
import com.ss.tickets.repository.EventRepository;
import com.ss.tickets.repository.OrganizerRepository;
import com.ss.tickets.repository.UserRepository;
import com.ss.tickets.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final OrganizerRepository organizerRepository;

    private final EventRepository eventRepository;

    @Override
    public Event createEvent(UUID organizerId, CreateEventRequest createEventRequest) throws UserNotFoundException {

        Organizer organizer = organizerRepository.findById(organizerId).
                orElseThrow(() -> new UserNotFoundException(
                        "User: %s Not found".formatted(String.valueOf(organizerId))
                ));

        List<TicketType> ticketTypesToCreate = createEventRequest.ticketTypes().stream()
                .map(ticketTypeReq -> TicketType.builder()
                        .name(ticketTypeReq.name())
                        .description(ticketTypeReq.description())
                        .price(ticketTypeReq.price())
                        .totalAvailable(ticketTypeReq.totalAvailable())
                        .build()).toList();

        Event event = Event.builder()
                .name(createEventRequest.name())
                .start(createEventRequest.start())
                .end(createEventRequest.end())
                .venue(createEventRequest.venue())
                .salesStart(createEventRequest.salesStart())
                .salesEnd(createEventRequest.salesEnd())
                .status(createEventRequest.status())
                .organizer(organizer)
                .ticketTypes(ticketTypesToCreate)
                .build();


        return eventRepository.save(event);
    }
}
