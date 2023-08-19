package onlineShopV1.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "categories_image")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CategoryImage {
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
    @JsonIgnore
    @OneToMany(mappedBy = "categoryImage")
    public Set<Category> categories;
}
