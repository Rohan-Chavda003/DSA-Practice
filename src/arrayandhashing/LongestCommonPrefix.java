package arrayandhashing;

import java.util.Arrays;

public class LongestCommonPrefix {
    /*
     Time Complexity: O(n * m)
     Space Complexity: O(m)

     Idea - First find the shortest string since that could be the Longest Common prefix .
            After that loop through the array and compare each string with the shortest string
            If it doesnt match then decrease the length by 1
            If it does move to next string
           Note : possible ways are recursion or While loop
    */

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        if(strs.length == 1)
            return strs[0];

        String shortestString=strs[0];
        for(String s : strs){
            if(s.length() < shortestString.length()){
                shortestString = s;
            }
        }
        String ans = shortestString;

        for(String s : strs){
            ans = RecursivePrefix(s, ans);
        }
        return ans;
    }

    String RecursivePrefix(String s, String prefix) {

        if(prefix.length() == 0)
            return "";

        if (s.startsWith(prefix)) {
            return prefix;
        }

        return RecursivePrefix(s, prefix.substring(0, prefix.length() - 1));
    }


    /*
     Time Complexity: O(n * m)
     Space Complexity: O(1)

     Idea - Vertical scanning , Compare the first string's character until either the current string is bigger than
      other string or the character does not match
    */

    public String longestCommonPrefixBestMethod(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }


    /*
    Worst way to solve it
     Time Complexity: O(n log n* m)
     Space Complexity: O(m)

     Idea - After sorting the first and last are going to have the largest difference and we need common of all strings
            so just compare them after sorting to get the common prefix .
            Because the common of these two will be present in all the in between strings.
    */

    public String longestCommonPrefixSimpleIdea(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        int i = 0;
        while (i < first.length() &&
                i < last.length() &&
                first.charAt(i) == last.charAt(i)) {
            i++;
        }

        return first.substring(0, i);
    }

}
