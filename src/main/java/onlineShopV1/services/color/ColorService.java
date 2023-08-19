package onlineShopV1.services.color;

import onlineShopV1.models.request.product.CreateProductColorDescriptionRequest;

public interface ColorService {
    public abstract Object create(CreateProductColorDescriptionRequest request);
}
