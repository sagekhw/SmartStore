package store.test.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import store.test.entity.Member;
import store.test.service.MemberService;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/save")
    public String saveMember(@RequestBody Member member) throws Exception {
        try {
            return memberService.saveMember(member);
        } catch (Exception e){
            System.out.println("error "+e);
            return "error";
        }
    }

    @PostMapping("/findAll")
    public List<Member> members(){
        return memberService.findAll();
    }

    @PostMapping("/insertCompanyInfo")
    public String insertCompanyInMemberInfo(@RequestBody Map<String,String> param){
        return memberService.insertCompanyInMemberInfo(param.get("companyName"), param.get("memberEmail"));
    }
}
