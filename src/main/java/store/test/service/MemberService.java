package store.test.service;


import org.springframework.stereotype.Service;
import store.test.entity.Company;
import store.test.entity.Member;
import store.test.repository.CompanyRepository;
import store.test.repository.MemberRepository;

import org.springframework.transaction.annotation.Transactional;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final CompanyRepository companyRepository;

    public MemberService(
            MemberRepository memberRepository
            ,CompanyRepository companyRepository
    ){
        this.memberRepository = memberRepository;
        this.companyRepository = companyRepository;
    }

//    @Transactional(rollbackOn = {RuntimeException.class, Exception.class})
    @Transactional
    public String saveMember(Member member) throws RuntimeException, SQLException, Exception{
        try {
            Member result = memberRepository.save(member);
            System.out.println(">>> " + result);
            if (result.getEmail() != null){
                return "success";
            }else{
                return "false";
            }

        }catch (Throwable e){
            System.out.println("[error] : "+e);
            return "error";
        }
    }

    @Transactional
    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    @Transactional
    public String insertCompanyInMemberInfo(String companyName,String memberEmail){
        try {
            Optional<Company> company = companyRepository.findByName(companyName);
            if(company.isPresent()){
                Optional<Member> member = memberRepository.findByEmail(memberEmail);
                if(member.isPresent()){
                    member.ifPresent(member1 -> {
                        member1.setCompany(company.get());
                        Member response = memberRepository.save(member1);

                    });
                }else{ return "false"; }
            }else{ return "false"; }
            return "success";
        }catch (Exception e){
            return "error";
        }
    }


}
