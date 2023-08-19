package onlineShopV1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "descriptions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Description {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "text", nullable = false, length = 550)
    private String text;

    @ManyToMany
    @JoinTable(
            name = "descriptions_to_sizes_liaison",
            joinColumns = @JoinColumn(name = "description_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "size_id", referencedColumnName = "id"))
    private List<Size> sizes;

    @ManyToMany
    @JoinTable(
            name = "descriptions_to_colors_liaison",
            joinColumns = @JoinColumn(name = "description_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "color_id", referencedColumnName = "id"))
    private List<Color> colors;


    /**
     * RELATIONAL ENTITY MAPPED
     */
    @JsonIgnore
    @OneToMany(mappedBy = "description")
    private List<Product> products;
}
