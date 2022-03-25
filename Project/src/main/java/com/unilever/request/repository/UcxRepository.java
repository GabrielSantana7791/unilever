package com.unilever.request.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unilever.request.entity.UcxEntity;

public interface UcxRepository  extends JpaRepository<UcxEntity, Long>{
	UcxEntity findByUcxId(int ucxId);

}
