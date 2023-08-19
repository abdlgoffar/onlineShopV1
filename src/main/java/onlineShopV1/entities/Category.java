package onlineShopV1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Category {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;


    @Column(name = "name", nullable = false, length = 450)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_image_id", referencedColumnName = "id")
    private CategoryImage categoryImage;

    /**
     * RELATIONAL ENTITY MAPPED
     */
    @JsonIgnore
    @Singular
    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
