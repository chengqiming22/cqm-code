package com.cqm;

import java.util.ArrayList;

/**
 * Created by qmcheng on 2017/10/26 0026.
 */
public class Algo {
  private ArrayList<Integer> list = new ArrayList<>();

  public void findKNumber(int[] num, int n, int sum) {
    if (n <= 0 || sum <= 0) {
      return;
    }
    int lastNum = num[n - 1];
    if (lastNum == sum) {
      System.out.print(lastNum + " ");
      for (int i = list.size() - 1; i >= 0; i--) {
        System.out.print(list.get(i) + " ");
      }
      System.out.println();
    }
    list.add(lastNum);
    findKNumber(num, n - 1, sum - lastNum);
    list.remove(list.size() - 1);
    findKNumber(num, n - 1, sum);
  }

  public void findFixedKNumber(int[] num, int start, int k, int sum) {
    if (k < 2 || start >= num.length) {
      return;
    }
    if (k == 2) {
      findFixed2Number(num, start, sum);
    } else {
      int startNum = num[start];
      list.add(startNum);
      findFixedKNumber(num, start + 1, k - 1, sum - startNum);
      list.remove(list.size() - 1);
      findFixedKNumber(num, start + 1, k, sum);
    }
  }

  private void findFixed2Number(int[] num, int start, int sum) {
    int i = start;
    int j = num.length - 1;
    while (i < j) {
      int target = num[i] + num[j];
      if (target < sum)
        i++;
      else if (target > sum)
        j--;
      else {
        for (int n : list) {
          System.out.print(n + " ");
        }
        System.out.print(num[i] + " ");
        System.out.println(num[j]);
        i++;
        j--;
      }
    }
  }

  private int quickPartition(int[] num, int start, int end) {
    if (start >= end) {
      return start;
    }
    int key = num[start];
    int left = start;
    int right = end;
    while (left < right) {
      while (right > left && num[right] > key)
        right--;
      num[left] = num[right];
      while (left < right && num[left] < key)
        left++;
      num[right] = num[left];
    }
    num[left] = key;
    return left;
  }

  public void quickSort(int[] num, int start, int end) {
    if (start >= end)
      return;
    int m = quickPartition(num, start, end);
    quickSort(num, start, m - 1);
    quickSort(num, m + 1, end);
  }

  public int findMaxSubArray(int[] num) {
    int n = num.length;
    int maxSum = 0;
    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int j = i; j < n; j++) {
        sum += num[j];
        if(maxSum < sum)maxSum = sum;
      }
    }
    return maxSum;
  }
}
