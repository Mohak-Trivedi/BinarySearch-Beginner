/*
 * Problem:
 * Given a sorted array of size “N”; find the index of the number in the array
 * which is just greater than x and as close as possible to x.
 * Upper Bound (x) = Returns index of the number which is just greater than x
 * and as close as possible to x.
 */

public class UpperBound {
    public static int getUpperBound(int[] arr, int target) {
        int l = 0, r = arr.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] <= target) {
                l = mid + 1; // this might be '<=' or 'just <= target', so the 'just > target'(what we want)
                             // is just +1 ahead, so l=mid+1
            } else {
                r = mid; // arr[mid] > target. This might be '> target' or 'just > target'(what we want),
                         // so we need to include it, so r = mid, not r = mid - 1.
            }
        }

        return l; // as we are storing 'just > target' in l in line 17, return l
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 6, 6, 7, 7, 9 };
        int target = 6;
        int upperBoundIndex = getUpperBound(arr, target);

        if (upperBoundIndex < arr.length) {
            System.out.println("Upper bound of " + target + " is at index " + upperBoundIndex);
        } else {
            System.out.println("Upper bound of " + target + " is not found in the array. n = " + arr.length);
        }
    }
}
