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
            System.out.println("Players turn");
            playerGo(inputInt());
            System.out.println("Computers turn");
            aiGo();
            end = checkEnd(length);
        }
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
        try{
            boolean valid = false;
            while (!valid){
                out = input.nextInt();
                valid = true;
            }
        }
        catch(Exception e){
            System.out.println("Error "+e);
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
        boolean playerwin = false;
        //check who won
    }
}
