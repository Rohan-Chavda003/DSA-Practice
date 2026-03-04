package TwoPointers;

public class CheckPalindrome2 {
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
