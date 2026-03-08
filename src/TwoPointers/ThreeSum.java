package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {

    /*
    15. 3Sum
Given an integer array nums, return all the triplets
[nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
     */

    /*           set
    time : n^2 x log(M)
    space : O(N) + O(no.of unique triplets)x2
                    because of list of list which returns all the answer
     */
        public List<List<Integer>> threeSum(int[] nums) {
            HashSet<List<Integer>> store = new HashSet<>();
            int a ,b,c =0;
            for(int i =0 ; i< nums.length ; i++){
                a= nums[i];
                HashSet<Integer> set = new HashSet<>();
                for(int j = i+1 ; j< nums.length ; j++){
                    b = nums[j];
                    int needed  =  -(a + b);
                    if(set.contains(needed) ){
                        int[] temp = {a, b, needed};
                        Arrays.sort(temp);
                        store.add(Arrays.asList(temp[0], temp[1], temp[2]));
                    }
                    set.add(nums[j]);
                }
            }

            List<List<Integer>> ans = new ArrayList<>(store);
            return ans;
        }

        /*
        time : nlog(n) + n^2
        space : O(no. of unique triplets)
         */

    public List<List<Integer>> threeSumOptimized(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        int a ,b,c =0;
        Arrays.sort(nums);
        for(int i =0 ; i< nums.length ; i++){
            if(i>0 && nums[i] == nums[i-1] ) continue;
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0 ){
                    j++;
                }else if(sum > 0){
                    k--;
                }else{
                    ans.add(Arrays.asList(nums[i], nums[j] , nums[k]));
                    j++;
                    k--;
                    while(j<k && nums[j] == nums[j-1]) j++;
                    while(j<k && nums[k] == nums[k-1]) k--;
                }
            }

        }
        return ans;
    }
}
