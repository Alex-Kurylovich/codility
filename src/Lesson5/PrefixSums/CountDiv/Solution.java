package Lesson5.PrefixSums.CountDiv;

/*
Write a function:
class Solution { public int solution(int A, int B, int K); }
that, given three integers A, B and K,
returns the number of integers within the range [A..B] that are divisible by K, i.e.:
{ i : A ≤ i ≤ B, i mod K = 0 }
For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
Write an efficient algorithm for the following assumptions:
A and B are integers within the range [0..2,000,000,000];
K is an integer within the range [1..2,000,000,000];
A ≤ B.
 */
class Solution {
    public int solution(int A, int B, int K) {
        // write your code in Java SE 8
        
        // need to achieve low complexity O(1)
        // using math equation (low complexity)
        
        // number of divisible values smaller than B
        int num_B = (int) Math.floor( B/K );
        // note: take "Math.floor" which is the basic number
        
        // number of divisible values smaller than A
        int num_A = (int) Math.floor( A/K );
        // note: take "Math.floor" which is the basic number
        
        // number of divisible numbers
        int num_div = num_B - num_A;
        
        // note: plus one (if A % K == 0)
        // because "A" is also divisble 
        // without "plus", "A" will be deducted
        int plus = 0;
        if(A % K == 0)
            plus = 1;
            
        // num_div + plus
        num_div = num_div + plus;
        
        // return the number of K-divisible values between A and B
        return num_div;
    }
    
    public static void main(String[] args) {
 		int result = new Solution().solution(6, 11, 2);
 		System.out.println("Result is = " + result);
 	}
}
