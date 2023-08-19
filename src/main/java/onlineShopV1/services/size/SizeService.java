package onlineShopV1.services.size;

import onlineShopV1.models.request.product.CreateProductSizeDescriptionRequest;

public interface SizeService {
    public abstract Object create(CreateProductSizeDescriptionRequest request);
}
