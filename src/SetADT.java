public class SetADT {
    public static void main(String args[]){
        System.out.println("Welcome to the SET machine.\n" +
                "This program is self-automated and will demonstrate sets using ADT.");

        Integer[] set1 = {1,2,3,4};
        Integer[] set2 = {2,3,4,5};

        Integer[] set3 = {2,5,7,10,14,26,29};
        Integer[] set4 = {5,8,9,13,14,27,30};

        Character[] set5 = {'a','b','c','d'};
        Character[] set6 = {'d','c','z','x'};

        Character[] set7 = {'u','t','r','w','a','u'};
        Character[] set8 = {'t','r','w','a','u'};

        Double[] set9 = {1.0,2.0,3.0,4.0};
        Double[] set10 = {1.1,2.0,3.5,4.9};

        Double[] set11 = {45.9,32.9,2.0,54.6};
        Double[] set12 = {78.2,32.9,123.0,54.6};

        SetADTEngine<Integer> finalset1 = new SetADTEngine<Integer>(set1, set2, Integer[].class);
        System.out.println("Operation on Integer");
        System.out.print("Union: ");
        finalset1.print(finalset1.getUnion());
        System.out.print("Intersection: ");
        finalset1.print(finalset1.getIntersection());
        System.out.print("Difference: ");
        finalset1.print(finalset1.getDifference());

        SetADTEngine<Integer> finalset2 = new SetADTEngine<Integer>(set3, set4, Integer[].class);
        System.out.println("\nOperation on Integer");
        System.out.print("Union: ");
        finalset2.print(finalset2.getUnion());
        System.out.print("Intersection: ");
        finalset2.print(finalset2.getIntersection());
        System.out.print("Difference: ");
        finalset2.print(finalset2.getDifference());

        SetADTEngine<Character> finalset3 = new SetADTEngine<Character>(set5, set6, Character[].class);
        System.out.println("\nOperation on Character");
        System.out.print("Union: ");
        finalset3.print(finalset3.getUnion());
        System.out.print("Intersection: ");
        finalset3.print(finalset3.getIntersection());
        System.out.print("Difference: ");
        finalset3.print(finalset3.getDifference());

        SetADTEngine<Character> finalset4 = new SetADTEngine<Character>(set7, set8, Character[].class);
        System.out.println("\nOperation on Character");
        System.out.print("Union: ");
        finalset4.print(finalset4.getUnion());
        System.out.print("Intersection: ");
        finalset4.print(finalset4.getIntersection());
        System.out.print("Difference: ");
        finalset4.print(finalset4.getDifference());

        SetADTEngine<Double> finalset5 = new SetADTEngine<Double>(set9, set10, Double[].class);
        System.out.println("\nOperation on Double");
        System.out.print("Union: ");
        finalset5.print(finalset5.getUnion());
        System.out.print("Intersection: ");
        finalset5.print(finalset5.getIntersection());
        System.out.print("Difference: ");
        finalset5.print(finalset5.getDifference());

        SetADTEngine<Double> finalset6 = new SetADTEngine<Double>(set11, set12, Double[].class);
        System.out.println("\nOperation on Double");
        System.out.print("Union: ");
        finalset6.print(finalset6.getUnion());
        System.out.print("Intersection: ");
        finalset6.print(finalset6.getIntersection());
        System.out.print("Difference: ");
        finalset6.print(finalset6.getDifference());
    }
}
