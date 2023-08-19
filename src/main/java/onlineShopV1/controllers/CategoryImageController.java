package onlineShopV1.controllers;

import lombok.AllArgsConstructor;
import onlineShopV1.beans.CoreResponse;
import onlineShopV1.models.request.category.UploadCategoryImageRequest;
import onlineShopV1.services.category.CategoryImageServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
public class CategoryImageController {
    private final CategoryImageServiceImpl categoryImageService;
    @RequestMapping(
            path = "/api/categories/image/upload",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public CoreResponse<Object> create(@RequestParam("image") MultipartFile file) {
        Object response = this.categoryImageService.upload(UploadCategoryImageRequest.builder()
                .file(file).build());
        return CoreResponse.builder().status(true).error(null).payload(response).build();
    }
}
