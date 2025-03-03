package Lesson2.Arrays.OddOccurrencesInArray;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    // It's not efficient solution as Solution.java
    public int solution(int[] A) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.get(A[i]) != null) {
                Integer v = map.get(A[i]);
                map.put(A[i], ++v);
            } else {
                map.put(A[i], 1);
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (map.get(A[i]) < 2) {
                return A[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int result = new Solution2().solution(new int[] {9, 3, 9, 3, 9, 7, 9});
        System.out.println("Result is = " + result);
    }
}
