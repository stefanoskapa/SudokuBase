package com.sudokubase.repository;

import com.sudokubase.entity.UsersPuzzles;
import com.sudokubase.entity.UsersPuzzlesPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Stefanos
 */
@Repository
public interface UsersPuzzlesRepository extends JpaRepository<UsersPuzzles, UsersPuzzlesPK> {
    
   @Query(value = "select count(*) from users_puzzles where pid=? and vote = 1;", nativeQuery = true)
    public int getPositiveVotes(int pid);
    
    @Query(value = "select count(*) from users_puzzles where pid=? and vote = 0;", nativeQuery = true)
    public int getNegativeVotes(int pid);
    
}
