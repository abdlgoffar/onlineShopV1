package onlineShopV1.models.request.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import onlineShopV1.entities.Color;
import onlineShopV1.entities.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateProductDescriptionRequest {
    
    @NotBlank()
    private String text;
    
    @NotNull()
    private Size sizes;
    
    @NotNull
    private Color colors;
    
}
