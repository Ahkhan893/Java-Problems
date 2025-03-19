package HasMapProblems;

import java.util.HashMap;

public class FrequencyOfNumberInArray {


    public static void main(String[] args) {
        HashMap<String,String> has = new HashMap<>();
        has.put("hasseb" , "value");


        int  arr[] = {1,3,2,5,1,3,1,5,1};
        int freq = 1/3;
        int frequecnyOfNumber = 0;
        HashMap<Integer , Integer> frequencyCheck = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i++){
            if(frequencyCheck.containsKey(arr[i])){
                frequencyCheck.put(arr[i] ,frequencyCheck.get(arr[i]) +1 );
            }else {
                frequencyCheck.put(arr[i] , 1);
            }
        }
        for (int key : frequencyCheck.keySet()){
            if(frequencyCheck.get(key) > arr.length/3){
                System.out.println("This has the higher frequency" + "" + key);
            }
        }

    }
}
