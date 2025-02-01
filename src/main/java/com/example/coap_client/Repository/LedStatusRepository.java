package com.example.coap_client.Repository;


import com.example.coap_client.Entity.LedStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LedStatusRepository extends JpaRepository<LedStatus, Long> {
    LedStatus findTopByOrderByTimestampDesc();
}