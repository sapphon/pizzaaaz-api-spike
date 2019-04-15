package com.ford.labs.pizzaaaz.repository;

import com.ford.labs.pizzaaaz.model.Flow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("jpaFlowRepo")
public interface FlowRepository extends CrudRepository<Flow, Long> {
    List<Flow> findAllByNameLike(String name);
}
