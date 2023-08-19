package onlineShopV1.services.size;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import onlineShopV1.beans.Validation;
import onlineShopV1.entities.Size;
import onlineShopV1.models.request.product.CreateProductSizeDescriptionRequest;
import onlineShopV1.repositories.SizeRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SizeServiceImpl implements SizeService{
    private final SizeRepository sizeRepository;
    private final Validation validation;
    @Transactional
    @Override
    public Object create(CreateProductSizeDescriptionRequest request) {
        this.validation.valid(request);

        Size size = this.sizeRepository.save(Size.builder()
                .name(request.getName()).build());
        return "OK";
    }
}
