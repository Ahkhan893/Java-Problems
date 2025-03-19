package ArrayProblems;

public class TrailingZero {

    public static void checktrailingzero( Integer number){
       Integer count = 0;
            while (number >0){
                number/=5;
                count++;
                System.out.println("This is the first Itereation" +" "+ count);
            }
    }

    public static void main(String[] args) {

        checktrailingzero(125);


    }
}
