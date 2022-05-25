package red.softn.npedidos.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class FoodDishId implements Serializable {
    
    private static final long serialVersionUID = -2844440428259796926L;
    
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Column(name = "types_dishes_id", nullable = false)
    private Integer typesDishesId;
    
    public boolean equals(final Object o) {
        if (o == this) {return true;}
        if (!(o instanceof final FoodDishId other)) {return false;}
        if (!other.canEqual(this)) {return false;}
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (!Objects.equals(this$id, other$id)) {return false;}
        final Object this$typesDishesId = this.getTypesDishesId();
        final Object other$typesDishesId = other.getTypesDishesId();
        return Objects.equals(this$typesDishesId, other$typesDishesId);
    }
    
    protected boolean canEqual(final Object other) {return other instanceof FoodDishId;}
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $typesDishesId = this.getTypesDishesId();
        result = result * PRIME + ($typesDishesId == null ? 43 : $typesDishesId.hashCode());
        return result;
    }
    
}
