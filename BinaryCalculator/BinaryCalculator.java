//============================================================================
// Name        : BinaryCalculator.java
// Author      : Tsotne Putkaradze
// Version     :
// Copyright   : very free to use
// Description : CodeWars.com problem solutions in Java
// Task        : http://www.codewars.com/kata/546ba103f0cf8f7982000df4/train/java
//============================================================================

import static java.lang.Math.abs;

public class BinaryCalculator {
    public static String calculate(final String n1, final String n2, final String o) {
        //Your code
        Integer vn1, vn2;
        vn1 = BinToDec(n1);
        vn2 = BinToDec(n2);

        if (o == "add") return DecToBin(vn1 + vn2);
        if (o == "subtract") return ((vn1 < vn2) ? "-" : "") + DecToBin(abs(vn1 - vn2));
        if (o == "multiply") return DecToBin(vn1 * vn2);
        return "-1";
    }

    public static Integer BinToDec(String binVal) {
        //instead of : int answer = Integer.parseInt(binVal, 2);
        int weight = 1, answer = 0;
        for (int i = 0; i < binVal.length(); i++) {
            answer += (binVal.charAt(binVal.length()-1-i) - '0') * weight;
            weight *= 2;
        }
        return answer;
    }

    public static String DecToBin(Integer decVal) {
        //instead of : answer = Integer.toBinaryString(decVal);
        String answer = "";
        while (decVal > 0) {
            answer = decVal % 2 + answer;
            decVal /= 2;
        }
        return (answer == "") ? "0" : answer;
    }
}