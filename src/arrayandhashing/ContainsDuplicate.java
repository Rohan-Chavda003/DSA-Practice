package arrayandhashing;

import java.util.HashSet;

/*
217. Contains Duplicate

Given an integer array nums, return true if any value appears at least twice in the array,
and return false if every element is distinct.



Example 1:
Input: nums = [1,2,3,1]
Output: true

Explanation:
The element 1 occurs at the indices 0 and 3.

Example 2:
Input: nums = [1,2,3,4]
Output: false

Explanation:
All elements are distinct.

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109

 */
public class ContainsDuplicate {
    /*
     Time Complexity: O(n)  - HashSet operations are O(1) average, but O(n) worst case (due to hash collisions).
     Space Complexity: O(n)
    */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i : nums){
            if(set.contains(i)) return true;
            set.add(i);
        }

        return false;
    }

    /*
    For Space complexity of O(1) just sort the array and compare current index with its previous one
    */
}
