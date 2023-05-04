package pw.ersms.emergencies.notified_department;

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
public class NotifiedDepartmentId implements Serializable {
    private static final long serialVersionUID = -2693655944428283229L;
    @NotNull
    @Column(name = "emergency_id", nullable = false)
    private Integer emergencyId;

    @NotNull
    @Column(name = "department_id", nullable = false)
    private Integer departmentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        NotifiedDepartmentId entity = (NotifiedDepartmentId) o;
        return Objects.equals(this.emergencyId, entity.emergencyId) &&
                Objects.equals(this.departmentId, entity.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emergencyId, departmentId);
    }

}