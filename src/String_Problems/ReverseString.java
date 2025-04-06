package String_Problems;

public class ReverseString {

    public static char[] reverserStringArray( char [] arrayString ){

        int start = 0;
        int end = arrayString.length -1; // index 0 calculate

        while (start <= end){
            char temp = arrayString[start];
            arrayString[start] = arrayString[end];
            arrayString[end] = temp;

            start++;
            end--;

        }
        return arrayString;
    }




    public static void main(String[] args) {

        System.out.println(reverserStringArray("Hello".toCharArray()));


    }
}
