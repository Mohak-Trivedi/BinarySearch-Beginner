// Problem: https://leetcode.com/problems/search-in-rotated-sorted-array/description/

// Approach: TC: O(logN), SC: O(1)
// Modified Binary Search. If not found in mid index:
// if found at mid: return mid
// else if left subarray [l, mid] sorted: if target in left subarray [l, mid]: update search range r=mid-1; else update search range l=mid+1
// else if right subarray [mid, r] sorted: if target in right subarray [mid, r]: update search range l=mid+1; else update search range r=mid-1

// CAUTION:
// Don't exclude mid, when checking left/right subarray when not found in mid. If you do so, you will get IndexOutOfBoundsError for test cases in which target is missing.
// E.g.: nums[] = [4,5,6,7,0,1,2], target = 3

class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[l] <= nums[mid]) { // left sub-array is sorted
                if (target >= nums[l] && nums[mid] >= target) // target belongs in left subarray
                {
                    r = mid - 1;
                } else { // target belongs in right subarray
                    l = mid + 1;
                }
            } else if (nums[mid] <= nums[r]) { // right sub-array is sorted
                if (target >= nums[mid] && nums[r] >= target) { // target belongs in right subarray
                    l = mid + 1;
                } else { // target belongs in left subarray
                    r = mid - 1;
                }
            }
        }

        return -1;
    }
}