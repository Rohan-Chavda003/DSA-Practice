package TwoPointers;

public class CheckPalindrome2 {

    /*
    1768. Merge Strings Alternately

    You are given two strings word1 and word2.
    Merge the strings by adding letters in alternating order, starting with word1.
    If a string is longer than the other, append the additional letters onto the end of the merged string.

    Return the merged string.
     */

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() -1;
        int notMatched = 0;
        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else{
                return isPalindrome(left+1 , right , s) || isPalindrome(left , right-1 , s);

            }
        }
        return true;
    }

    boolean isPalindrome(int left  , int right , String s){
        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else
                return false;
        }
        return true;
    }
}
