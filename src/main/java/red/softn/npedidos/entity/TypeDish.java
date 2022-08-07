package red.softn.npedidos.entity;

import lombok.*;
import red.softn.npedidos.utils.gson.GsonExclude;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "types_dishes")
public class TypeDish {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    
    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "typeDish")
    @GsonExclude
    private List<FoodDish> foodDishes;
    
    public boolean equals(final Object o) {
        if (o == this) {return true;}
        if (!(o instanceof final TypeDish other)) {return false;}
        if (!other.canEqual(this)) {return false;}
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (!Objects.equals(this$id, other$id)) {return false;}
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        return Objects.equals(this$name, other$name);
    }
    
    protected boolean canEqual(final Object other) {return other instanceof TypeDish;}
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        return result;
    }
    
}
