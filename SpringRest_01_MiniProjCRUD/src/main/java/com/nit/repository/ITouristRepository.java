package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Tourist;

public interface ITouristRepository extends JpaRepository<Tourist,Integer> {

}
