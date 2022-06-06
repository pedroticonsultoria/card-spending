package com.santander.cardspending.repositories;

import com.santander.cardspending.domain.Launch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LaunchRepository extends JpaRepository <Launch, UUID> {

    @Query("select l from Launch l where l.id = :idCode")
    Optional<Launch> findByLaunch(@Param("idCode") UUID idCode);
}
