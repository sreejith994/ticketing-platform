package com.ss.tickets.service;

import com.ss.tickets.domain.entity.CreateEventRequest;
import com.ss.tickets.domain.entity.event.Event;
import com.ss.tickets.exception.UserNotFoundException;

import java.util.UUID;

public interface EventService {

    Event createEvent(UUID organizerId, CreateEventRequest createEventRequest) throws UserNotFoundException;
}
