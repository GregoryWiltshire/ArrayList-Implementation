/**
 * Created by Gregory Wiltshire on 9/29/16.
 * Bhola CSC2720 Data Structures Assignment #3
 * section: 88046
 */
public class testarray {
    public static void main (String [] args){

        System.out.println("testarray created by: Gregory Wiltshire");
        System.out.println("Bhola CSC2720 Data Structures Assignment #3");
        System.out.println("section: 88046");
        System.out.println();
        System.out.println();




        //default constructor
        System.out.println("testing default constructor, test");
        System.out.println("driver: ArrayList test2 = new ArrayList();");
        ArrayList test = new ArrayList();
        System.out.println();

        //int constructor
        System.out.println("testing constructor with parameter int, test2");
        System.out.println("driver: ArrayList test2 = new ArrayList(3);");
        ArrayList test2 = new ArrayList(3);
        System.out.println();


        //.add(object n)
        System.out.println("creating object Integer(5) obj");
        System.out.println("driver: Integer obj = new Integer(5);");
        Integer obj = new Integer(5);
        System.out.println("passing object obj to add method for test and test2");
        System.out.println("driver: test.add(obj);");
        test.add(obj);
        System.out.println("driver: test2.add(obj);");
        test2.add(obj);
        System.out.println();

        //.find(object n)
        System.out.println("driver: array.find(obj) for both arrays");
        System.out.println("test.find(obj): " + test.find(obj));
        System.out.println("test2.find(obj): " + test2.find(obj));
        System.out.println();

        //.get()
        System.out.println("testing both arrays get method for index 0");
        System.out.println("test.get(): " + test.get(0));
        System.out.println("test2.get(): "+ test2.get(0));
        System.out.println();

        //.isIn(object n)
        System.out.println("driver: array.isIn(obj) for both arrays");
        System.out.println("test.isIn(obj): " + test.isIn(obj));
        System.out.println("test2.isIn(obj): " + test2.isIn(obj));
        System.out.println();

        //.remove(object n)
        System.out.println("driver: test.remove(obj);");
        test.remove(obj);
        System.out.println("driver: test2.remove(obj);");
        test2.remove(obj);
        System.out.println();

        //.add(int index, object n)
        System.out.println("passing object obj and index 1, to add(int index, object x) method for test and test2");
        System.out.println("driver: test.add(obj);");
        test.add(1, obj);
        System.out.println("driver: test2.add(obj);");
        test2.add(1, obj);
        System.out.println();

        //.isEmpty()
        System.out.println("testing both arrays to see if empty, array.isEmpty");
        System.out.println("test.isEmpty(): " + test.isEmpty());
        System.out.println("test2.isEmpty(): "+ test2.isEmpty());
        System.out.println();


        //.size()
        System.out.println("testing both arrays size");
        System.out.println("test.size(): " + test.size());
        System.out.println("test2.size(): "+ test2.size());








    }



}
