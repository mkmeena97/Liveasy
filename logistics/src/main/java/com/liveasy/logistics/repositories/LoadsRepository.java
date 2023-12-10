package com.liveasy.logistics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.liveasy.logistics.entities.Load;

@Transactional
@Repository
public interface LoadsRepository extends JpaRepository<Load,Integer>{
    
}
