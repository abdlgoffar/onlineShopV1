package onlineShopV1.services.product;

import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import onlineShopV1.beans.Validation;
import online.shop.v1.entities.*;
import onlineShopV1.entities.Color;
import onlineShopV1.entities.Description;
import onlineShopV1.entities.Size;
import onlineShopV1.models.request.product.CreateProductRequest;
import online.shop.v1.repositories.*;
import onlineShopV1.entities.Product;
import onlineShopV1.repositories.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final DescriptionRepository descriptionRepository;
    private final SizeRepository sizeRepository;
    private final ColorRepository colorRepository;
    private final Validation validation;
    @Transactional
    @Override
    public Object create(CreateProductRequest request) {
        this.validation.valid(request);

        Product product = this.productRepository.save(Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .stock(request.getStock())
                .category(request.getCategory())
                .description(request.getDescription()).build());
        return "OK";
    }


    @Transactional
    @Override
    public Object createComplete(CreateProductRequest request) {
        this.validation.valid(request);
        //validation nested data description
        if (request.getDescription().getText() == null) throw new ConstraintViolationException("description text is required", null);

        if (request.getDescription().getSizes() == null
                || (request.getDescription().getSizes().isEmpty())) throw new ConstraintViolationException("description sizes is required", null);
        if (request.getDescription().getColors() == null
                || request.getDescription().getColors().isEmpty()) throw new ConstraintViolationException("description colors is required", null);

        int s = 0;
        while (s < request.getDescription().getSizes().size()) {
            if (request.getDescription().getSizes().get(s).getName() == null
                    || request.getDescription().getSizes().get(s).getName().isEmpty())
                throw new ConstraintViolationException("description size name data " + (s + 1) + " is required", null);
            s++;
        }
        int c = 0;
        while (c < request.getDescription().getColors().size()) {
            if (request.getDescription().getColors().get(c).getName() == null
                    || request.getDescription().getColors().get(c).getName().isEmpty())
                throw new ConstraintViolationException("description color name data " + (c + 1) + " is required", null);
            if (request.getDescription().getColors().get(c).getProductImage() == null
                    || request.getDescription().getColors().get(c).getProductImage().getId() == null
                    || request.getDescription().getColors().get(c).getProductImage().getId().isEmpty())
                throw new ConstraintViolationException("description color image data " + (c + 1) + " is required", null);
            c++;
        }
        //add nested data description.
        for (int i = 0; i < request.getDescription().getSizes().size(); i++) {
            Size size = new Size();
            size.setName(String.valueOf(request.getDescription().getSizes().get(i).getName()));
            Size size1 = this.sizeRepository.save(size);
            request.getDescription().getSizes().set(i, size1);
        }
        for (int i = 0; i < request.getDescription().getColors().size(); i++) {
            Color color = new Color();
            color.setName(String.valueOf(request.getDescription().getColors().get(i).getName()));
            color.setProductImage(request.getDescription().getColors().get(i).getProductImage());
            Color color1 = this.colorRepository.save(color);
            request.getDescription().getColors().set(i, color1);
        }
        Description description = request.getDescription();
        Description description1 = this.descriptionRepository.save(description);

        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setCategory(request.getCategory());
        product.setDescription(description1);
        Product product1 = this.productRepository.save(product);
        return "OK";
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = this.productRepository.findAll();

        return products;
    }
}
