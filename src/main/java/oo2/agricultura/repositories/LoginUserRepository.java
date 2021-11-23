package oo2.agricultura.repositories;

import oo2.agricultura.model.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginUserRepository extends JpaRepository<LoginUser, Long> {

}