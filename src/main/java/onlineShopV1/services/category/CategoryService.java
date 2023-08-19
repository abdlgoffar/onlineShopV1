package onlineShopV1.services.category;

import onlineShopV1.entities.Category;
import onlineShopV1.models.request.category.CreateCategoryRequest;

import java.util.List;

public interface CategoryService {
    public abstract Object create(CreateCategoryRequest request);
    public abstract Object update(CreateCategoryRequest request);
    public abstract Object delete(CreateCategoryRequest request);

    public abstract List<Category> getAll();

}
