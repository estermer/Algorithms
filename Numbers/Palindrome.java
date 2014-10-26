//Determine whether an integer is a palindrome. Do this without extra space.

public class Palindrome {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        int sLen = s.length();
        
        int i = 0;
        int j = sLen - 1;
        
        while(i < j) {
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}

