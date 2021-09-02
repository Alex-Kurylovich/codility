// This solution is simple and correct
// but a bit low performance (100% correct and 25% performance)

package ChocolatesByNumbers;

import java.util.HashSet;
import java.util.Set;

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
