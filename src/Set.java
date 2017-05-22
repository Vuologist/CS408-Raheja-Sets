import java.util.Arrays;
import java.util.Scanner;


public class Set {
    public static void main(String args[]){
        Scanner kb = new Scanner(System.in);
        String userInput;
        boolean repeat = true;

        System.out.println("Welcome to the SET machine.");


        do{
            System.out.println("Enter an integer set (Seperate numbers by commas):");
            userInput = kb.nextLine();

            String[] set = createArray(userInput);

            set = checkDuplicate(set);




        }while(repeat == true);





    }

    private static String[] createArray(String userInput){
        int count = 0;
        String[] input = userInput.split(",");
        return input;
    }

    private static int[] checkDuplicate(String[] set){
        Arrays.sort(set);
        //check for
        for(int i =0; i < set.length; i++){
            if(set[i].equals(set[i+1]))
                set[i] = "-1";
        }

        return sort;
    }

    private static int[] union(){

    }

    private static int[] intersection(){

    }

    private static int[] difference() {

    }

}


