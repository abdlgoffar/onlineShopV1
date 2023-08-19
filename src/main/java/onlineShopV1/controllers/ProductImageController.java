package onlineShopV1.controllers;

import lombok.AllArgsConstructor;
import onlineShopV1.beans.CoreResponse;
import onlineShopV1.models.request.product.UploadProductImageRequest;
import onlineShopV1.services.product.ProductImageServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
public class ProductImageController {
    private final ProductImageServiceImpl productImageService;
    @RequestMapping(
            path = "/api/products/image/upload",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public CoreResponse<Object> create(@RequestParam("image") MultipartFile file) {
        Object response = this.productImageService.upload(UploadProductImageRequest.builder()
                .file(file).build());
        return CoreResponse.builder().status(true).error(null).payload(response).build();
    }


}
