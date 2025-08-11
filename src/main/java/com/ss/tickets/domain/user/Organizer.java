package com.ss.tickets.domain.user;

import com.ss.tickets.domain.event.Event;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Table(name= "organizers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Organizer extends User {

    @OneToMany(mappedBy = "organizer")
    private List<Event> organizedEvents;

}
