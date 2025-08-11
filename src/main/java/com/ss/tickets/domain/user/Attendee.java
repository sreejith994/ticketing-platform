package com.ss.tickets.domain.user;

import com.ss.tickets.domain.event.Event;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "attendees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Attendee extends User {

    @ManyToMany
    @JoinTable(
            name = "user_attending_events",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    List<Event> attendingEvents = new ArrayList<>();
}
