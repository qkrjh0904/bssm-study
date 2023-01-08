package com.bssm.study.web.portfolio.controller.rq;

import com.bssm.study.web.dto.PortfolioDto;
import lombok.Getter;

import java.util.List;

@Getter
public class UpdatePortfolioRq {
    private Long memberId;
    private List<PortfolioDto> portfolioDto;
}
