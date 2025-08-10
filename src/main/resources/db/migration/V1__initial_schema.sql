CREATE TABLE users (
                       id UUID PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       email VARCHAR(255) UNIQUE NOT NULL,
                       created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
                       updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL
);


CREATE TABLE staff (
                       id UUID PRIMARY KEY,
                       CONSTRAINT fk_staff_user FOREIGN KEY (id) REFERENCES users (id)
);

CREATE TABLE organizers (
                            id UUID PRIMARY KEY,
                            CONSTRAINT fk_organizer_user FOREIGN KEY (id) REFERENCES users (id)
);

CREATE TABLE attendees (
                           id UUID PRIMARY KEY,
                           CONSTRAINT fk_attendee_user FOREIGN KEY (id) REFERENCES users (id)
);

CREATE TABLE events (
                        id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                        name VARCHAR(255) NOT NULL,
                        start DATE,
                        "end" DATE,
                        venue VARCHAR(255) NOT NULL,
                        sales_start TIMESTAMP,
                        sales_end TIMESTAMP,
                        status VARCHAR(50) NOT NULL,
                        organizer_id UUID,
                        created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                        updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

                        CONSTRAINT fk_events_organizer FOREIGN KEY (organizer_id)
                            REFERENCES organizers (id)
                            ON DELETE SET NULL
);

-- Join table: Staff ↔ Event
CREATE TABLE user_staffing_events (
                                      user_id UUID NOT NULL,
                                      event_id UUID NOT NULL,
                                      PRIMARY KEY (user_id, event_id),
                                      CONSTRAINT fk_user_staff_event_user FOREIGN KEY (user_id) REFERENCES staff (id),
                                      CONSTRAINT fk_user_staff_event_event FOREIGN KEY (event_id) REFERENCES events (id)
);

-- Join table: Attendee ↔ Event
CREATE TABLE user_attending_events (
                                       user_id UUID NOT NULL,
                                       event_id UUID NOT NULL,
                                       PRIMARY KEY (user_id, event_id),
                                       CONSTRAINT fk_user_attend_event_user FOREIGN KEY (user_id) REFERENCES attendees (id),
                                       CONSTRAINT fk_user_attend_event_event FOREIGN KEY (event_id) REFERENCES events (id)
);

