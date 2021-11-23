package oo2.agricultura.repositories;

import oo2.agricultura.model.Vegetal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VegetalRepository extends JpaRepository<Vegetal, Long> {


}