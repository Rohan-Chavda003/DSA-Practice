package arrayandhashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {

    /*
     Time Complexity: O(n )
     Space Complexity: O(n  )

     Idea : encode using size + hash+ string
     and decode it using that but remember that there could be 2 digits size not just 1
    */
    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length())
                    .append("#")
                    .append(s);
        }

        return sb.toString();
    }
    public List<String> decode(String str) {

        List<String> ans = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {

            // Step 1: find '#'
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            // Step 2: get length
            int size = Integer.parseInt(str.substring(i, j));

            // Step 3: extract string
            String word = str.substring(j + 1, j + 1 + size);
            ans.add(word);

            // Step 4: move pointer
            i = j + 1 + size;
        }

        return ans;
    }


}
