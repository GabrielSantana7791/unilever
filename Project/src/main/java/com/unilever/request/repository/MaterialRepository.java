package com.unilever.request.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unilever.request.entity.MaterialEntity;
import com.unilever.request.entity.UcxEntity;

public interface MaterialRepository extends JpaRepository<MaterialEntity, Long>{

	//MaterialEntity[] findByUcxCod(String ucxCod);
	List<MaterialEntity> findByUcxEntity(UcxEntity ucxEntity);
	MaterialEntity findById(int id);

}
