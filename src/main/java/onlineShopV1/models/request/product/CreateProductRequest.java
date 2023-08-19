package onlineShopV1.models.request.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import onlineShopV1.entities.Category;
import onlineShopV1.entities.Description;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateProductRequest {
    @NotBlank()
    private String name;

    @NotNull()
    private BigDecimal price;

    @NotNull()
    private Double stock;

    @NotNull()
    private Category category;

    @NotNull()
    private Description description;
}

