package com.github.majisyou.dice.system;

import org.bukkit.ChatColor;

import java.util.Random;
import java.util.logging.Logger;

public class Dicesystem {

    public static int[] Dicemain(String[] args) {

        int[] resultdice = new int[0];  //初期化と呼び出し

        if (args.length == 3) {
            if (!(args[2].chars().allMatch(Character::isDigit)) || !(args[1].chars().allMatch(Character::isDigit))) {
                System.out.println("引数1と引数2は数字で代入してください");
            }
            String stringdicetime = args[1];
            String stringdicenumber = args[2];
            int times = Byte.parseByte(stringdicetime);
            int number = Byte.parseByte(stringdicenumber);
            int result;
            resultdice = new int[number];
            Random ranNum = new Random();
            for (int i = 0; i < times; i++) {
                result = ranNum.nextInt(number);
                resultdice[i] = result;
            }
        } else {
            System.out.println("引数1はダイスを振る回数,引数2はダイスの面の数,引数3は意味なし");
        }

        return resultdice;

    }
}
