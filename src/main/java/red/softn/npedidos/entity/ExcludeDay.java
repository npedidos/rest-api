package red.softn.npedidos.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "exclude_days")
public class ExcludeDay {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Column(name = "date_exclude", nullable = false)
    private LocalDate dateExclude;
    
    public boolean equals(final Object o) {
        if (o == this) {return true;}
        if (!(o instanceof final ExcludeDay other)) {return false;}
        if (!other.canEqual(this)) {return false;}
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (!Objects.equals(this$id, other$id)) {return false;}
        final Object this$dateExclude = this.getDateExclude();
        final Object other$dateExclude = other.getDateExclude();
        return Objects.equals(this$dateExclude, other$dateExclude);
    }
    
    protected boolean canEqual(final Object other) {return other instanceof ExcludeDay;}
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $dateExclude = this.getDateExclude();
        result = result * PRIME + ($dateExclude == null ? 43 : $dateExclude.hashCode());
        return result;
    }
    
}
