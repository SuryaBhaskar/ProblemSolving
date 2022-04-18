package arrays;

import java.util.HashSet;
import java.util.Set;

public class SubStringLengthWithoutRepeatingChars {

	public static void main(String[] args) {
			
		String input = "abcdbefghb";
		System.out.println(lengthOfLongestSubstring(input));
	}
	
	public static int lengthOfLongestSubstring(String s) {
        
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int currLength = 1;
        int currStart = 0;
        int currEnd = 0;
        
        int maxLength = 1;
        int maxStart = 0;
        int maxEnd = 0;
        
        Set<Character> map = new HashSet<>();
        map.add(s.charAt(0));
        
        for (int i=1; i<s.length(); i++) {
            if (!map.contains(s.charAt(i))) {
                map.add(s.charAt(i));
                currEnd=i;
                currLength++;
                
                if (maxLength < currLength) {
                    maxLength = currLength;
                    maxStart = currStart;
                    maxEnd = currEnd;
                }
            }
            else {
                // Remove elements upto that matching character and decrease those count from the currLength
                for (int j=currStart; j<currEnd; j++) {
                    map.remove(s.charAt(j));
                    currLength--;
                    currStart++;
                    
                    if (s.charAt(j)==s.charAt(i)) {
                        break;
                    }
                }
            }
        }
        
        System.out.println("startIndex: " + maxStart);
        System.out.println("endIndex: " + maxEnd);
        return maxLength;
    }

}
