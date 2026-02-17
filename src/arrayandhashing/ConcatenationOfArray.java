package arrayandhashing;

public class ConcatenationOfArray {
    /*
     Problem: Concatenation of Array
     Pattern: Array
     Time Complexity: O(n)
     Space Complexity: O(n)
    */
    public int[] getConcatenation(int[] nums) {
        int numsLength = nums.length;
        int[] ans = new int[2 * numsLength];
        for(int i=0 ; i<= numsLength -1 ; i++ ){
            ans[i] = nums[i];
            ans[i+ numsLength ] = nums[i];
        }
        return ans;
    }
}
