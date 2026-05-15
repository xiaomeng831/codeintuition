import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q3IntersectionofTwoArrays {
    public int[] intersection_set(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }

        int index = 0;
        int[] results = new int[set2.size()];

        for (int num : set2) {
            results[index] = num;
            index++;
        }

        return results;
    }

    public int[] intersection_simultaneous_traversal(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int index1 = 0;
        int index2 = 0;

        List<Integer> results = new ArrayList<>();

        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                if (results.isEmpty() || results.get(results.size() - 1) != nums1[index1]) {
                    results.add(nums1[index1]);
                }

                index1++;
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }

        int[] resultsInt = new int[results.size()];
        for (int i = 0; i < resultsInt.length; i++) {
            resultsInt[i] = results.get(i);
        }
        return resultsInt;
    }
}
