import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q4IntersectionOfTwoArraysII {
    // leetcode 350. Intersection of Two Arrays II
    public int[] intersect_map(int[] nums1, int[] nums2) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            countMap.put(nums1[i], countMap.getOrDefault(nums1[i], 0) + 1);
        }

        for (int i = 0; i < nums2.length; i++) {
            // if (countMap.containsKey(nums2[i]) && countMap.get(nums2[i]) > 0) {
            if (countMap.getOrDefault(nums2[i], 0) > 0) {
                countMap.put(nums2[i], countMap.get(nums2[i]) - 1);
                result.add(nums2[i]);
            }
        }

        int[] resultInt = new int[result.size()];
        for (int i = 0; i < resultInt.length; i++) {
            resultInt[i] = result.get(i);
        }

        return resultInt;
    }

    public int[] intersection_simultaneous_traversal(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList<>();

        int index1 = 0;
        int index2 = 0;

        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                result.add(nums1[index1]);
                index1++;
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }

        int[] resultsInt = new int[result.size()];
        for (int i = 0; i < resultsInt.length; i++) {
            resultsInt[i] = result.get(i);
        }

        return resultsInt;
    }
}
