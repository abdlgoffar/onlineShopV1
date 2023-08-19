package onlineShopV1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "users")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;


    @Column(name = "name", nullable = false, length = 450)
    private String name;

    @Column(name = "email", nullable = false, length = 450, unique = true)
    private String email;

    @Column(name = "password", nullable = false, length = 450)
    private String password;
    /**
     * RELATIONAL ENTITY MAPPED
     */
    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private Cart cart;

}
