package arrayandhashing;

import java.util.HashMap;

/*
169. Majority Element
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2


Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
The input is generated such that a majority element will exist in the array.


Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
public class MajorityElement {

    /*
     Time Complexity: O(n)  - HashSet operations are O(1) average, but O(n) worst case (due to hash collisions).
     Space Complexity: O(n)

    */
    public int majorityElementOptimal(int[] nums) {
        HashMap<Integer ,Integer> freq = new HashMap<Integer , Integer>();
        for(int i: nums){
            if(!freq.containsKey(i)){
                freq.put(i , 0);
            }                                //Improvement :  freq.put(i, freq.getOrDefault(i, 0) + 1);
            freq.put(i , freq.get(i)+1);
            if(freq.get(i) > nums.length/2)
                return i;
        }
        return 0;
    }


    /*
    Time Complexity: O(n)
     Space Complexity: O(1)
     Idea : Moore algorithm - here the idea is the majority element will be the remain at last since other will
           cancel each other out
     */

    public int majorityElementBest(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

}
