package red.softn.npedidos.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import red.softn.npedidos.utils.gson.GsonExclude;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "menus")
public class Menu {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Column(name = "date", nullable = false)
    private LocalDate date;
    
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "menus_has_food_dishes",
               joinColumns = @JoinColumn(name = "menus_id", nullable = false),
               inverseJoinColumns = @JoinColumn(name = "food_dishes_id", nullable = false))
    @GsonExclude
    private Set<FoodDish> foodDishes;
    
    public Menu() {
        this.foodDishes = new HashSet<>();
    }
    
    public Menu(Integer id) {
        this.id = id;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {return true;}
        if (!(o instanceof final Menu other)) {return false;}
        if (!other.canEqual(this)) {return false;}
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (!Objects.equals(this$id, other$id)) {return false;}
        final Object this$date = this.getDate();
        final Object other$date = other.getDate();
        return Objects.equals(this$date, other$date);
    }
    
    protected boolean canEqual(final Object other) {return other instanceof Menu;}
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $date = this.getDate();
        result = result * PRIME + ($date == null ? 43 : $date.hashCode());
        return result;
    }
    
}
