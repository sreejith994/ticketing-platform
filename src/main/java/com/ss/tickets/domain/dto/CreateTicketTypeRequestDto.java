package com.ss.tickets.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record CreateTicketTypeRequestDto(
        @NotBlank(message = "name is required")
        String name,
        @NotNull(message = "price is required")
        @PositiveOrZero(message = "price must greater or equal to zero")
        BigDecimal price,
        String description,
        int totalAvailable

) {
}
