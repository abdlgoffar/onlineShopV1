package onlineShopV1.beans;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
public class ImageValidator implements ConstraintValidator<Image, MultipartFile> {



    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
        if (file.isEmpty()) return false; //content must available.

        String[] contentType = file.getContentType().split("/");
        if (contentType[0].equals("image") == false) return false; //content must image.

        if (file.getSize() > 1000000) return false; //max size file 1MB
        if (file.getSize() < 500000) return false; //min size file 500KB

        return true;
    }
}
