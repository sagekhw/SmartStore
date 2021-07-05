package store.test.service;

import org.springframework.stereotype.Service;
import store.test.entity.Company;
import store.test.repository.CompanyRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    @Transactional
    public String saveCompany(Company company){
        Company result = companyRepository.save(company);
        if(result.getName() != null){
            return "success";
        }else{
            return "false";
        }
    }

    @Transactional
    public List<Company> findAll(){
        return companyRepository.findAll();
    }
}
