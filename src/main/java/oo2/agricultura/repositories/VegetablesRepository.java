package oo2.agricultura.repositories;

import oo2.agricultura.model.Vegetables;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VegetablesRepository extends JpaRepository<Vegetables, Long> {
}