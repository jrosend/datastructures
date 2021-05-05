package br.com.study.util;

import java.util.Random;

public class RandomArrayGenerator {
    private static Random random = new Random();
    public static Integer[] generateRandomArray(int size, int maxValue){
        Integer[] newArray = new Integer[size];
        if(size <= 0) return newArray;

        for (int i = 0; i < size; i++) {
            newArray[i] = random.nextInt(maxValue);
        }

        return newArray;
    }
}
