package com.group.libraryapp.assignment.code;

import java.util.Scanner;

public class LecturerMain {

    public static void main(String[] args) {
        System.out.println("숫자를 입력하세요 : ");
        Scanner scanner = new Scanner(System.in);
        int tryCount = scanner.nextInt();

        LecturerDiceRoller results = new LecturerDiceRoller(LecturerDice.MAX_NUMBER);

        results.roll(tryCount);

        results.getResults()
                .forEach((diceNumber, count)-> System.out.println("%d는 %d번 나왔습니다."));
    }


}
