package pw.ersms.emergencies.answer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"answer\"")
public class Answer {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "answer", length = Integer.MAX_VALUE)
    private String answer;

}