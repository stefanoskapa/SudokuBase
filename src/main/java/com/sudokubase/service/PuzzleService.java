package com.sudokubase.service;

import com.sudokubase.entity.Puzzles;
import com.sudokubase.repository.PuzzleRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import sudogen.Generator;
import sudogen.Solver;
import sudogen.Tname;
import sudogen.Utils;

@Service
public class PuzzleService {

    @Autowired
    private PuzzleRepository puzzleRepository;

    @Scheduled(fixedRate = 3600000)
    public void generatePuzzle() {
        // generate puzzle and store the techniques used to solve it
        Generator generator = new Generator();
        int[][] puzzle = generator.generate();
        Solver solver = new Solver(puzzle, true);
        solver.solve();
        List<Tname> temp = solver.getCan().getUsedTechniques();
        Set<Tname> techniques = new HashSet(temp);

        //create POJO
        String puz = Utils.compress(puzzle);
        short clues = 0;
        for (int i = 0; i < puz.length(); i++) {
            if (puz.substring(i, i + 1).matches("[1-9]")) {
                clues++;
            }
        }
        Puzzles tempPuzzle = new Puzzles(puz, clues);
        String notes = "";
        if (techniques.contains(Tname.NAKEDSINGLE)) {
            notes += "A";
        }
        if (techniques.contains(Tname.HIDDENSINGLE)) {
            notes += "B";
        }
        if (techniques.contains(Tname.CLAIMINGCANDIDATES)) {
            notes += "C";
        }
        if (techniques.contains(Tname.POINTINGCANDIDATES)) {
            notes += "D";
        }
        if (techniques.contains(Tname.NAKEDPAIRS)) {
            notes += "E";
        }
        if (techniques.contains(Tname.HIDDENPAIRS)) {
            notes += "F";
        }
        tempPuzzle.setNotes(notes);
        tempPuzzle.setCreator("SudoGen 1.1");

        if (puzzleRepository.findByPuzzle(puz) == null) { // check if puzzle already exists
            puzzleRepository.save(tempPuzzle);
        }

    }

}
