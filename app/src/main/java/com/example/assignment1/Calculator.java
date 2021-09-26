package com.example.assignment1;

import java.util.*;

public class Calculator {
    ArrayList<String> list = new ArrayList<>();
    ArrayList<String> history = new ArrayList<>();



    boolean validateUserInput (String Input){


        //if last element was digit and next one is also digit
        if ((Input.chars().allMatch( c ->  c == '+' || c == '-' || c== '/' || c == '*') && list.isEmpty())){
          return false;
        }

        if ((Input.chars().allMatch(Character::isDigit) && ( list.size() > 0 &&
                list.get(list.size() - 1).chars().allMatch(Character::isDigit)) )){

            return false;
        }

        if ((Input.chars().allMatch( c -> c == '+' || c == '-' || c== '/' || c == '*') &&
                ( list.size() > 0 && list.get(list.size() - 1).chars().allMatch( c -> c == '+' || c == '-' || c== '/' || c == '*')) )){

            return false;
        }

        return  true;
    }


    boolean validateCalculator(){
        if (list.isEmpty() || list.size() <= 2 ) {
            return false;
        }

        if (list.get(list.size() - 1).chars().allMatch( c -> c == '+' || c == '-' || c== '/' || c == '*')) {
            return false;
        }

       return true;
    }


    int calculate(){
        int firstElement = Integer.parseInt(list.get(0));
        String secondelement = (list.get(1));
        int thirdElement = Integer.parseInt(list.get(2));


            while(list.size()>1) {

                switch (secondelement) {
                    case ("+"): {
                        firstElement += thirdElement;
                        break;
                    }
                    case ("-"): {
                        firstElement -= thirdElement;
                        break;
                    }
                    case ("/"): {
                        firstElement /= thirdElement;
                        break;
                    }
                    case ("*"): {
                        firstElement *= thirdElement;
                        break;
                    }
                    default: {
                        return 0;
                    }
                }

                list.remove(2);
                list.remove(1);

                 if(list.size()>1) {
                     secondelement = (list.get(1));
                     thirdElement = Integer.parseInt(list.get(2));
                 }

            }

            return firstElement;
    }

    void push (String value){
        list.add(value);
    }


    void addHistory(String value){
        history.add(value);
    }

    String getHistory(){

        StringBuilder result = new StringBuilder();
        for(String s : history){
            result.append(s).append("\n");
        }

        return result.toString();
    }



}