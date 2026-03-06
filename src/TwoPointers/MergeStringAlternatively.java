package TwoPointers;

public class MergeStringAlternatively
{

    public String mergeAlternately(String word1, String word2) {
        StringBuilder str = new StringBuilder();
        int i =0;
        int x1 =0;
        int x2=0;
        int len1 = word1.length();
        int len2 = word2.length();
        int minLength = len1>len2 ? len2 : len1;
        while(i< minLength){
            str.append(word1.charAt(x1));
            x1++;
            str.append(word2.charAt(x2));
            x2++;
            i++;
        }
        if(x1 < len1){
            str.append(word1 , minLength , len1);
        }else if(x2 < len2){
            str.append(word2 , minLength , len2);
            x2++;
        }
        return str.toString();
    }
}
