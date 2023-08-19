package onlineShopV1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "colors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "name", nullable = false, length = 450)
    private String name;

    @OneToOne
    @JoinColumn(name = "product_image_id", referencedColumnName = "id")
    private ProductImage productImage;

    /**
     * RELATIONAL ENTITY MAPPED
     */
    @JsonIgnore
    @ManyToMany(mappedBy = "colors")
    private Set<Description> descriptions;
}
