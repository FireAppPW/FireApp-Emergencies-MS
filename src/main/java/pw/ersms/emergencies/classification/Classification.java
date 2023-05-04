package pw.ersms.emergencies.classification;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"classification\"")
public class Classification {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "class", length = Integer.MAX_VALUE)
    private String classField;

    @Column(name = "class_description", length = Integer.MAX_VALUE)
    private String classDescription;

}