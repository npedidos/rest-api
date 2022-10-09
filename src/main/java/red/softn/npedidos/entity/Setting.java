package red.softn.npedidos.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "settings")
public class Setting {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Column(name = "key_name", nullable = false, length = 45)
    private String keyName;
    
    @Column(name = "value", nullable = false)
    private String value;
    
    @Column(name = "description")
    @Type(type = "org.hibernate.type.TextType")
    private String description;
    
    public boolean equals(final Object o) {
        if (o == this) {return true;}
        if (!(o instanceof final Setting other)) {return false;}
        if (!other.canEqual(this)) {return false;}
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (!Objects.equals(this$id, other$id)) {return false;}
        final Object this$keyName = this.getKeyName();
        final Object other$keyName = other.getKeyName();
        if (!Objects.equals(this$keyName, other$keyName)) {return false;}
        final Object this$value = this.getValue();
        final Object other$value = other.getValue();
        if (!Objects.equals(this$value, other$value)) {return false;}
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        return Objects.equals(this$description, other$description);
    }
    
    protected boolean canEqual(final Object other) {return other instanceof Setting;}
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $keyName = this.getKeyName();
        result = result * PRIME + ($keyName == null ? 43 : $keyName.hashCode());
        final Object $value = this.getValue();
        result = result * PRIME + ($value == null ? 43 : $value.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        return result;
    }
    
}
