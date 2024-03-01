package com.group.libraryapp.assignment.code;

import java.util.Random;

public class LecturerDice {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 6;

    private final Random random = new Random();

    public int roll(){
        return random.nextInt(MIN_NUMBER, MAX_NUMBER+1);
    }
}
