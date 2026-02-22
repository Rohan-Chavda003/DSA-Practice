package arrayandhashing;

import java.util.Arrays;

public class ProductExceptSelf {
    /*
     Whenever a problem says:
        “sum/product of elements except current”
        “left of i”
        “right of i”
        “subarray info per index”
        You should think:
        “Can I break this into left contribution and right contribution?”
    That’s the prefix/suffix pattern.
     */

    public int[] productExceptSelf(int[] nums) {
        int[] prod = new int[nums.length];
        Arrays.fill(prod, 1);
        int left =1;
        for(int i=0; i<nums.length ; i++){
            prod[i] = left;
            left =left * nums[i];
        }
        int right =1;
        for(int i=nums.length-1 ;i>=0  ; i-- ){
            prod[i] *= right;
            right = right * nums[i];
        }
        return prod;
    }
}
