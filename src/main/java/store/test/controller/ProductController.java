package store.test.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.test.entity.Product;
import store.test.service.ProductService;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/save")
    public String saveProduct(@RequestBody Map<String,String> request){
        Product product = Product.builder()
                .name(request.get("name"))
                .inventory_quantity(Long.valueOf(request.get("inventory_quantity")))
                .price(Long.valueOf(request.get("price")))
                .build();
        String companyName = request.get("company_name");
        return productService.saveProduct(product,companyName);
    }
    @PostMapping("findAll")
    public List<Product> findAllProduct(){
        return productService.findAllProduct();
    }
}
