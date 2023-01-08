package com.bssm.study.web.member.repository;

import com.bssm.study.db.entity.Member;

public interface MemberRepositoryCustom {
    Member findMemberByEmailSearch(String search);
}
