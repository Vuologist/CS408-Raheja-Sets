import java.lang.reflect.Array;
import java.util.Arrays;

public class SetADTEngine<T extends Comparable<T>> {

    private T[] set1;
    private T[] set2;
    private Class<T[]> clazz;

    public SetADTEngine(T[] set1, T[] set2, Class<T[]> clazz){
        this.set1 = set1;
        this.set2 = set2;
        this.clazz = clazz;
    }

    public T[] getUnion(){
        return union();
    }

    public T[] getIntersection(){
        return intersection();
    }

    public T[] getDifference(){
        return difference();
    }

    private T[] checkDuplicate(T[] set){
        boolean change = false;
        int newLength = set.length;
        int j = 0;

        Arrays.sort(set);

        //check for duplicate
        for(int i =0; i < set.length-1; i++){
            if(set[i].compareTo(set[i+1]) == 0) {
                set[i] = null;
                newLength--;
                change = true;
            }
        }

        if (change == false)
            return set;

        //System.out.println("duplicate set:");
        //print(set);

        T[] newSet = clazz.cast(Array.newInstance(clazz.getComponentType(),newLength));
        ;
        //reduce array
        for(int i = 0; i < set.length; i++){
            if(set[i] != null) {
                newSet[j] = set[i];
                j++;
            }
        }
        return newSet;
    }

    public void print(T[] set){
        System.out.println(Arrays.toString(set));
    }

    private T[] union(){
        int finalLength = set1.length + set2.length;
        T[] finalSet = clazz.cast(Array.newInstance(clazz.getComponentType(),finalLength));

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

    private T[] intersection(){
        int arrayLargest = 1;
        int arrayLengthCounter = 0;

        if(set1.length < set2.length)
            arrayLargest = 2;

        //determine finalSet length
        if(arrayLargest == 2)
            for(int i = 0; i < set2.length; i++){
                for(int j = 0; j < set1.length; j++){
                    if(set2[i].compareTo(set1[j]) == 0){
                        arrayLengthCounter++;
                    }
                }
            }
        else
            for(int i = 0; i < set1.length; i++){
                for(int j = 0; j < set2.length; j++){
                    if(set1[i].compareTo(set2[j]) == 0) {
                        arrayLengthCounter++;
                    }
                }
            }

        T[] finalSet = clazz.cast(Array.newInstance(clazz.getComponentType(),arrayLengthCounter));
        int w = 0;
        //create finalSet
        if(arrayLargest == 2)
            for(int i = 0; i < set2.length; i++){
                for(int j = 0; j < set1.length; j++){
                    if(set2[i].compareTo(set1[j]) == 0){
                        finalSet[w] = set2[i];
                        w++;
                    }
                }
            }
        else
            for(int i = 0; i < set1.length; i++){
                for(int j = 0; j < set2.length; j++){
                    if(set1[i].compareTo(set2[j]) == 0) {
                        finalSet[w] = set1[i];
                        w++;
                    }
                }
            }
        return finalSet;
    }

    private T[] difference() {
        int finalSetLength = set1.length;
        int w = 0;
        boolean nullSetter;

        //determine difference and length amount
        for(int i =0; i < set1.length; i++) {
            nullSetter = false;
            for (int j = 0; j < set2.length; j++) {
                if (set1[i].compareTo(set2[j]) == 0) {
                    nullSetter = true;
                    finalSetLength--;
                }
            }
            //prevent NullPointerException due to compareTo
            if (nullSetter == true)
                set1[i] = null;
        }

        T[] finalSet = clazz.cast(Array.newInstance(clazz.getComponentType(),finalSetLength));
        //create finalSet
        for(int i = 0; i < set1.length; i++){
            if(set1[i] != null) {
                finalSet[w] = set1[i];
                w++;
            }
        }
        return finalSet;
    }
}
