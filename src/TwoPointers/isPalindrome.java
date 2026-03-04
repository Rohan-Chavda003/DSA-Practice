package TwoPointers;

public class isPalindrome {

    public boolean isPalindrome(String s) {
        /*
        Space complexity : O(n)
         */
        char[] arr = s.toCharArray();
        StringBuilder str = new StringBuilder();
        for(char c : arr){
            if((c >= 65  && c <= 90 ) || (c >= 97 && c <= 122) || (c >= 48 && c <= 57)){
                char temp = c;
                if(c >= 65 && c <= 90){
                    temp = Character.toLowerCase(c);
                }
                str.append(temp);
            }
        }
        int start = 0;
        int end = str.length() - 1;

        while( start  < end ){
            if(str.charAt(start) == str.charAt(end) ){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }



    /*
    space compexity : O(1)
     */
    public boolean isPalindromeOptimized(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
                left++;

            while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
                right--;

            if (Character.toLowerCase(s.charAt(left)) !=
                    Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }


}
