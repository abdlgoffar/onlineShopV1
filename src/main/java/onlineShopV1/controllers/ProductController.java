package onlineShopV1.controllers;


import lombok.AllArgsConstructor;
import onlineShopV1.beans.CoreResponse;
import onlineShopV1.entities.Product;
import onlineShopV1.models.request.product.CreateProductRequest;
import onlineShopV1.services.product.ProductServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class ProductController {
    private final ProductServiceImpl productService;
    @RequestMapping(
            path = "/api/products/complete",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public CoreResponse<Object> create(@RequestBody CreateProductRequest request) {
        Object response = this.productService.createComplete(request);
        return CoreResponse.builder().status(true).error(null).payload(response).build();
    }

    @RequestMapping(
            path = "/api/products",
            method = RequestMethod.GET)
    public List<Product> getAll() {
        return this.productService.getAll();
    }
}
