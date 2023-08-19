package onlineShopV1.services.product;

import onlineShopV1.models.request.product.UploadProductImageRequest;

public interface ProductImageService {
    public abstract Object upload(UploadProductImageRequest request);
}
