package red.softn.npedidos.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import red.softn.npedidos.utils.gson.GsonExclude;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "orders")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Column(name = "date_order", nullable = false)
    private LocalDateTime dateOrder;
    
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "orders_has_food_dishes",
               joinColumns = @JoinColumn(name = "orders_id", nullable = false),
               inverseJoinColumns = @JoinColumn(name = "food_dishes_id", nullable = false))
    @GsonExclude
    private Set<FoodDish> foodDishes;
    
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "users_id", nullable = false)
    @GsonExclude
    private User user;
    
    public Order() {
        this.foodDishes = new HashSet<>();
    }
    
    public boolean equals(final Object o) {
        if (o == this) {return true;}
        if (!(o instanceof final Order other)) {return false;}
        if (!other.canEqual(this)) {return false;}
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (!Objects.equals(this$id, other$id)) {return false;}
        final Object this$dateOrder = this.getDateOrder();
        final Object other$dateOrder = other.getDateOrder();
        if (!Objects.equals(this$dateOrder, other$dateOrder)) {return false;}
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        return Objects.equals(this$user, other$user);
    }
    
    protected boolean canEqual(final Object other) {return other instanceof Order;}
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $dateOrder = this.getDateOrder();
        result = result * PRIME + ($dateOrder == null ? 43 : $dateOrder.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        return result;
    }
    
}
