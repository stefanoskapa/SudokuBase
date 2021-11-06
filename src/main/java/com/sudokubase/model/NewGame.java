
package com.sudokubase.model;

public class NewGame {
    private int id;
    private String puzzle;
    private String created;
    private String author;
    private String notes;
    public int clues;
    

    public NewGame(int id,String puzzle, String created, String author, int clues) {
        this.id = id;
        this.puzzle = puzzle;
        this.created = created;
        this.author = author;
        this.clues = clues;
    }

    public int getClues() {
        return clues;
    }

    public void setClues(int clues) {
        this.clues = clues;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPuzzle() {
        return puzzle;
    }

    public void setPuzzle(String puzzle) {
        this.puzzle = puzzle;
    }

    
    
    
}
