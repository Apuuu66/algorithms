package com.guier.array;

/**
 * 70. Climbing Stairs
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(5));
    }

    public int climbStairs(int n) {
        int f1 = 1, f2 = 2, f3 = 0;
        if (n < 3) {
            return n;
        }
        for (int i = 2; i < n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}
