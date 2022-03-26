package com.github.majisyou.dice.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dicesystem {

    public static List<Integer> Dicemain(int times, int surfaceCount) {

        List<Integer> resultdice = new ArrayList<Integer>();

        Random randomNumber = new Random();
        for (int i = 0; i < times; i++) {
            int result = randomNumber.nextInt(surfaceCount) + 1;
            resultdice.add(result);
        }
        return resultdice;
    }
}
