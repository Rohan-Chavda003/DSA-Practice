package arrayandhashing;

public class ValidAnagram {

    /*
     Time Complexity: O(n)
     Space Complexity: O(1)

     Idea - Create a char frequency of first string then use that
            to see whether the second string cancels out with the first string
     (Note : this time Use array of int not the map of char and int)
    */

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        int[] freq = new int[26];
        for(int i= 0 ; i< s.length() ; i++){
            freq[(int)(s.charAt(i) - 'a')]++;
        }
        for(int i= 0 ; i< s.length() ; i++){
            freq[(int)(t.charAt(i) - 'a')]--;
        }
        for(int i : freq){
            if(i != 0)
                return false;
        }
        return true;


    }
    /*
     Time Complexity: O(nlogn)
     Space Complexity: O(n)

     Idea - Another way is to Sort both string and compare

    */

}
