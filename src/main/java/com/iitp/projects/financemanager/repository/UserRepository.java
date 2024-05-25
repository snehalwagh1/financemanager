package com.iitp.projects.financemanager.repository;

import com.iitp.projects.financemanager.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserData, String> {
    UserData findByUsername(String username);
}
