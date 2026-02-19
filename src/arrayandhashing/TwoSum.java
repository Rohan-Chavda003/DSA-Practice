package arrayandhashing;

import java.util.HashMap;

public class TwoSum {

    /*
     Time Complexity: O(n)
     Space Complexity: O(n)

     Idea - Iterate the array and determine whether the number needed after subtracting target from
            the current index number
    */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer , Integer> remaining = new HashMap<Integer , Integer>();
        int i =0;
        int needed = 0;
        for(i = 0 ; i< nums.length ; i++){
            needed = target - nums[i];
            if(remaining.containsKey(needed)){
                return new int[]{ remaining.get(needed), i };
            }
            remaining.put(nums[i] , i);
        }
        return new int[]{};

    }


    /*
     Time Complexity: O(n²)
     Space Complexity: O(1)

     Idea - Brute force - 2 for loops
    */
    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};

    }
}
