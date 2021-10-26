package com.algoexpert.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PhoneNumberPnemonics
{
    public static void main(String[] args) {
       ArrayList<String> s =  phoneNumberMnemonics("9538");
       for(String i:s)
           System.out.println(i);

    }
    public static ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        // Write your code here.

        String[] currentPnemonic = new String[phoneNumber.length()];
        Arrays.fill(currentPnemonic,"0");

        ArrayList<String> mnemonicsFound = new ArrayList<String>();

        phoneNumberPnemonics(0,phoneNumber,currentPnemonic, mnemonicsFound);

        return mnemonicsFound;
    }

    public static void phoneNumberPnemonics(int id,String phoneNumber,String[] currentPnemonic,
                                     ArrayList<String> mnemonicsFound)
    {
        if(id == phoneNumber.length())
        {
            String mnemonic = String.join("",currentPnemonic);
            mnemonicsFound.add(mnemonic);
        }else
        {
            char digit = phoneNumber.charAt(id);
            String[] letters = DIGIT_LETTERS.get(digit);
            for(String letter:letters)
            {
                currentPnemonic[id] = letter;
                phoneNumberPnemonics(id+1, phoneNumber,currentPnemonic,mnemonicsFound);
            }
        }
    }



    public static Map<Character, String[]> DIGIT_LETTERS = new HashMap<Character,String[]>();

    static{
        DIGIT_LETTERS.put('0',new String[] {"0"});
        DIGIT_LETTERS.put('1',new String[] {"1"});
        DIGIT_LETTERS.put('2',new String[] {"a","b","c"});
        DIGIT_LETTERS.put('3',new String[] {"d","e","f"});
        DIGIT_LETTERS.put('4',new String[] {"g","h","i"});
        DIGIT_LETTERS.put('5',new String[] {"j","k","l"});
        DIGIT_LETTERS.put('6',new String[] {"m","n","o"});
        DIGIT_LETTERS.put('7',new String[] {"p","q","r","s"});
        DIGIT_LETTERS.put('8',new String[] {"t","u","v"});
        DIGIT_LETTERS.put('9',new String[] {"w","x","y","z"});
    }
}
