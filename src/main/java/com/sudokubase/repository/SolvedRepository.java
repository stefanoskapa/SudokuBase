package com.sudokubase.repository;

import com.sudokubase.entity.Solved;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SolvedRepository extends JpaRepository<Solved, Integer> {
    
    @Query(value = "SELECT * FROM solved WHERE uid = ? ORDER BY datesolved DESC", nativeQuery = true)
    public List<Solved> findByUserId (long userID);
    
    @Query(value = "SELECT * FROM solved WHERE uid = ? AND pid = ?", nativeQuery = true)
    public List isSolved(long userID, int puzzleID);
    
    @Query(value="SELECT MIN(duration) FROM solved WHERE pid=?", nativeQuery = true)
    public Optional<Long> bestTime(int pid);
    
    @Query(value="SELECT username from users,solved WHERE solved.pid=? AND users.id = solved.uid AND duration = ?;", nativeQuery = true)
    public String bestScorer( int pid,long time);
    
    @Query(value="SELECT COUNT(DISTINCT uid) FROM solved WHERE pid = ?", nativeQuery = true)
    public int countSolvers(int pid);
    
    
    
    
    
}
