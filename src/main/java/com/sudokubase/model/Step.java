
package com.sudokubase.model;


public class Step {

    private long millis;
    private int number;
    private String pos;

    public Step(long millis, int number, String pos) {
        this.millis = millis;
        this.number = number;
        this.pos = pos;
    }

    public long getMillis() {
        return millis;
    }

    public void setMillis(long millis) {
        this.millis = millis;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
        return "Step{" + "millis=" + millis + ", number=" + number + ", pos=" + pos + '}';
    }
    
    
}
