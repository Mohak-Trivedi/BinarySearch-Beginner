// Problem: https://leetcode.com/problems/single-element-in-a-sorted-array/description/

// Brute force: TC: O(N), SC: O(1)
// XOR all elements, the final answer will be the single element.

// Optimized approach: TC: O(logN), SC: O(1)
// Binary Search modified. Always have search range of odd length.

// Logic:
// For an array to contain a non-duplicate once and all others exactly twice, it must have odd length.

class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length % 2 == 0)
            return -1;

        if (nums.length == 1)
            return nums[0];

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (mid != 0 && mid != nums.length - 1 && nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            } else if (mid == 0 && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            } else if (mid == nums.length - 1 && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            } else if (nums[mid] == nums[mid - 1]) {
                int li = mid - 1;
                int ri = r;

                int numOfEle = ri - li + 1;

                if (numOfEle % 2 == 0) {
                    r = mid - 2;
                } else {
                    l = mid + 1;
                }
            } else { // nums[mid] == nums[mid + 1]
                int li = mid;
                int ri = r;

                int numOfEle = ri = -li + 1;

                if (numOfEle % 2 == 0) {
                    r = mid - 1;
                } else {
                    l = mid + 2;
                }
            }
        }

        return -1;
    }
}