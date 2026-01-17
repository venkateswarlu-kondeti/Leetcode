package com.greedy;

import java.util.Arrays;
//2126. Destroying Asteroids
public class DestroyingAsteroids {
    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currMass=mass;
        for(int asteroid : asteroids){
            if(asteroid>currMass){
                return false;
            }
            currMass+=asteroid;
        }
        return true;
    }

    public static void main(String[] args){
        int mass = 10; int[] asteroids = {3,9,19,5,21};
        System.out.println("All asteroids destroyed? "+DestroyingAsteroids.asteroidsDestroyed(mass,asteroids));
    }
}
