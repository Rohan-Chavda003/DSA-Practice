package arrayandhashing;

import java.util.Arrays;
import java.util.HashSet;

public class LongestSequence {

    public int longestConsecutiveWithoutSorting(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i: nums)
            set.add(i);


        int max = 0;
        for(int i =0 ; i< nums.length ; i++){
            if(!set.contains(nums[i] - 1)){
                int num = nums[i];
                int streak = 1;
                while(set.contains(num+1)){
                    num++;
                    streak++;
                }
                if(max < streak)
                    max = streak;
                if(max > nums.length/2)
                    return max;
            }
        }
        return max;

    }

    public int longestConsecutiveWithSorting(int[] nums) {
        Arrays.sort(nums);
        int max=0,count=0;
        int i=0;
        for(i=0;i<nums.length-1;i++){
            if(nums[i]+1==nums[i+1]){
                count++;
                if(count>max) max=count;
            }else if(nums[i]==nums[i+1]){

            }
            else{
                count=0;
            }
        }
        if(i==nums.length-1) max=max+1;
        return max;
    }
}
