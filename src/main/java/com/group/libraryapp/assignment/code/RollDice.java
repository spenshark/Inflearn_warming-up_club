package com.group.libraryapp.assignment.code;

public class RollDice {
    private int[] results;

    public RollDice(int num) {
        this.results = new int[num];
    }

    public void countDice(int num){
        // 나온 숫자를 세는 역할
        for (int i = 0; i < num; i++) {
            int n = (int)(Math.random() * results.length);
            results[n]++;
        }
    }

    public void printResult(){
        for(int i=0; i<results.length; i++)
        System.out.printf("%d번은 %d번 나왔습니다.\n", i+1, results[i]);
    }
}
