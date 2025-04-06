package ArrayProblems;

public class powerOfTwo {

    static int i = 1;

    public static Boolean powerOfTwo(int num){

        while (i < num){
            i = i * 2;
        }
        if(i == num){
            return true;
        }else {
            return false;
        }

    }



    public static void main(String[] args) {
        System.out.println(powerOfTwo(3));
    }

}
