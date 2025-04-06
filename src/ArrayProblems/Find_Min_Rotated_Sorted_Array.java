package ArrayProblems;

public class Find_Min_Rotated_Sorted_Array {

    public static int findMin(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low +( high - low) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums[high];
    }


    public static void main(String[] args) {

        int [] SortedArray = {1,2,3,4,7,6,5};
        System.out.println(findMin(SortedArray));

    }

}