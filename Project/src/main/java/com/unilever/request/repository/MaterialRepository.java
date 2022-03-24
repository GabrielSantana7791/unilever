package com.unilever.request.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unilever.request.entity.MaterialEntity;

public interface MaterialRepository extends JpaRepository<MaterialEntity, Long>{

}
