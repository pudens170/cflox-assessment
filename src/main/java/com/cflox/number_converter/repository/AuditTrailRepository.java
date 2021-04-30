package com.cflox.number_converter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cflox.number_converter.model.AuditTrail;

@Repository
public interface AuditTrailRepository  extends JpaRepository<AuditTrail, Long>{

}
