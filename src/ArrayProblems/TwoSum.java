package ArrayProblems;

import java.util.HashMap;

public class TwoSum {

    public int[] TwoSum(int[] nums, Integer target){
    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0 ; i < nums.length ; i++){
        if(map.containsKey(nums[i])) {
            return new int[]{map.get(nums[i]), i};
        }else {
            map.put(target-nums[i] ,i);
        }
        }
        return nums;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7,8};



    }
}
