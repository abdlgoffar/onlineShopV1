package onlineShopV1.services.category;

import onlineShopV1.models.request.category.UploadCategoryImageRequest;
import org.springframework.web.multipart.MultipartFile;

public interface CategoryImageService {
    public abstract Object upload(UploadCategoryImageRequest request);
    public abstract byte[] download(MultipartFile file);
}
