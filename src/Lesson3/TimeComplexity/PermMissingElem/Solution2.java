package Lesson3.TimeComplexity.PermMissingElem;

public class Solution2 {

    public int solution(int[] A) {

        // Using the concept of sum of arithmetic progression
        // Sum = (a[1] + a[n]) * n / 2
        // the missing element can be found by minus other elements

        int sum = (1 + (A.length + 1)) * (A.length + 1) / 2;

        for(int i=0; i<A.length; i++){
            sum = sum - A[i];
        }

        return sum;
    }

    public static void main(String[] args) {
		int result1 = new Solution2().solution(new int[] {2, 3, 1, 5});
        System.out.println("Result is = " + result1);
        int result2 = new Solution2().solution(new int[] {6, 1, 4, 2, 5});
        System.out.println("Result is = " + result2);
    }
}
