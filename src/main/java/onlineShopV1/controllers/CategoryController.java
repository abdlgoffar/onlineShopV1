package onlineShopV1.controllers;

import lombok.AllArgsConstructor;
import onlineShopV1.beans.CoreResponse;
import onlineShopV1.entities.Category;
import onlineShopV1.models.request.category.CreateCategoryRequest;
import onlineShopV1.services.category.CategoryServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    @RequestMapping(
            path = "/api/categories",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public CoreResponse<Object> create(@RequestBody CreateCategoryRequest request) {
        String response = this.categoryService.create(request);
        return CoreResponse.builder().status(true).error(null).payload(response).build();
    }

    @RequestMapping(
            path = "/api/categories",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Category> getAll() {
        return this.categoryService.getAll();
    }
}
