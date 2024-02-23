package com.group.libraryapp.assignment.code;

import java.util.Scanner;

public class Dice {

    public static void main(String[] args) throws Exception {

        // 주사위 면 갯수 입력
        System.out.print("주사위는 몇개의 면을 가지고 있나요 : ");
        RollDice rollDice = new RollDice(new Scanner(System.in).nextInt());

        // 주사위 돌리는 횟수 입력
        System.out.print("주사위는 몇 번 돌릴까요? : ");
        rollDice.countDice(new Scanner(System.in).nextInt());

        // 결과 출력
        rollDice.printResult();
    }
}

