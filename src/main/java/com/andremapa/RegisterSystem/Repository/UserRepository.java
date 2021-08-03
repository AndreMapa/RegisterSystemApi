package com.andremapa.RegisterSystem.Repository;

import com.andremapa.RegisterSystem.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByCpf(String s);
    Boolean existsByEmail(String s);
    User findByCpf(String s);
}
