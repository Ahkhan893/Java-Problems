package ArrayProblems;

import java.lang.reflect.Array;
import java.util.Arrays;

public class containsDuplicate {

     public static Boolean checkDupliate(int [] nums){

         Arrays.sort(nums);

         for(int i = 0 ; i< nums.length -1 ; i++){

             if(nums[i] == nums[i + 1]){
                 return Boolean.TRUE;
             }

         }
         return Boolean.FALSE;

     }

    public static void main(String[] args) {
         int [] array = {1,2,3,4,5,6,7,8};
        System.out.println(checkDupliate(array));

    }
}
