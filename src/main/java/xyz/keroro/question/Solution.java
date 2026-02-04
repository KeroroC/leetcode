package xyz.keroro.question;

import java.util.*;

/**
 * LeetCode
 * @author keroro
 * @since 2026年02月03日 17:54
 */
public class Solution {

    /**
     * 1768. 交替合并字符串
     * @param word1 word1
     * @param word2 word2
     * @return res
     */
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

    /**
     * 1071. 字符串的最大公因子
     * @param str1 str1
     * @param str2 str2
     * @return res
     */
    public String gcdOfStrings(String str1, String str2) {
        // 先判断是否存在字符串的最大公因子
        if (!(str1 + str2).equals(str2 + str1)) return "";
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }
    private int gcd(int a, int b) {
        // 辗转相除法得到长度的最大公约数
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * 1431. 拥有最多糖果的孩子
     * @param candies candies
     * @param extraCandies extraCandies
     * @return res
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int max = Arrays.stream(candies).max().getAsInt();
        for (int candy : candies) {
            res.add(candy + extraCandies >= max);
        }
        return res;
    }

    /**
     * 605. 种花问题
     * @param flowerbed flowerbed
     * @param n n
     * @return res
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int total = 0;
        int[] extend = new int[flowerbed.length + 2];
        System.arraycopy(flowerbed, 0, extend, 1, flowerbed.length);
        extend[0] = 0;
        extend[extend.length - 1] = 0;
        for (int i = 1; i < extend.length - 1; i++) {
            if (extend[i] == 0 && extend[i - 1] == 0 && extend[i + 1] == 0) {
                extend[i] = 1;
                total++;
            }
        }
        return total >= n;
    }

    /**
     * 345-反转字符串中的元音字母
     * @param s s
     * @return res
     */
    public static String reverseVowels(String s) {
        int l = 0; // 左指针
        int r = s.length() - 1; // 右指针
        // 将字符串 s 改成数组，方便交换字符
        char[] chars = s.toCharArray();
        // 所有元音字母，hash set 形式
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        while (l < r) {
            // 从左向右找元音字母
            while (l < s.length() && !vowels.contains(chars[l]))
                l++;
            // 从右向左找元音字母
            while (r >= 0 && !vowels.contains(chars[r]))
                r--;

            // 双指针相遇，退出
            if (l >= r) break;

            // 交换
            char temp = chars[l];
            chars[l++] = chars[r];
            chars[r--] = temp;
        }

        return new String(chars);
    }
}
