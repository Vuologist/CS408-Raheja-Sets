import java.util.Arrays;
import java.util.Scanner;

public class Set {
    public static void main(String args[]){
        Scanner kb = new Scanner(System.in);
        String userInput;
        String userInput2;
        int operation;
        String[] set1;
        String[] set2;
        String[] finalSet;
        boolean repeat = true;

        System.out.println("Welcome to the SET machine.\nEnter a set separated by commas with no space inbetween.");
        System.out.print("Enter a set: ");
        userInput = kb.nextLine();
        System.out.print("Enter a 2nd set: ");
        userInput2 = kb.nextLine();

        //create set1
        set1 = createArray(userInput);
        //print(set1);
        set1 = checkDuplicate(set1);
        //System.out.println("new set: ");
        //print(set1);

        //create set2
        set2 = createArray(userInput2);
        //print(set2);
        set2 = checkDuplicate(set2);
        //System.out.println("new set: ");
        //print(set2);

        do{
           System.out.println("What would you like to do with your set? Union(1), Intersection(2), Difference(3), Exit(4)");
           System.out.print("Enter now: ");
           operation = kb.nextInt();

           switch(operation) {
               case 1:
                   finalSet = union(set1, set2);
                   System.out.print("Union: ");
                   print(finalSet);
                   break;
               case 2:
                   finalSet = intersection(set1, set2);
                   System.out.print("Intersection: ");
                   print(finalSet);
                   break;
               case 3: finalSet = difference(set1, set2);
                   System.out.print("Difference: ");
                   print(finalSet);
                   break;
               case 4:
                   System.out.print("End Program");
                   repeat = false;
                   break;
               default:
                   System.out.print("Incorrect selection. End Program");
                   repeat = false;
                   break;
           }
        }while(repeat == true);

    }

    private static String[] createArray(String userInput){
        String[] input = userInput.split(",");
        return input;
    }

    private static String[] checkDuplicate(String[] set){
        boolean change = false;
        int newLength = set.length;
        int j = 0;

        Arrays.sort(set);

        //check for duplicate
        for(int i =0; i < set.length-1; i++){
            if(set[i].equals(set[i+1])) {
                set[i] = "-1";
                newLength--;
                change = true;
            }
        }

        if (change == false)
            return set;

        //System.out.println("duplicate set:");
        //print(set);

        String[] newSet = new String[newLength];
        //reduce array
        for(int i = 0; i < set.length; i++){
            if(!set[i].equals("-1")) {
                newSet[j] = set[i];
                j++;
            }
        }
        return newSet;
    }

    private static void print(String[] set){
        System.out.println(Arrays.toString(set));
    }

     private static String[] union(String[] set1, String[] set2){
        int finalLength = set1.length + set2.length;
        String[] finalSet = new String[finalLength];

        //fill array for set1; might optimize later
        for(int i = 0; i < set1.length; i++){
            finalSet[i] = set1[i];
        }
        //fill array for set2
         for(int i = 0; i < set2.length; i++){
             finalSet[set1.length + i] = set2[i];
         }

        finalSet = checkDuplicate(finalSet);

        return finalSet;
     }

     private static String[] intersection(String[] set1, String[] set2){
         int arrayLargest = 1;
         int arrayLengthCounter = 0;
         String container = "";

         if(set1.length < set2.length)
             arrayLargest = 2;

         //determine finalSet length
         if(arrayLargest == 2)
            for(int i = 0; i < set2.length; i++){
                for(int j = 0; j < set1.length; j++){
                    if(set2[i].equals(set1[j])){
                        arrayLengthCounter++;
                        container += set2[i];
                    }
                }
            }
         else
             for(int i = 0; i < set1.length; i++){
                 for(int j = 0; j < set2.length; j++){
                     if(set1[i].equals(set2[j])) {
                         arrayLengthCounter++;
                         container += set1[i];
                     }
                 }
             }

         //create finalSet
         String[] finalSet = new String[arrayLengthCounter];
         for(int i = 0; i < finalSet.length; i++) {
            char temp = container.charAt(i);
            finalSet[i] = Character.toString(temp);
        }
         return finalSet;
     }

     private static String[] difference(String[] set1, String[] set2) {
         int finalSetLength = set1.length;
         int w = 0;

         //determine difference and length amount
         for(int i =0; i < set1.length; i++)
            for(int j = 0; j < set2.length; j++){
                if(set1[i].equals(set2[j])) {
                    set1[i] = "-1";
                    finalSetLength--;
                }
            }

         String[] finalSet = new String[finalSetLength];

         //create finalSet
         for(int i = 0; i < set1.length; i++){
             if(!set1[i].equals("-1")) {
                 finalSet[w] = set1[i];
                 w++;
             }
         }
        return finalSet;
     }
}
