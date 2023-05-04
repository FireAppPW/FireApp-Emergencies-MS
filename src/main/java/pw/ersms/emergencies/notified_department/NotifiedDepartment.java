package pw.ersms.emergencies.notified_department;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import pw.ersms.emergencies.answer.Answer;
import pw.ersms.emergencies.emergency.Emergency;

@Getter
@Setter
@Entity
@Table(name = "\"notified_department\"")
public class NotifiedDepartment {
    @EmbeddedId
    private NotifiedDepartmentId id;

    @MapsId("emergencyId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "emergency_id", nullable = false)
    private Emergency emergency;

    @NotNull
    @Column(name = "department_name", nullable = false, length = Integer.MAX_VALUE)
    private String departmentName;

    @NotNull
    @Column(name = "number_of_notifications", nullable = false)
    private Integer numberOfNotifications;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "answer_id", nullable = false)
    private Answer answer;

}