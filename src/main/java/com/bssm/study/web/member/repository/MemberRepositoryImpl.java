package com.bssm.study.web.member.repository;

import com.bssm.study.db.entity.Member;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static com.bssm.study.db.entity.QMember.member;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Member findMemberByEmailSearch(String search) {
        return jpaQueryFactory
                .selectFrom(member)
                .where(member.email.contains(search))
                .fetchFirst();
    }

}
