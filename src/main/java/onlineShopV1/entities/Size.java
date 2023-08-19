package onlineShopV1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "sizes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "name", nullable = false, length = 450)
    private String name;

    /**
     * RELATIONAL ENTITY MAPPED
     */
    @JsonIgnore
    @ManyToMany(mappedBy = "sizes")
    private Set<Description> descriptions;


    public Size(String name) {
        this.name = name;
    }
}
