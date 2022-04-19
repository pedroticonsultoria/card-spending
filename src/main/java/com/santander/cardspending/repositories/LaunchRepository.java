package com.santander.cardspending.repositories;

import com.santander.cardspending.domain.Launch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaunchRepository extends JpaRepository <Launch,Integer> {
}
