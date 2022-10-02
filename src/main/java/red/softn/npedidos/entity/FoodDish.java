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
@Table(name = "food_dishes")
public class FoodDish {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Column(name = "name", nullable = false, length = 250)
    private String name;
    
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "types_dishes_id", nullable = false)
    @GsonExclude
    private TypeDish typeDish;
    
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "orders_has_food_dishes",
               joinColumns = @JoinColumn(name = "food_dishes_id", nullable = false),
               inverseJoinColumns = @JoinColumn(name = "orders_id", nullable = false))
    @GsonExclude
    private List<Order> orders;
    
    public boolean equals(final Object o) {
        if (o == this) {return true;}
        if (!(o instanceof final FoodDish other)) {return false;}
        if (!other.canEqual(this)) {return false;}
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (!Objects.equals(this$id, other$id)) {return false;}
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (!Objects.equals(this$name, other$name)) {return false;}
        final Object this$typeDish = this.getTypeDish();
        final Object other$typeDish = other.getTypeDish();
        return Objects.equals(this$typeDish, other$typeDish);
    }
    
    protected boolean canEqual(final Object other) {return other instanceof FoodDish;}
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $typeDish = this.getTypeDish();
        result = result * PRIME + ($typeDish == null ? 43 : $typeDish.hashCode());
        return result;
    }
    
}
