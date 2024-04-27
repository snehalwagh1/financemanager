package com.iitp.projects.financemanager.repository;

import com.iitp.projects.financemanager.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, String> {
}
