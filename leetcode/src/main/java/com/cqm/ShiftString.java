package com.cqm;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by qmcheng on 2017/10/25 0025.
 */
public class ShiftString {

  private static final int[] p = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

  public static void main(String[] args) {
    Algo g = new Algo();
    int[] num = {1, -2, 3, 10, -4, 7, 2, -5};
    System.out.println(g.findMaxSubArray(num));
  }

  private static void printIntList(int[] num) {
    for (int n : num) {
      System.out.print(n + " ");
    }
    System.out.println();
  }

  private static char[] moveStarString(char[] chars) {
    int n = chars.length;
    int p = n - 1;
    for (int i = n - 1; i >= 0; i--) {
      if (chars[i] != '*') {
        chars[p--] = chars[i];
      }
    }
    while (p >= 0) {
      chars[p--] = '*';
    }
    return chars;
  }

  private static int commonLength(char[] chars, int i, int j) {
    int length = 0;
    int m = j;
    while (i < m && j < chars.length && chars[i] == chars[j]) {
      length++;
      i++;
      j++;
    }
    return length;
  }

  private static int findLongestSubStr(char[] chars) {
    int maxLength = 0;
    int n = chars.length;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int length = commonLength(chars, i, j);
        if (maxLength < length)
          maxLength = length;
      }
    }
    return maxLength;
  }

  private static int deleteChars(char[] chars1, char[] chars2) {
    HashSet<Character> set = new HashSet<>();
    for (Character ch : chars2) {
      set.add(ch);
    }
    int p = 0;
    for (int i = 0; i < chars1.length; i++) {
      if (!set.contains(chars1[i])) {
        chars1[p++] = chars1[i];
      }
    }
    return p;
  }

  private static LinkNode findCommonLinkNode(LinkNode head1, LinkNode head2) {
    LinkNode cur1 = head1;
    LinkNode cur2 = head2;
    int n1 = 0, n2 = 0;
    while (cur1 != null) {
      n1++;
      cur1 = cur1.next;
    }
    while (cur2 != null) {
      n2++;
      cur2 = cur2.next;
    }
    cur1 = head1;
    cur2 = head2;
    if (n1 > n2) {
      for (int i = 0; i < n1 - n2; i++) {
        cur1 = cur1.next;
      }
    } else {
      for (int i = 0; i < n2 - n1; i++) {
        cur2 = cur2.next;
      }
    }
    while (cur1 != null && cur2 != null && cur1 != cur2) {
      cur1 = cur1.next;
      cur2 = cur2.next;
    }
    if (cur1 == null || cur2 == null) {
      return null;
    }
    return cur1;
  }

  private static void printLinkList(LinkNode head) {
    LinkNode cur = head;
    while (cur != null) {
      System.out.print(cur.value);
      cur = cur.next;
    }
    System.out.println();
  }

  private static LinkNode createLinkList(char[] chars) {
    LinkNode head = null;
    LinkNode cur = null;
    for (char ch : chars) {
      LinkNode node = new LinkNode();
      node.value = ch;
      if (head == null) {
        head = cur = node;
      } else {
        cur.next = node;
        cur = node;
      }
    }
    return head;
  }

  private static LinkNode appendLinkNode(LinkNode head, LinkNode node) {
    if (head == null)
      return node;
    LinkNode cur = head;
    while (cur.next != null)
      cur = cur.next;
    cur.next = node;
    return head;
  }

  private static LinkNode reverseLinkList(LinkNode head) {
    if (head == null) {
      return null;
    }
    LinkNode cur = head;
    LinkNode next = head.next;
    head.next = null;
    while (next != null) {
      LinkNode temp = next.next;
      next.next = cur;
      cur = next;
      next = temp;
    }
    return cur;
  }

  private static class LinkNode {
    char value;
    LinkNode next;
  }

  private static int findLongestMirror(char[] chars) {
    int max = 0;
    for (int i = 0; i < chars.length; i++) {
      int count = 0;
      for (int j = 0; i - j >= 0 && i + j + 1 < chars.length; j++) {
        if (chars[i - j] != chars[i + j + 1]) {
          break;
        }
        count = (j + 1) * 2;
      }
      if (max < count)
        max = count;
    }
    return max;
  }

  private static Character findSingle(char[] chars) {
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    for (Character ch : chars) {
      if (map.containsKey(ch)) {
        map.put(ch, map.get(ch) + 1);
      } else {
        map.put(ch, 1);
      }
    }
    for (Character ch : chars) {
      if (map.get(ch) == 1) {
        return ch;
      }
    }
    return null;
  }

  private static void permutation(char[] chars, int from, int to) {
    if (from == to) {
      System.out.println(chars);
      return;
    }
    for (int i = from; i <= to; i++) {
      swap(chars, i, from);
      permutation(chars, from + 1, to);
      swap(chars, i, from);
    }
  }

  private static void swap(char[] chars, int i1, int i2) {
    char temp = chars[i1];
    chars[i1] = chars[i2];
    chars[i2] = temp;
  }

  public static int longestPalindrome(String str) {
    int n = str.length();
    int max = 0;
    for (int i = 0; i < str.length(); i++) {
      int count = 0;
      for (int j = 0; i - j >= 0 && i + j < n; j++) {
        if (str.charAt(i - j) != str.charAt(i + j)) {
          break;
        }
        count = j * 2 + 1;
      }
      if (max < count)
        max = count;

      for (int j = 0; i - j >= 0 && i + j + 1 < n; j++) {
        if (str.charAt(i - j) != str.charAt(i + j + 1)) {
          break;
        }
        count = (j + 1) * 2;
      }
      if (max < count)
        max = count;
    }
    return max;
  }

  public static boolean contains(String str1, String str2) {
    int f = 1;
    for (int i = 0; i < str1.length(); i++) {
      int n = p[str1.charAt(i) - 'a'];
      if (f % n != 0) {
        f *= n;
      }
    }
    for (int i = 0; i < str2.length(); i++) {
      int n = p[str2.charAt(i) - 'a'];
      if (f % n != 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean containsHash(String str1, String str2) {
    HashSet<Character> set = new HashSet<>();
    for (int i = 0; i < str1.length(); i++) {
      if (!set.contains(str1.charAt(i))) {
        set.add(str1.charAt(i));
      }
    }
    for (int i = 0; i < str2.length(); i++) {
      if (!set.contains(str2.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  public static void reverseString(char[] chars, int from, int to) {
    while (from < to) {
      char temp = chars[from];
      chars[from++] = chars[to];
      chars[to--] = temp;
    }
  }
}
