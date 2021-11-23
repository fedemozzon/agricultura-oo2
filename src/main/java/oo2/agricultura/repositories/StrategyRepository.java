package oo2.agricultura.repositories;

import oo2.agricultura.model.Strategy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StrategyRepository extends JpaRepository<Strategy, Long> {
}