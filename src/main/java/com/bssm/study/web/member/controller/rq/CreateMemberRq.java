package com.bssm.study.web.member.controller.rq;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class CreateMemberRq {

    @NotEmpty
    private String name;

    @NotEmpty
    private String email;

    private String phone;

}
