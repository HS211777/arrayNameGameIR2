package com.company;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Main {

    private static ArrayList<String> names = new ArrayList<>();
    private static ArrayList<Integer> computerNums = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("Enter length of array");
        int length = inputInt();
        createArray(length);
        boolean end = false;
        while (!end){
            System.out.println("Players turn, pick a number between 0 and "+(length-1));
            int userInput = inputInt();
            while (userInput > (length-1) && userInput < 1){
                System.out.println("pick a number between 0 and "+(length-1));
                userInput = inputInt();
            }
            playerGo(userInput);
            System.out.println("Computers turn");
            aiGo();
            end = checkEnd(length);
        }
        if (checkWinner()){
            System.out.println("you win");
        }
        else{
            System.out.println("you lose");
        }
        System.out.println(names);
    }
    public static int createArray(int length){
        for (int i = 0; i < length; i++){
            names.add("");
            computerNums.add(i);
        }
        Collections.shuffle(computerNums);
        return length;
    }
    public static int inputInt(){
        Scanner input = new Scanner(System.in);
        int out = 0;
        boolean valid = false;
        while(!valid){
            try{
                out = input.nextInt();
                valid = true;
            }
            catch(Exception e){
                System.out.println("Error "+e);
                System.out.println("please enter a valid number");
                input.next();
            }
        }
        return out;
    }
    public static void playerGo(int choice){
        if (names.get(choice).equals("")){
            names.set(choice,"P");
        }
    }
    public static void aiGo(){
        int num = computerNums.get(0);
        computerNums.remove(0);
        if (names.get(num).equals("")){
            names.set(num,"C");
        }
    }
    public static boolean checkEnd(int length){
        boolean end = true;
        for(int i = 0; i < length;i++){
            if (names.get(i).equalsIgnoreCase("")){
                end = false;
            }
        }
        return end;
    }
    public static boolean checkWinner(){
        int playerCount = 0;
        int aiCount = 0;
        boolean win = false;
        for (int i = 0; i < names.size(); i++){
            if (names.get(i).equals("C")){
                aiCount++;
            }
            else{
                playerCount++;
            }
        }
        if (playerCount > aiCount){
            win = true;
        }
        return win;
        //check who won
    }
}
