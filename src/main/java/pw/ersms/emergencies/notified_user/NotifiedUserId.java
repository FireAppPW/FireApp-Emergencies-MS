package pw.ersms.emergencies.notified_user;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class NotifiedUserId implements Serializable {
    private static final long serialVersionUID = -1617750871332785954L;
    @NotNull
    @Column(name = "emergency_id", nullable = false)
    private Integer emergencyId;

    @NotNull
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        NotifiedUserId entity = (NotifiedUserId) o;
        return Objects.equals(this.emergencyId, entity.emergencyId) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emergencyId, userId);
    }

}