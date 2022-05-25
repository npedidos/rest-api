package red.softn.npedidos.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    
    public boolean equals(final Object o) {
        if (o == this) {return true;}
        if (!(o instanceof final User other)) {return false;}
        if (!other.canEqual(this)) {return false;}
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (!Objects.equals(this$id, other$id)) {return false;}
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        return Objects.equals(this$email, other$email);
    }
    
    protected boolean canEqual(final Object other) {return other instanceof User;}
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        return result;
    }
    
}
