package org.leetcode.solution.MedianOfTwoSortedArray;

import java.util.Arrays;
import java.util.stream.Stream;

public class SolutionMedianOf2SortedArray {
    public double findMedianSortedArrays_strange(int[] nums1, int[] nums2){
        int size1 = nums1.length;
        int size2 = nums2.length;
        if (size1 == 0 && size2 == 0)
            return 0;
        if (size1 == 0)
            return makeMedian(nums2);
        if (size2 == 0)
            return makeMedian(nums1);
        int firstIndex1 = 0;
        int lastIndex1 = size1-1;
        int firstIndex2 = 0;
        int lstIndex2 = size2 -1;
        int remainder = (size1 +size2) % 2 == 0 ? 2 : 1;
        while (lastIndex1 - firstIndex1 + 1 + lstIndex2 -firstIndex2 + 1 > remainder){
            if (firstIndex1 > lastIndex1){
                firstIndex2++;
            } else if (firstIndex2 > lstIndex2){
                firstIndex1++;
            } else if (nums1[firstIndex1] > nums2[firstIndex2])
                firstIndex2 ++;
            else
                firstIndex1 ++;

            if (firstIndex1 > lastIndex1){
                lstIndex2--;
            } else if (firstIndex2 > lstIndex2){
                lastIndex1--;
            } else if (nums1[lastIndex1] > nums2[lstIndex2])
                lastIndex1--;
            else
                lstIndex2 --;
        }
        if (remainder == 1)
            return firstIndex1 > lastIndex1 ? nums2[firstIndex2] : nums1[firstIndex1];
        return makeResponse (nums1, nums2, firstIndex1, firstIndex2, lastIndex1, lstIndex2);
    }
    private double makeResponse (int[] nums1, int[] nums2, int firstIndex1, int firstIndex2, int lastIndex1, int lstIndex2){
        if (firstIndex1 > lastIndex1)
            return (double)(nums2[firstIndex2] + nums2[lstIndex2])/2;
        if (firstIndex2 > lstIndex2)
            return (double)(nums1[firstIndex1] + nums1[lastIndex1])/2;
        return (double)(nums1[firstIndex1] + nums2[lstIndex2])/2;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int size1 = nums1.length;
        int size2 = nums2.length;
        if (size1 == 0 && size2 == 0)
            return 0;
        if (size1 == 0)
            return makeMedian(nums2);
        if (size2 == 0)
            return makeMedian(nums1);
        int sizeFull = size1+size2;
        int start1 = size1/2;
        int start2 = (sizeFull + 1)/2 - start1;
        boolean isMaxLeft1 = false;
        boolean isMaxLeft2 = false;
        do{
            if (start1 <= 0|| start2 >= size2)
                isMaxLeft1 = true;
            else {
                if (nums1[start1-1] <= nums2[start2])
                    isMaxLeft1 = true;
            }
            if (start2 <= 0 || start1 >= size1)
                isMaxLeft2 = true;
            else {
                if (nums2[start2-1] <= nums1[start1])
                    isMaxLeft2 = true;
            }
            if (!(isMaxLeft1 && isMaxLeft2))
                if (isMaxLeft1) {
                    start1++;
                    start2--;
                } else {
                    start1 --;
                    start2++;
                }
        } while (!(isMaxLeft1 && isMaxLeft2));
        if (sizeFull % 2 != 0)
            return getMax(nums1, nums2, start1-1, start2-1);
        return (double)(getMax(nums1, nums2, start1-1, start2-1) + getMin(nums1, nums2, start1, start2))/2 ;
    }
    private int getMax(int[] nums1, int[] nums2, int size1, int size2){
        if (size1 < 0  || size1 >= nums1.length)
            return nums2[size2];
        if (size2 < 0 || size2 >= nums2.length)
            return nums1[size1];
        return Math.max(nums2[size2], nums1[size1]);
    }
    private int getMin (int[] nums1, int[] nums2, int size1, int size2){
        if (size1 < 0 || size1 >= nums1.length)
            return nums2[size2];
        if (size2 < 0 || size2 >= nums2.length)
            return nums1[size1];
        return Math.min(nums2[size2], nums1[size1]);
    }

    public double findMedianSortedArrays_slow(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        if (size1 == 0 && nums2.length == 0)
            return 0;
        if (size1 == 0)
            return makeMedian(nums2);
        if (size2 == 0)
            return makeMedian(nums1);
        int [] resArr = new int[size1 + size2];
        int sizeFull = resArr.length;
        for (int i = 0, k = 0, z = 0; z < sizeFull; z++ ) {
            if (i < 0 || k < 0)
                if (i < 0) {
                    for (; z < sizeFull; z++, k++){
                        resArr[z] = nums2[k];
                    }
                } else {
                    for (; z < sizeFull; z++, i++){
                        resArr[z] = nums1[i];
                    }
                }
            else {
                if (nums1[i] < nums2[k]){
                    resArr[z] = nums1[i];
                    if (i == size1 - 1)
                        i = -1;
                    else i++;
                } else if (nums1[i] > nums2[k]){
                    resArr[z] = nums2[k];
                    if (k == size2 - 1)
                        k = -1;
                    else k++;
                } else {
                    resArr[z] = nums2[k];
                    if (k == size2 - 1)
                        k = -1;
                    else k++;
                    z++;
                    resArr[z] = nums1[i];
                    if (i == size1 - 1)
                        i = -1;
                    else i++;
                }
            }

        }
        return makeMedian(resArr);
    }

    private double makeMedian (int[] arr){
        if (arr.length % 2 > 0)
            return arr[arr.length / 2];
        return ((double) (arr[arr.length / 2] + arr[arr.length / 2 - 1])) / 2;
    }

    public double findMedianSortedArrays_long(int[] nums1, int[] nums2) {
        int[] resArr2 = Stream.concat(Arrays.stream(nums1).boxed(), Arrays.stream(nums2).boxed()).sorted().mapToInt(Integer::intValue).toArray();
        if (resArr2.length % 2 > 0)
            return resArr2[resArr2.length / 2];
        return ((double) (resArr2[resArr2.length / 2] + resArr2[resArr2.length / 2 - 1])) / 2;
    }
}
