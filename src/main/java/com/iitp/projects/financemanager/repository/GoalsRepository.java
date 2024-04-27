package com.iitp.projects.financemanager.repository;

import com.iitp.projects.financemanager.model.Goals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalsRepository extends JpaRepository<Goals, String> {
}
