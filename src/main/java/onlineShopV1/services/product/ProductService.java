package onlineShopV1.services.product;

import onlineShopV1.entities.Product;
import onlineShopV1.models.request.product.CreateProductRequest;

import java.util.List;

public interface ProductService {
    public abstract Object create(CreateProductRequest request);

    public abstract Object createComplete(CreateProductRequest request);

    public abstract List<Product> getAll();
}
