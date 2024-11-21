package dev.michaelcao512.backend.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
public class Message {
    @Id
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String user;
    @Getter @Setter
    private String message;
    @Getter @Setter
    private LocalDateTime timestamp;

}
