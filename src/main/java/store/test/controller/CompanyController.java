package store.test.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.test.entity.Company;
import store.test.network.response.ResponseCompany;
import store.test.service.CompanyService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

//    public CompanyController(CompanyService companyService){
//        this.companyService = companyService;
//    }

    @PostMapping("/save")
    public String saveCompany(@RequestBody Company company){
        return companyService.saveCompany(company);
    }

    @PostMapping("/findAll")
    public List<ResponseCompany> findAllCompany(){
        return companyService.findAllWithMember();
    }

}
