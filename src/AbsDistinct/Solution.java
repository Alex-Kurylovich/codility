package AbsDistinct;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] A) {
        
        // using "Set"
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<A.length; i++){
            // note: using "Math.abs(int)"
            if( set.contains( Math.abs(A[i]) ) == false ){
                set.add( Math.abs(A[i]) );
            }
            else{
                // do nothing (already existed in the set)
            }
        }
        
        return set.size();
     }
    
    
	public static void main(String[] args) {
		int result = new Solution().solution(new int[] {-5, -3, -1, 0, 3, 6});
		System.out.println("Result is = " + result);
	}
}
