package com.sudokubase.controllers;

import com.sudokubase.entity.Puzzles;
import com.sudokubase.entity.Solved;
import com.sudokubase.entity.Users;
import com.sudokubase.entity.UsersPuzzles;
import com.sudokubase.entity.UsersPuzzlesPK;
import com.sudokubase.model.NewGame;
import com.sudokubase.model.Step;
import com.sudokubase.repository.PuzzleRepository;
import com.sudokubase.repository.SolvedRepository;
import com.sudokubase.repository.UserRepository;
import com.sudokubase.repository.UsersPuzzlesRepository;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sudogen.Utils;

@Controller
public class GameController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PuzzleRepository puzzleRepository;
    @Autowired
    private SolvedRepository solvedRepository;
    @Autowired
    private UsersPuzzlesRepository usersPuzzlesRepository;

    @GetMapping("/play")
    public String showPlay(@RequestParam(name = "id", required = false) String id, Model model) {

        if (id != null) {
            model.addAttribute("pid", id);
        }
        return "play";
    }

    @ResponseBody
    @GetMapping("/getGame")
    public ResponseEntity<NewGame> generatePuzzle(@RequestParam(name = "id", required = false) String id) {

        Puzzles tempPuzzle;
        if (id == null) {
            tempPuzzle = puzzleRepository.fetchRandom();
        } else if (id.equals("0")) {
            tempPuzzle = puzzleRepository.fetchTodays();
        } else if (id.equals("1")) {
            tempPuzzle = puzzleRepository.fetchRandomEasy();
        } else if (id.equals("2")) {
            tempPuzzle = puzzleRepository.fetchRandomModerate();
        } else if (id.equals("3")) {
            tempPuzzle = puzzleRepository.fetchRandomHard();
        } else {
            Optional<Puzzles> tempPuzzle1 = puzzleRepository.findById(Integer.parseInt(id));

            if (tempPuzzle1.isPresent()) {
                tempPuzzle = tempPuzzle1.get();
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        int[][] puzzle = Utils.uncompress(tempPuzzle.getPuzzle());
        String a = Utils.fullString(puzzle);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String tempDate = simpleDateFormat.format(tempPuzzle.getCreated());
        NewGame game = new NewGame(tempPuzzle.getId(), a, tempDate, tempPuzzle.getCreator(), tempPuzzle.getClues());
        if (tempPuzzle.getNotes() != null) {
            game.setNotes(tempPuzzle.getNotes());
        }
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("/check")
    public ResponseEntity checkSolution(@RequestBody ArrayList<Step> solution, @RequestParam int id, Principal principal) {
        long duration = 0;
        for (Step i : solution) {
            duration += i.getMillis();
        }
        // validation logic here 

        // save in DB
        if (principal != null) {
            Users tempUser = userRepository.findByUsernameIgnoreCase(principal.getName());
            Puzzles tempPuzzle = puzzleRepository.findById(id).get();
            Solved tempSolved = new Solved(tempUser, tempPuzzle, 0, duration);
            solvedRepository.save(tempSolved);
        }
        return new ResponseEntity(HttpStatus.OK);
        //return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @PostMapping("/vote")
    public void ratePuzzle(@RequestBody boolean liked, @RequestParam int id, Principal principal) {

        Users tempUser = userRepository.findByUsernameIgnoreCase(principal.getName());
        Puzzles tempPuzzle = puzzleRepository.findById(id).get();
        UsersPuzzlesPK pk = new UsersPuzzlesPK(tempUser.getUserid(), tempPuzzle.getId());

        UsersPuzzles tempUsersPuzzles;
        Optional<UsersPuzzles> tempUP = usersPuzzlesRepository.findById(pk);
        if (tempUP.isPresent()) {
            System.out.println("----------------> VOTE RECORD FOUND");
            System.out.println("vote: " + liked);
            tempUsersPuzzles = tempUP.get();
            tempUsersPuzzles.setVote(liked);
        } else {
            System.out.println("----------------> VOTE NOT FOUND");
            System.out.println("vote: " + liked);
            tempUsersPuzzles = new UsersPuzzles(pk, liked);

        }
        usersPuzzlesRepository.save(tempUsersPuzzles);

    }

    @GetMapping("/history")
    public String showHistory(Principal principal, Model model) {
        Users tempUser = userRepository.findByUsernameIgnoreCase(principal.getName());
        List<Solved> puzzleList = solvedRepository.findByUserId(tempUser.getUserid());

        model.addAttribute("puzzles", puzzleList);
        return "history";
    }
}
