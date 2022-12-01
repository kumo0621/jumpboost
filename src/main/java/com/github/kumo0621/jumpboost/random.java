package com.github.kumo0621.jumpboost;

import java.util.Random;

public class random {
        public static int random() {
            Random rand = new Random();
            int num = rand.nextInt(55);
            System.out.println(num);
            return num;
        }
    }
