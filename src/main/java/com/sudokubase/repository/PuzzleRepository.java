package com.sudokubase.repository;

import com.sudokubase.entity.Puzzles;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PuzzleRepository extends JpaRepository<Puzzles, Integer> {

    public Puzzles findByPuzzle(String puzzle);

    @Query(
            value = "SELECT * FROM puzzles ORDER BY RAND() LIMIT 1;",
            nativeQuery = true)
    public Puzzles fetchRandom();
    
    @Query(
            value = "SELECT * FROM puzzles WHERE created LIKE CONCAT('%', CURDATE(), '%') ORDER BY created LIMIT 1;",
            nativeQuery = true)
    public Puzzles fetchTodays();
    
    @Query(
            value = "SELECT * FROM puzzles WHERE LENGTH(notes) < 3 ORDER BY RAND() LIMIT 1;",
            nativeQuery = true)
    public Puzzles fetchRandomEasy();
    
     @Query(
            value = "SELECT * FROM puzzles WHERE LENGTH(notes) > 2 AND LENGTH(notes) < 5 ORDER BY RAND() LIMIT 1;",
            nativeQuery = true)
    public Puzzles fetchRandomModerate();
    
    @Query(
            value = "SELECT * FROM puzzles WHERE LENGTH(notes) > 4 ORDER BY RAND() LIMIT 1;",
            nativeQuery = true)
    public Puzzles fetchRandomHard();
    
     @Query(
            value = "SELECT * FROM puzzles WHERE creator != \"SudoGen 1.11\" ORDER BY RAND() LIMIT 50;",
            nativeQuery = true)
    public List<Puzzles> fetchRandomFifty();
}
