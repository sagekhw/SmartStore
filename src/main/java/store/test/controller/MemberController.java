package store.test.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.test.entity.Member;
import store.test.service.MemberService;

import java.util.List;

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
}
