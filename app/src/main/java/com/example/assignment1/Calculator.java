package com.example.assignment1;

import java.util.*;

public class Calculator {
    ArrayList<String> list = new ArrayList<>();
    ArrayList<String> history = new ArrayList<>();



    boolean validateUserInput (String Input){


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


        if (list.get(list.size() - 1).chars().allMatch( c -> c == '+' || c == '-' || c== '/' || c == '*')) {
            return false;
        }

       return true;
    }


    int calculate(){
        int firstElement = 0;
        String secondelement = "";
        int thirdElement = 0;

        //This check will see if the first argument is an operand, if it is then it will add a 0 to the beginning of the calculation.
        if(list.get(0).chars().allMatch( c ->  c == '+' || c == '-' || c== '/' || c == '*')) {
            list.add(0, "0");
        }

            firstElement = Integer.parseInt(list.get(0));
             secondelement = (list.get(1));
             thirdElement = Integer.parseInt(list.get(2));


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