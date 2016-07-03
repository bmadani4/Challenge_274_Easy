package com.scrabble;

import java.util.*;

public class Scrabble {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Integer> data = new HashMap<>();
        data.put("A", 9);
        data.put("B", 2);
        data.put("C", 2);
        data.put("D", 4);
        data.put("E", 12);
        data.put("F", 2);
        data.put("G", 3);
        data.put("H", 2);
        data.put("I", 9);
        data.put("J", 1);
        data.put("K", 1);
        data.put("L", 4);
        data.put("M", 2);
        data.put("N", 6);
        data.put("O", 8);
        data.put("P", 2);
        data.put("Q", 1);
        data.put("R", 6);
        data.put("S", 4);
        data.put("T", 6);
        data.put("U", 4);
        data.put("V", 2);
        data.put("W", 2);
        data.put("X", 1);
        data.put("Y", 2);
        data.put("Z", 1);
        data.put("_", 2);


        System.out.println("Enter the Selection of tiles:");
        // Line that gets the input and converts it to var alpha
        String alpha = sc.nextLine().toUpperCase();

        for (int i = 0; i < alpha.length(); i++) {
            //For loop that go through the user input and converts it to characters
            String letter = String.valueOf(alpha.charAt(i));
            if (data.containsKey(letter)) {
                //checks if the characters equal a letter in the data HashMap and lowers the Key value by one if true
                data.replace(letter, data.get(letter) - 1);
            } else {
                System.out.println(letter + " is not a valid tile!");
                break;
            }
            if (data.containsValue(-1)) {
                //If statement to print out if you select more tiles then there are available
                System.out.println("Invalid input. More " + letter.toUpperCase() + "'s have been taken from the bag than possible.");
                break;
            }

        }


        for (int i = 12; i > 0; i--) {

            Iterator it = data.entrySet().iterator();
            StringBuilder sb = new StringBuilder();

            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                if (pair.getValue().equals(i)) {
                    sb.append(pair.getKey().toString().toUpperCase() + ", ");


                }
            }
            if (data.containsValue(i)) {
                String bag = sb.substring(0, sb.length() - 2);
                System.out.println(i + ": " + bag);
            }
        }
    }
}
