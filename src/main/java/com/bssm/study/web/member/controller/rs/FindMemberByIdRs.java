package com.bssm.study.web.member.controller.rs;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FindMemberByIdRs {
    private Long memberId;
    private String name;
    private String email;
    private String phone;
}
