package onlineShopV1.services.category;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import onlineShopV1.beans.Validation;
import onlineShopV1.entities.Category;
import onlineShopV1.models.request.category.CreateCategoryRequest;
import onlineShopV1.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final Validation validation;
    @Transactional
    @Override
    public String create(CreateCategoryRequest request) {

        this.validation.valid(request);

        Category category = this.categoryRepository.save(Category.builder()
                .name(request.getName())
                .categoryImage(request.getImage()).build());

        return "OK";
    }

    @Override
    public Object update(CreateCategoryRequest request) {
        return null;
    }

    @Override
    public Object delete(CreateCategoryRequest request) {
        return null;
    }

    @Override
    public List<Category> getAll() {

        return this.categoryRepository.findAll();
    }


}
