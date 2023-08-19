package onlineShopV1.services.product;

import lombok.AllArgsConstructor;
import onlineShopV1.beans.Validation;
import onlineShopV1.entities.ProductImage;
import onlineShopV1.models.request.product.UploadProductImageRequest;
import onlineShopV1.repositories.ProductImageRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
@AllArgsConstructor
public class ProductImageServiceImpl implements ProductImageService{
    private final ProductImageRepository productImageRepository;
    private final Validation validation;
    @Override
    public Object upload(UploadProductImageRequest request) {
        this.validation.valid(request);
        ProductImage productImage = this.productImageRepository.save(ProductImage.builder()
                .name(request.getFile().getOriginalFilename())
                .type(request.getFile().getContentType())
                .path("C:/Users/abd.goffar/Documents/" + request.getFile().getOriginalFilename()).build());
        if (productImage != null) {
            try {
                request.getFile().transferTo(new File("C:/Users/abd.goffar/Documents/" + request.getFile().getOriginalFilename()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return "OK";
    }
}
