package arrayandhashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElement2 {

    /*
    229. Majority Element II
    Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

    Example 1:

    Input: nums = [3,2,3]
    Output: [3]
    Example 2:

    Input: nums = [1]
    Output: [1]
    Example 3:

    Input: nums = [1,2]
    Output: [1,2]

    Constraints:
    1 <= nums.length <= 5 * 104
    -109 <= nums[i] <= 109

    Follow up: Could you solve the problem in linear time and in O(1) space?
     */
    public List<Integer> majorityElementOptimal(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
            if (freq.get(n) > nums.length / 3 && !ans.contains(n)) {
                ans.add(n);

            }
        }
        return ans;
    }

    public List<Integer> majorityElementBest(int[] nums) {

        List<Integer> ans  = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;
        int candidate1 = 0;
        int candidate2 = 0;
        for(int num : nums){
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int n : nums){
            if(n == candidate1) count1++;
            if(n == candidate2) count2++;
        }
        if(count1 > nums.length / 3) ans.add(candidate1);
        if(count2 > nums.length / 3 && candidate2 != candidate1) ans.add(candidate2);

        return ans;
    }
}
