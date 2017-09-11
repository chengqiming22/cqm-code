package com.cqm;

import java.io.Console;
import java.util.Scanner;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4, 100};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }

    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int i1 = 0, i2 = 0, i = 0;
            int nums[] = new int[nums1.length + nums2.length];
            while (i1 < nums1.length && i2 < nums2.length) {
                if (nums1[i1] < nums2[i2]) {
                    nums[i++] = nums1[i1++];
                } else {
                    nums[i++] = nums2[i2++];
                }
            }
            while (i1 < nums1.length) {
                nums[i++] = nums1[i1++];
            }
            while (i2 < nums2.length) {
                nums[i++] = nums2[i2++];
            }
            return (nums[(nums.length - 1) / 2] + nums[nums.length / 2]) / 2.0;
        }
    }
}
