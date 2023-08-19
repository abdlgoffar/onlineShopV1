package onlineShopV1.services.category;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import onlineShopV1.beans.Validation;
import onlineShopV1.entities.CategoryImage;
import onlineShopV1.models.request.category.UploadCategoryImageRequest;
import onlineShopV1.repositories.CategoryImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@AllArgsConstructor
public class CategoryImageServiceImpl implements CategoryImageService {

    private final CategoryImageRepository categoryImageRepository;
    private final Validation validation;
    @Transactional
    @Override
    public Object upload(UploadCategoryImageRequest request) {

        this.validation.valid(request);

        CategoryImage categoryImage = this.categoryImageRepository.save(CategoryImage.builder()
                .name(request.getFile().getOriginalFilename())
                .type(request.getFile().getContentType())
                .path("C:/Users/abd.goffar/Documents/" + request.getFile().getOriginalFilename()).build());
        if (categoryImage != null) {
            try {
                request.getFile().transferTo(new File("C:/Users/abd.goffar/Documents/" + request.getFile().getOriginalFilename()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return "OK";
    }

    @Override
    public byte[] download(MultipartFile file) {
        return new byte[0];
    }
}
