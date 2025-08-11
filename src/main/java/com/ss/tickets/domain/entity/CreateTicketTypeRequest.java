package com.ss.tickets.domain.entity;

import java.math.BigDecimal;

public record CreateTicketTypeRequest(
        String name,
        BigDecimal price,
        String description,
        int totalAvailable

) {
}
