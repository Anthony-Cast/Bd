package com.example.demo3.repository;

import com.example.demo3.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    @Query(value="select * from categories where categoryname like ?1",nativeQuery = true)
    List<Category> buscarporNombreCategoria(String categoryname);
}
