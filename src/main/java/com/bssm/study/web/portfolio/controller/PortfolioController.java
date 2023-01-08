package com.bssm.study.web.portfolio.controller;

import com.bssm.study.web.path.ApiPath;
import com.bssm.study.web.portfolio.controller.rq.CreatePortfolioRq;
import com.bssm.study.web.portfolio.controller.rq.UpdatePortfolioRq;
import com.bssm.study.web.portfolio.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioService portfolioService;

    @PostMapping(ApiPath.PORTFOLIO)
    public void createPortfolio(@Validated @RequestBody CreatePortfolioRq rq){
        portfolioService.createPortfolio(rq);
    }

    @PutMapping(ApiPath.PORTFOLIO)
    public void updatePortfolio(@Validated @RequestBody UpdatePortfolioRq rq){
        portfolioService.updatePortfolio(rq);
    }
}
