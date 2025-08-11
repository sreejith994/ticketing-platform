package com.ss.tickets.mapper;

import com.ss.tickets.domain.dto.CreateEventRequestDto;
import com.ss.tickets.domain.dto.CreateEventResponseDto;
import com.ss.tickets.domain.dto.CreateTicketTypeRequestDto;
import com.ss.tickets.domain.entity.CreateEventRequest;
import com.ss.tickets.domain.entity.CreateTicketTypeRequest;
import com.ss.tickets.domain.entity.event.Event;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

    CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto createTicketTypeRequestDto);

    CreateEventRequest fromDto(CreateEventRequestDto dto);

    CreateEventResponseDto toDto(Event event);


}
