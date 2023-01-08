package com.bssm.study.web.member.service;

import com.bssm.study.db.entity.Member;
import com.bssm.study.web.exception.CannotFindMemberException;
import com.bssm.study.web.member.controller.rq.CreateMemberRq;
import com.bssm.study.web.member.controller.rq.UpdateMemberRq;
import com.bssm.study.web.member.controller.rs.FindMemberByIdRs;
import com.bssm.study.web.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public void createMember(CreateMemberRq rq) {
        Member member = Member.createNormal(rq.getName(), rq.getEmail(), rq.getPhone());
        memberRepository.save(member);
    }

    public Member findById(Long id){
        return memberRepository.findById(id)
                .orElseThrow(CannotFindMemberException::new);
    }

    public FindMemberByIdRs findMemberById(Long memberId) {
        Member member = findById(memberId);

        return FindMemberByIdRs.builder()
                .memberId(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .phone(member.getPhone())
                .build();
    }

    public FindMemberByIdRs findMemberByEmail(String email) {
        Member member = memberRepository.findByEmailContains(email)
                .orElseThrow(CannotFindMemberException::new);

        return FindMemberByIdRs.builder()
                .memberId(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .phone(member.getPhone())
                .build();
    }

    public FindMemberByIdRs findMemberByEmail2(String email) {
        Member member = memberRepository.findMemberByEmailSearch(email);
        if(Objects.isNull(member)){
            throw new CannotFindMemberException();
        }

        return FindMemberByIdRs.builder()
                .memberId(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .phone(member.getPhone())
                .build();
    }

    public void updateMember(UpdateMemberRq rq) {
        Member member = findById(rq.getMemberId());
        member.update(rq.getName(), rq.getEmail(), rq.getPhone());
    }

    public void delete(Long memberId) {
        memberRepository.deleteById(memberId);
    }
}
