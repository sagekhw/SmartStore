package store.test.service;


import org.springframework.stereotype.Service;
import store.test.entity.Member;
import store.test.repository.MemberRepository;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Service
//@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
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



}
