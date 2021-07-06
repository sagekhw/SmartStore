package store.test.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.test.entity.Company;
import store.test.entity.Product;
import store.test.repository.CompanyRepository;
import store.test.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CompanyRepository companyRepository;

    public ProductService(
            ProductRepository productRepository,
            CompanyRepository companyRepository
    ){
        this.productRepository = productRepository;
        this.companyRepository = companyRepository;
    }


    @Transactional
    public String saveProduct(Product product,String companyName){
        System.out.println(product);
        System.out.println(companyName);
        try {
            Optional<Company> company = companyRepository.findByName(companyName);
            if(company.isPresent()){
                product.setCompany(company.get());
                Product res = productRepository.save(product);
                System.out.println(">>>> "+res);
            }else{
                return "false";
            }
        }catch (Exception e){
            return "error";
        }
        return "test";
    }

    @Transactional
    public List<Product> findAllProduct(){
        //Sort.by(Sort.Direction.DESC)
        return productRepository.findAll();
    }
}
