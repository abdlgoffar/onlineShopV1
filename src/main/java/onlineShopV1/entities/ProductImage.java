package onlineShopV1.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products_image")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductImage {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", nullable = false, length = 900)
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "path")
    private String path;

    /**
     * RELATIONAL ENTITY MAPPED
     */
    @OneToOne
    @OneToMany(mappedBy = "productImage")
    private Color color;
}
