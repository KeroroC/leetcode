package xyz.keroro.question;

/**
 * 1768. 交替合并字符串
 * @author keroro
 * @since 2026年02月03日 17:54
 */
public class Solution {

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int l1 = word1.length(), l2 = word2.length();
        int i = 0;
        while (i < l1 || i < l2) {
            if (i < l1) {
                res.append(word1.charAt(i));
            }
            if (i < l2) {
                res.append(word2.charAt(i));
            }
            i++;
        }
        return res.toString();
    }
}
