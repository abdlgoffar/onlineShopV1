package onlineShopV1.models.request.category;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import onlineShopV1.beans.Image;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UploadCategoryImageRequest {
    @NotNull()
    @Image()
    private MultipartFile file;
}
