package com.ss.tickets.domain.entity.user;

import com.ss.tickets.domain.entity.event.Event;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "staff")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Staff extends User {

    @ManyToMany
    @JoinTable(
            name = "user_staffing_events",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    List<Event> staffingEvents = new ArrayList<>();

}
