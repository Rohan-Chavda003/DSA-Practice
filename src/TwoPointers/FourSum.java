package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum
{
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> ans= new ArrayList<>();

            for(int i= 0 ; i< nums.length -3 ; i++){
                if(i!= 0 && nums[i] == nums[i-1] ) continue;
                int a  = i;
                for(int j = i+1; j< nums.length-2 ; j++){
                    if(j> i+1 && nums[j] == nums[j-1] ) continue;
                    int b = j;
                    int c = j+1;
                    int d = nums.length-1;
                    while(c < d ){
                        long sum = (long)nums[a] + nums[b] + nums[c] + nums[d];
                        if(sum < target){
                            c++;
                        }else if( sum > target){
                            d--;
                        }else{
                            ans.add(Arrays.asList(nums[a] , nums[b] , nums[c] , nums[d]));
                            c++;
                            d--;
                            while(c < d && nums[c] == nums[c-1]) c++;
                            while(c < d && nums[d] == nums[d+1]) d--;

                        }
                    }

                }
            }

            return ans;
        }
    }
}
