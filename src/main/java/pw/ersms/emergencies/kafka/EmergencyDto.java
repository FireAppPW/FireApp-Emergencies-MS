package pw.ersms.emergencies.kafka;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link pw.ersms.emergencies.emergency.Emergency} entity
 */
public record EmergencyDto(Integer id, @NotNull Integer fireDepartmentId, @NotNull String fireDepartmentName,
                           @NotNull ClassificationDto classification, @NotNull Integer dangerousLevel,
                           @NotNull Integer authorId, @NotNull LocalDateTime dateTimeCreated,
                           LocalDateTime dateTimeClosed, @NotNull String addressLine1, String addressLine2,
                           @NotNull String city, @NotNull String country, String description, Integer captainId,
                           String captainFullName) implements Serializable {
    /**
     * A DTO for the {@link pw.ersms.emergencies.classification.Classification} entity
     */
    public record ClassificationDto(Integer id, String classField, String classDescription) implements Serializable {
    }
}