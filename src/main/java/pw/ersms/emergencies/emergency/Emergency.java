package pw.ersms.emergencies.emergency;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import pw.ersms.emergencies.classification.Classification;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"emergency\"")
public class Emergency {

    @Id
    @SequenceGenerator(
            name = "Emergency_id_seq",
            sequenceName = "Emergency_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Emergency_id_seq"
    )
    private Integer id;

    @NotNull
    @Column(name = "fire_department_id", nullable = false)
    private Integer fireDepartmentId;

    @NotNull
    @Column(name = "fire_department_name", nullable = false, length = Integer.MAX_VALUE)
    private String fireDepartmentName;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "classification_id", nullable = false)
    private Classification classification;

    @NotNull
    @Column(name = "dangerous_level", nullable = false)
    private Integer dangerousLevel;

    @NotNull
    @Column(name = "author_id", nullable = false)
    private Integer authorId;

    @NotNull
    @Column(name = "date_time_created", nullable = false)
    private LocalDateTime dateTimeCreated;

    @Column(name = "date_time_closed")
    private LocalDateTime dateTimeClosed;

    @NotNull
    @Column(name = "address_line_1", nullable = false, length = Integer.MAX_VALUE)
    private String addressLine1;

    @Column(name = "address_line_2", length = Integer.MAX_VALUE)
    private String addressLine2;

    @NotNull
    @Column(name = "city", nullable = false, length = Integer.MAX_VALUE)
    private String city;

    @NotNull
    @Column(name = "country", nullable = false, length = Integer.MAX_VALUE)
    private String country;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "captain_id")
    private Integer captainId;

    @Column(name = "captain_full_name", length = Integer.MAX_VALUE)
    private String captainFullName;

    @Override
    public String toString() {
        return "Emergency{" +
                "id=" + id +
                ", fireDepartmentId=" + fireDepartmentId +
                ", fireDepartmentName='" + fireDepartmentName + '\'' +
                ", classification=" + classification +
                ", dangerousLevel=" + dangerousLevel +
                ", authorId=" + authorId +
                ", dateTimeCreated=" + dateTimeCreated +
                ", dateTimeClosed=" + dateTimeClosed +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                ", captainId=" + captainId +
                ", captainFullName='" + captainFullName + '\'' +
                '}';
    }
}