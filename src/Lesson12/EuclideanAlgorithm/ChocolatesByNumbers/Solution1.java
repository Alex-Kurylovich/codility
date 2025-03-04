// This solution is simple and correct
// but a bit low performance (100% correct and 25% performance)

package Lesson12.EuclideanAlgorithm.ChocolatesByNumbers;

import java.util.HashSet;
import java.util.Set;

/*
Two positive integers N and M are given. Integer N represents the number of chocolates arranged in a circle,
numbered from 0 to N − 1.
You start to eat the chocolates. After eating a chocolate you leave only a wrapper.
You begin with eating chocolate number 0. Then you omit the next M − 1 chocolates or wrappers on the circle,
and eat the following one.
More precisely, if you ate chocolate number X,
then you will next eat the chocolate with number (X + M) modulo N (remainder of division).
You stop eating when you encounter an empty wrapper.
For example, given integers N = 10 and M = 4. You will eat the following chocolates: 0, 4, 8, 2, 6.
The goal is to count the number of chocolates that you will eat, following the above rules.
Write a function:
class Solution { public int solution(int N, int M); }
that, given two positive integers N and M, returns the number of chocolates that you will eat.
For example, given integers N = 10 and M = 4. the function should return 5, as explained above.
Write an efficient algorithm for the following assumptions:
N and M are integers within the range [1..1,000,000,000].
 */
class Solution1 {
    public int solution(int N, int M) {

        Set<Integer> set = new HashSet<>();
        
        int currentNumber =0;
        set.add(currentNumber); // the 1st chocolate
        int numChocolate = 1;   // eat the 1st one
        
        while(true){
            currentNumber = (currentNumber + M) % N;
            if(set.contains(currentNumber) == true){
                break;
            }
            else{
                numChocolate++; // eat one more chocolate
                set.add(currentNumber); // record its number
            }
        }
        
        return numChocolate;
    }
    
	public static void main(String[] args) {
		int result = new Solution1().solution(10, 4);
		System.out.println("Result is = " + result);
	}
}
