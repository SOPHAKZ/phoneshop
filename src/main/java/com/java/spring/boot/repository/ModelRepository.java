package com.java.spring.boot.repository;

import com.java.spring.boot.model.Model;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ModelRepository extends JpaRepository<Model,Integer>, JpaSpecificationExecutor<Model> {
}
