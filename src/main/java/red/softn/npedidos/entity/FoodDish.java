package red.softn.npedidos.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import red.softn.npedidos.utils.gson.GsonExclude;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
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
    private Set<Order> orders;
    
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "menus_has_food_dishes",
               joinColumns = @JoinColumn(name = "food_dishes_id", nullable = false),
               inverseJoinColumns = @JoinColumn(name = "menus_id", nullable = false))
    @GsonExclude
    private Set<Menu> menus;
    
    public FoodDish() {
        this.orders = new HashSet<>();
        this.menus = new HashSet<>();
    }
    
    public FoodDish(Integer id) {
        this.id = id;
    }
    
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
