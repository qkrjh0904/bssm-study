package com.bssm.study.web.portfolio.repository;

import com.bssm.study.db.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
}
