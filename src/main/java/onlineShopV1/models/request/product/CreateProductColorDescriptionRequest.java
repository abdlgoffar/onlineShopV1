package onlineShopV1.models.request.product;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import onlineShopV1.entities.ProductImage;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateProductColorDescriptionRequest {
    @NotBlank()
    private String name;

    private ProductImage productImage;
}
