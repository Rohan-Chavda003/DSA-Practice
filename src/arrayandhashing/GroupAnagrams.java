package arrayandhashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
49. Group Anagrams
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]

Constraints:
1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.

 */
public class GroupAnagrams {

    /*
     Time Complexity: O(n x m)   n = number of strings
     Space Complexity: O(n x m ) m = average string length

     Idea : build a hash key using frequency of characters in a string
     here the hash key would be abbc - 1#2#1#0.......
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String ,List<String>> pairs = new HashMap<String , List<String>>();

        for(String s : strs){
            char[] temp = s.toCharArray();
            int[] freq = new int[26];
            for(char c : temp){
                freq[c-'a']++;
            }
            StringBuilder keyBuilder = new StringBuilder();
            for(int f : freq){
                keyBuilder.append(f).append("#");
            }
            if(!pairs.containsKey(keyBuilder.toString())){
                pairs.put(keyBuilder.toString() , new ArrayList<>());
            }
            pairs.get(keyBuilder.toString()).add(s);

        }

        return new ArrayList<>(pairs.values());
    }


    /*
     Time Complexity: O(n x m log m)
     Space Complexity: O(n x m)
     Idea : sort each string and use it as a key
    */
    public List<List<String>> groupAnagramsBest(String[] strs) {
        HashMap<String ,List<String>> pairs = new HashMap<String , List<String>>();

        for(String s : strs){
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            if(!pairs.containsKey(new String(temp))){
                pairs.put(new String(temp) , new ArrayList<>());
            }
            pairs.get(new String(temp)).add(s);


        }

        return new ArrayList<>(pairs.values());
    }

}
