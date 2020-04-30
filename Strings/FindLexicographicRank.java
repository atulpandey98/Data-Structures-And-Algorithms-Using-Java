// Given a string, find it's lexicographic rank.
// Input : "BCA"
// OUTPUT : 4
// ABC, ACB, BAC, BCA, CAB, CBA
// O(n) - Count array is a constant array of 256 size.

package Strings;

class Main {

    static final int MAX_CHAR = 256;

    private static int factorial(int n) {
        if(n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    //count frequency of characters and then cummulative frequency
    private static void countFrequency(int[] count, char[] str) {
        for(int i = 0; i < str.length; i++) {
            count[str[i]]++;
        }
        for(int i = 1; i < MAX_CHAR; i++) {
            count[i] = count[i] + count[i - 1];
        }
    }

    //After each iteration of string, we have to decrease frequency of charaters occuring to the right
    //because we won't consider this character anymore.
    private static void updateFrequency(int[] count, char ch) {
        for(int i = ch; i < MAX_CHAR; i++) {
            count[i]--;
        }
    }

    private static int findLexicographicRank(String str) {
        int length = str.length();
        int mul = factorial(length);
        int[] count = new int[MAX_CHAR];
        char[] charArray = str.toCharArray();
        countFrequency(count, charArray);
        int rank = 1;
        for(int i = 0; i < length; i++) {
            mul = mul / (length - i);
            rank += count[charArray[i] - 1] * mul;
            updateFrequency(count, charArray[i]);
        }

        return rank;
    }
    
    public static void main(String[] args) {
        String str = "CDAB";
        System.out.println(findLexicographicRank(str));
    }
}