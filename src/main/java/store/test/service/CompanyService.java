package store.test.service;

import org.springframework.stereotype.Service;
import store.test.entity.Company;
import store.test.entity.Member;
import store.test.network.response.ResponseCompany;
import store.test.repository.CompanyRepository;
import store.test.repository.MemberRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final MemberRepository memberRepository;

    public CompanyService(
            CompanyRepository companyRepository,
            MemberRepository memberRepository
    ){
        this.companyRepository = companyRepository;
        this.memberRepository = memberRepository;
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

    @Transactional
    public List<ResponseCompany> findAllWithMember(){
        List<ResponseCompany> responseCompanies = new ArrayList<>();
        List<Company> companies = companyRepository.findAll();
        companies.forEach(company -> {
            List<Member> members = memberRepository.findByCompanyIn(company.getId());
            ResponseCompany responseCompany = ResponseCompany.builder()
                    .Id(company.getId())
                    .name(company.getName())
                    .memberList(members)
                    .build();
            responseCompanies.add(responseCompany);
        });
        return responseCompanies;
    }
}
