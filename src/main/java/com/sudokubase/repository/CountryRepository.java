package com.sudokubase.repository;

import com.sudokubase.entity.Countries;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Countries, String>{
    
    @Override
    @Query(value = "SELECT * FROM countries ORDER BY name", nativeQuery = true)
    public List<Countries> findAll();
}
