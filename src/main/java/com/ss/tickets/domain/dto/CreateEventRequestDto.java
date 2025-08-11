package com.ss.tickets.domain.dto;

import com.ss.tickets.domain.entity.event.EventStatusEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record CreateEventRequestDto(

        @NotBlank(message = "event name is required")
        String name,

        LocalDateTime start,

        LocalDateTime end,

        @NotBlank(message = "venue information required")
        String venue,

        LocalDateTime salesStart,

        LocalDateTime salesEnd,

        @NotNull(message = "event status must be provided")
        EventStatusEnum status,

        @NotEmpty(message = "At least one Ticket type required")
        @Valid
        List<CreateTicketTypeRequestDto> ticketTypes
            ) {
}
