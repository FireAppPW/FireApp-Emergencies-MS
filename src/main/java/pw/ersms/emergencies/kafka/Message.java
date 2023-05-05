package pw.ersms.emergencies.kafka;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.time.LocalDateTime;

public record Message(String message, LocalDateTime created) {

}
