package onlineShopV1.services.description;

import onlineShopV1.models.request.product.CreateProductDescriptionRequest;


public interface DescriptionService {
    public abstract Object create(CreateProductDescriptionRequest request);
}
