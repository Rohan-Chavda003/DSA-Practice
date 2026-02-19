package arrayandhashing;

import java.util.*;

/*

347. Top K Frequent Elements
Given an integer array nums and an integer k, return the k most frequent elements.
You may return the answer in any order.


Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Example 3:
Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
Output: [1,2]

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.


Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements
{
    public int[] topKFrequentBrute(int[] nums, int k) {
        /*
        Time Complexity:Counting → O(n)
                        Sorting → O(n log n)
                        Total: O(n log n)

        Brute Force : First count the frequency and then sort the array using comparator
        */
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(freq.keySet());

        Collections.sort(list, (a, b) -> freq.get(b) - freq.get(a));
        int[] ans = new int[k];
        for(int i=0 ; i< k ; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }

    /*
    Time Complexity:   Count freq → O(n)
                       Heap operations → O(n log k)
    Space Complexity: O(n)

    Idea : Use priority queue which is by default a min heap where the smallest number is at the top,
            easy to use here because we can remove the least frequent easily
   */

    public int[] topKFrequentOptimal(int[] nums, int k) {
        HashMap<Integer , Integer> freq = new HashMap<>();
        for(int i=0 ; i< nums.length ; i++){
            freq.put(nums[i] , freq.getOrDefault(nums[i] , 0)+1 );
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a,b) -> freq.get(a) - freq.get(b)
        );

        for(int i : freq.keySet()){
            pq.add(i);
            if(pq.size() >k)
                pq.poll();
        }
        int[] ans = new int[k];
        for(int i=0; i< k ; i++){
            ans[i] = pq.poll();
        }

        return ans;

    }

    /*
     Time Complexity: O(n)
     Space Complexity: O(n)
     Idea : use bucket sort ::: Dont skip this time
    */
    public int[] topKFrequentBest(int[] nums, int k) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for (int key : freq.keySet()) {
            int f = freq.get(key);

            if (bucket[f] == null) {
                bucket[f] = new ArrayList<>();
            }

            bucket[f].add(key);
        }

        int[] ans = new int[k];
        int index = 0;

        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    ans[index++] = num;
                    if (index == k) break;
                }
            }
        }

        return ans;
    }
}
