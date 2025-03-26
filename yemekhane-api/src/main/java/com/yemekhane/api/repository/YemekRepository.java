package com.yemekhane.api.repository;

import com.yemekhane.api.entity.Yemek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YemekRepository extends JpaRepository<Yemek, Long> {
}
