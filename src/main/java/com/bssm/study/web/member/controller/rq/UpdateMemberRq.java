package com.bssm.study.web.member.controller.rq;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class UpdateMemberRq {
    @NotNull
    private Long memberId;
    private String name;
    private String email;
    private String phone;
}
