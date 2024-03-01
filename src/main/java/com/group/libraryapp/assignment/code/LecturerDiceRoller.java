package com.group.libraryapp.assignment.code;

import java.util.HashMap;
import java.util.Map;

public class LecturerDiceRoller {
    private final LecturerDice dice = new LecturerDice();
    private final Map<Integer, Integer> results = new HashMap<>();

    public LecturerDiceRoller(int maxDiceNumber) {
        for (int diceNumber = 1; diceNumber <= LecturerDice.MAX_NUMBER; diceNumber++) {
            results.put(diceNumber, 0);
        }
    }

    public void roll(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            this.oneRoll();
        }
    }

    public void oneRoll() {
        int rollNumber = this.dice.roll();
        int oldCount = results.get(rollNumber);
        results.put(rollNumber, oldCount + 1);
    }

    public Map<Integer, Integer> getResults(){
        return results;
    }
}
