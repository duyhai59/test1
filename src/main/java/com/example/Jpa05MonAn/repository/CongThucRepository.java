package com.example.Jpa05MonAn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Jpa05MonAn.model.CongThuc;

@Repository
public interface CongThucRepository extends JpaRepository<CongThuc, Integer>{

}
