package com.sudokubase.controllers;

import com.sudokubase.entity.Puzzles;
import com.sudokubase.entity.Users;
import com.sudokubase.repository.PuzzleRepository;
import com.sudokubase.repository.SolvedRepository;
import com.sudokubase.repository.UserRepository;
import com.sudokubase.repository.UsersPuzzlesRepository;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sudogen.Solver;
import sudogen.Tname;
import sudogen.Utils;

@Controller
public class PuzzleController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PuzzleRepository puzzleRepository;

    @Autowired
    SolvedRepository solvedRepository;

    @Autowired
    UsersPuzzlesRepository usersPuzzlesRepository;

    @GetMapping("/puzzle")
    public String showPuzzleInfo(@RequestParam(name = "id") int id, Principal principal, Model model) {

        Optional<Puzzles> tempPuzzle = puzzleRepository.findById(id);

        if (!tempPuzzle.isPresent()) {
            System.out.println("Puzzle not found");
            return "home";
        }
        Puzzles puzzle = tempPuzzle.get();
        //Solver solver = new Solver(sudogen.Utils.uncompress(puzzle.getPuzzle()), false);
        //solver.solve();
        //List<Tname> temp = solver.getCan().getUsedTechniques();

        Set<String> techniques = new HashSet<>();

        if (puzzle.getNotes().contains("A")) {
            techniques.add("Naked Singles");
        }
        if (puzzle.getNotes().contains("B")) {
            techniques.add("Hidden Singles");
        }
        if (puzzle.getNotes().contains("C")) {
            techniques.add("Claiming Candidates");
        }
        if (puzzle.getNotes().contains("D")) {
            techniques.add("Pointing Candidates");
        }
        if (puzzle.getNotes().contains("E")) {
            techniques.add("Naked Pairs");
        }
        if (puzzle.getNotes().contains("F")) {
            techniques.add("Hidden Pairs");
        }
        List isSolved = null;
        if (principal != null) {
            Users tempUser = userRepository.findByUsernameIgnoreCase(principal.getName());
            isSolved = solvedRepository.isSolved(tempUser.getUserid(), id);
        }

        int positive = usersPuzzlesRepository.getPositiveVotes(id);
        int negative = usersPuzzlesRepository.getNegativeVotes(id);

        //Votes votes = usersPuzzlesRepository.getVotes(id, id);
        int solvers = solvedRepository.countSolvers(id);
        Optional bestTime = solvedRepository.bestTime(id);
        String scorer = null;
        if (bestTime.isPresent()) {
            scorer = solvedRepository.bestScorer(id, (long) bestTime.get());
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String tempDate = simpleDateFormat.format(puzzle.getCreated());
        model.addAttribute("id", id);
        model.addAttribute("clues", puzzle.getClues());
        model.addAttribute("created", tempDate);
        model.addAttribute("author", puzzle.getCreator());
        if (puzzle.getNotes().length() <= 2) {
            model.addAttribute("notes", "easy");
        } else if (puzzle.getNotes().length() > 4) {
            model.addAttribute("notes", "hard");
        } else {
            model.addAttribute("notes", "moderate");
        }
        model.addAttribute("puzzle", Utils.fullString(Utils.uncompress(puzzle.getPuzzle())));
        model.addAttribute("techniques", techniques);
        model.addAttribute("solvers", solvers);
        model.addAttribute("isSolved", !(isSolved == null || isSolved.isEmpty()));
        model.addAttribute("positive", positive);
        model.addAttribute("negative", negative);
        if (bestTime.isPresent()) {
            model.addAttribute("bestTime", bestTime.get());
            model.addAttribute("scorer", scorer);
        }

        return "puzzlestats";
    }

}
