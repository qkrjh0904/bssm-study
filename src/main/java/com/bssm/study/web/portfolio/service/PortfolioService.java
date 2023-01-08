package com.bssm.study.web.portfolio.service;

import com.bssm.study.db.entity.Member;
import com.bssm.study.db.entity.Portfolio;
import com.bssm.study.web.member.service.MemberService;
import com.bssm.study.web.portfolio.controller.rq.CreatePortfolioRq;
import com.bssm.study.web.portfolio.controller.rq.UpdatePortfolioRq;
import com.bssm.study.web.portfolio.repository.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final MemberService memberService;
    public void createPortfolio(CreatePortfolioRq rq) {
        Member member = memberService.findById(rq.getMemberId());
        Portfolio portfolio = Portfolio.create(rq.getTitle(), member);
        portfolioRepository.save(portfolio);
    }

    public void updatePortfolio(UpdatePortfolioRq rq) {
        Member member = memberService.findById(rq.getMemberId());
        List<Portfolio> portfolioList = rq.getPortfolioDto().stream()
                .map(dto -> Portfolio.create(dto.getTitle(), member))
                .collect(Collectors.toList());
        member.updatePortfolio(portfolioList);
    }
}
