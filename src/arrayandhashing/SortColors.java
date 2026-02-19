package arrayandhashing;

/*
75. Sort Colors
Given an array nums with n objects colored red, white, or blue,
sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.



Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]


Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.


Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */
public class SortColors {

    /*
     Time Complexity: O(n)
     Space Complexity: O(1)
     Idea : just count the frequency
    */
    public void sortColorsOptimal(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == 0) count0++;
            else if (num == 1) count1++;
            else count2++;
        }

        int index = 0;
        while (count0-- > 0) nums[index++] = 0;
        while (count1-- > 0) nums[index++] = 1;
        while (count2-- > 0) nums[index++] = 2;
    }


    /*
     Time Complexity: O(n)
     Space Complexity: O(1)
     Idea : Two Pointers , one will track 0 other will track 2 and use a for loop to iterate and swap
    */
    public void sortColorsBest(int[] nums) {
        int l=0;
        int r=nums.length -1;
        for(int i=0 ; i<= r ; i++){
            if(nums[i] == 0){
                swap(nums , i , l);
                l++;
            }
            else if(nums[i] == 2){
                swap(nums,i , r);
                r--;
                i--;
            }
        }
    }
    void swap(int[] nums ,int l,int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
