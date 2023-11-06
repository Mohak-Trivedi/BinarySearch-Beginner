// Problem:
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

// Brute Force Approach: TC: O(N), SC: O(1)
// Traverse from left and find first occurrence. Using while traverse till last occurence.

// Optimized Approach: TC: O(2logN), SC: O(1)
// Use Binary Search. Customize for 1st occurence by continuing search in left of mid. Customize for last occurence by continuing the search in right.

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[] { -1, -1 };

        ans[0] = getFirstOcc(nums, target);
        ans[1] = getLastOcc(nums, target);

        return ans;
    }

    public int getFirstOcc(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int ans = -1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (nums[mid] == target) {
                ans = mid;

                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }

    public int getLastOcc(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int ans = -1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (nums[mid] == target) {
                ans = mid;

                l = mid + 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }
}