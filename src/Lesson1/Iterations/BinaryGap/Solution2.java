package Lesson1.Iterations.BinaryGap;

public class Solution2 {

    public int solution(int N) {

        String bin = Integer.toBinaryString(N);
        System.out.println(bin);
        int max_gap = 0;
        int current_gap =0;

        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '0') {
                current_gap++;
            } else {
                if (current_gap > 0) {
                    max_gap = Math.max(max_gap, current_gap);
                    current_gap = 0;
                }
            }
        }
        return max_gap;
    }

    public static void main(String[] args) {
        int result = new Solution2().solution(997);
        System.out.println("Result is = " + result);
        result = new Solution2().solution(9);
        System.out.println("Result is = " + result);
        result = new Solution2().solution(529);
        System.out.println("Result is = " + result);
        result = new Solution2().solution(20);
        System.out.println("Result is = " + result);
        result = new Solution2().solution(15);
        System.out.println("Result is = " + result);
        result = new Solution2().solution(32);
        System.out.println("Result is = " + result);
    }
}
