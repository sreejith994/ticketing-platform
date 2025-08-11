package com.ss.tickets.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record CreateTicketTypeResponseDto(
        UUID id,
        String name,
        BigDecimal price,
        String description,
        int totalAvailable,
        LocalDateTime creationAt
) {
}
