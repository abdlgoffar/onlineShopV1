package onlineShopV1.services.color;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import onlineShopV1.beans.Validation;
import onlineShopV1.entities.Color;
import onlineShopV1.models.request.product.CreateProductColorDescriptionRequest;
import onlineShopV1.repositories.ColorRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ColorServiceImpl implements ColorService{
    private final ColorRepository colorRepository;
    private final Validation validation;
    @Transactional
    @Override
    public Object create(CreateProductColorDescriptionRequest request) {
        this.validation.valid(request);

        Color color = this.colorRepository.save(Color.builder()
                .name(request.getName()).productImage(request.getProductImage()).build());
        return "OK";
    }
}
