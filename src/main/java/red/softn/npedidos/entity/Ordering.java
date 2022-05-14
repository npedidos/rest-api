package red.softn.npedidos.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "ordering")
public class Ordering {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Column(name = "date_order", nullable = false)
    private LocalDateTime dateOrder;
    
    public boolean equals(final Object o) {
        if (o == this) {return true;}
        if (!(o instanceof final Ordering other)) {return false;}
        if (!other.canEqual(this)) {return false;}
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (!Objects.equals(this$id, other$id)) {return false;}
        final Object this$dateOrder = this.getDateOrder();
        final Object other$dateOrder = other.getDateOrder();
        return Objects.equals(this$dateOrder, other$dateOrder);
    }
    
    protected boolean canEqual(final Object other) {return other instanceof Ordering;}
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $dateOrder = this.getDateOrder();
        result = result * PRIME + ($dateOrder == null ? 43 : $dateOrder.hashCode());
        return result;
    }
}
