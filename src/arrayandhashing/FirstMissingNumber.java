package arrayandhashing;

import java.util.HashSet;

public class FirstMissingNumber {
    /*
    41. First Missing Positive
    Given an unsorted integer array nums.
    Return the smallest positive integer that is not present in nums.
    You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.



    Example 1:

    Input: nums = [1,2,0]
    Output: 3
    Explanation: The numbers in the range [1,2] are all in the array.
    Example 2:

    Input: nums = [3,4,-1,1]
    Output: 2
    Explanation: 1 is in the array but 2 is missing.
    Example 3:

    Input: nums = [7,8,9,11,12]
    Output: 1
    Explanation: The smallest positive integer 1 is missing.

    Constraints:

    1 <= nums.length <= 105
    -231 <= nums[i] <= 231 - 1
     */
    public int firstMissingPositiveWithSet(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        int ans = 1;
        int i = 0;
        int max = 0;
        for(int num : nums){
            if(num > max)
                max = num;
            set.add(num);
        }
        while(ans <=  max){
            if(nums[i] <= 0){
                i++;
                continue;
            }
            if(!set.contains(ans)){
                return ans;
            }else{
                ans++;
                i++;
            }

        }
        return max+1;

    }


    // Optimal solution
    /*
    Idea : for example the array is 3,4,-1,1 our ans is between the arraylength that is 4 and 1 which is
     minimum number so we will try to place the 3 where it would be in sorted array of 1 to 4
     that is at 2nd index
           which is - number -1 = index
     */
    public int firstMissingPositive(int[] nums) {
        int temp = 0;
        for(int i = 0 ; i< nums.length ; i++){
            while(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] -1] != nums[i]){


                temp = nums[nums[i] -1];
                nums[nums[i] - 1] = nums[i];
                nums[i]  = temp;

            }

        }
        for(int j = 0 ; j< nums.length ; j++ ){
            if(nums[j]  != j+1)
                return j+1;
        }
        return nums.length+1;

    }

}
