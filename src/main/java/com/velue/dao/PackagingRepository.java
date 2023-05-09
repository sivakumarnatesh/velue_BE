package com.velue.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.velue.dto.Packaging;
import com.velue.dto.ItemProduct;


@Repository
public interface PackagingRepository extends JpaRepository<Packaging, Long> {
	List<Packaging> findAll();

}
