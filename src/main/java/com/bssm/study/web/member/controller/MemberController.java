package com.bssm.study.web.member.controller;

import com.bssm.study.web.member.controller.rq.CreateMemberRq;
import com.bssm.study.web.member.controller.rq.DeleteMemberRq;
import com.bssm.study.web.member.controller.rq.UpdateMemberRq;
import com.bssm.study.web.member.controller.rs.FindMemberByIdRs;
import com.bssm.study.web.member.service.MemberService;
import com.bssm.study.web.path.ApiPath;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping(ApiPath.MEMBER)
    public void createMember(@Validated @RequestBody CreateMemberRq rq){
        memberService.createMember(rq);
    }

    @GetMapping(ApiPath.MEMBER_ID)
    public FindMemberByIdRs findMemberById(@PathVariable("member-id") Long memberId){
        return memberService.findMemberById(memberId);
    }

    @GetMapping(ApiPath.MEMBER_EMAIL)
    public FindMemberByIdRs findMemberByEmail(@PathVariable("email") String email){
        return memberService.findMemberByEmail2(email);
    }

    @PutMapping(ApiPath.MEMBER)
    public void updateMember(@Validated @RequestBody UpdateMemberRq rq){
        memberService.updateMember(rq);
    }

    @DeleteMapping(ApiPath.MEMBER)
    public void deleteMember(@Validated @RequestBody DeleteMemberRq rq){
        memberService.delete(rq.getMemberId());
    }
}
