import java.util.Arrays;

/**
 *
 * Created by Gregory Wiltshire on 9/29/16.
 * Bhola CSC2720 Data Structures Assignment #3
 * section: 88046
 *
 * Purpose: this class is a implementation of the java data type ArrayList, which uses the data structure Array
 * in combination with several useful methods to implement a list interface for an automatically resizing Array
 * that contains type Object without use of the Java library.
 *
 * Explanation of Important methods:
 *
 * How add() works:
 * The array of objects is created from either the default constructor of size=10 or the second constructor which allows an array of size "int" to be created.
 * When an object is added to the array if there is a null space present the class will add the object added to the first null slot, if one is unavailable the array will be
 * resized to twice it's current size and then the object will be inserted at the first null slot.
 *
 * How remove() works:
 * When an object is removed it is found using the find() method, the returned index will be the first occurrence of the object inside the array.
 * The method for remove will then use the swapReferences() method to swap the references for each element in the array starting at the index of the element
 * to be removed and continually swapping it to the right on the array. Finally the method nulls the last element present in the array, which effectively removes the object from the array.
 *
 * How To: To use this class, create a new ArrayList object and use the list interface methods to manage the generated ArrayList.

 * Data Structures used:
 * Array
 *
 * Algorithms used:
 * Linear Search
 **
 */
public class ArrayList {

    //need a private array of objects
    private Object[] arrayOfObjects;
    //private int size = 10;
    private static final int DEFAULT_SIZE = 10;

    //default constructor: creates an array of size 10
    public ArrayList() {
        //calls the contructor for int n = default size
        this(DEFAULT_SIZE);
        System.out.println("Constructor ArrayList() called");

    }

    //second constructor that accepts the type int and creates an array of size n
    public ArrayList(int n) {
        //constructor will throw exception if list size is less than zero
        if (n < 0) {
            throw new IllegalArgumentException(n + " is not a valid capacity");
        }
        arrayOfObjects = new Object[n];
        System.out.println("Constructor ArrayList(int n)" + " created an array with size of: " + arrayOfObjects.length);

    }


    /*
    This is a method method which places an object at the end of the array,
    if the array is full it will double the capacity and then place the value at the first occurrence of a null.

    Precondition:   When called this method assumes the array "arrayOfObjects" is initialized and filled with
    references of objects.

    Post condition:  Will modify the array, inserting the object x at the first occurrence of a null, if a null
    is not present it will double the size of the array and then insert the Object x at the first null.

    Invariants:
    Will not change the previous values or indexes of the elements contained within the array.
    */
    public void add(Object x) {
        //up to here we have an array with a size of n but it is null
        //must check to see if the values of the array are null then if they are populate the first null space

        //if the array has no nulls, create a larger copy of the array and insert the object at the end
        if (findFirstNull() == -1) {
            //increment var for size of array


            //doubles the size of array to fit new object
            arrayOfObjects = Arrays.copyOf(arrayOfObjects, (arrayOfObjects.length*2));

            //insert object at end of array (-1 since the array starts with 0)
            arrayOfObjects[findFirstNull()] = x;

        }

        //populate the index with the first null
        else {
            arrayOfObjects[findFirstNull()] = x;
        }
        System.out.println("added object to array ");
        System.out.println("arraysize: " + arrayOfObjects.length);


    }

    /*
    This is a method method which places an object at a specific index of the array.

    Precondition:   When called this method assumes the array "arrayOfObjects" is initialized and filled with
    references of objects and that the given index is valid.

    Post condition:  Will modify the array, inserting the object x at the given index if it is valid.

    Invariants:
    Will not change the elements other than the ones located at the given index, will not change the size of the array.
    */
    public void add(int index, Object x){
        try{
            arrayOfObjects[index] = x;
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("not a valid index! " + e);
            //doesn't need a return because it is void

        }

        System.out.println("added object at index: " + index);

    }


    /*
    This is a method method that returns the object reference at the given index.

    Precondition:   When called this method assumes the array "arrayOfObjects" is initialized and filled with
    references of objects and that the given index is valid.

    Post condition:  Will return the Object at the index or a dummy object and a message stating the index is null.

    Invariants:
    Will not affect the size of the array or the contents contained within.
    */
    public Object get(int index){
        Object x;
        //must include try/catch block to catch IndexOutOfBoundsException
        try{
            if (arrayOfObjects[index] != null) {


                x = arrayOfObjects[index];


                System.out.println("got object at: " + index);
                return x;


            }
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("not a valid index! " + e);
            Object blah = new Object();
            return blah;

        }

            //return of type Object must be present, therefore this is a dummy Object
            x = new Object();
            System.out.println("returned null at index: " + index);
            return x;


    }

    /*
   This is a method which removes the first occurrence of an Object x.

   Precondition:   When called this method assumes the array "arrayOfObjects" is initialized and filled with
   references of objects.

   Post condition:  Will remove the first occurrence of a given object and shift all remaining values of the array left.

   Invariants:  Will not affect the size of the array.
   */
    public void remove(Object x){
        //set var removeIndex to the index to skip
        int removeIndex = find(x);
        int numberOfElements = this.size();
        int indexPointer = 0;

        System.out.println("test " + removeIndex);

        System.out.println("initial size of the array is " + this.size());


        if(removeIndex == -1) {
            System.out.println("There are no elements in the array to remove.");
        }

        //if the find does not return -1 for does not exist
        if(removeIndex >= 0){

            //for loop iterates from found index to the end of the array
            for(int i = removeIndex; i < numberOfElements-1; i++){
                //should swap the references for each object in the array with the removeIndex
                // Object until the object to be removed is at the end of the array
                swapReferences(i,i+1);
            }
            //nulls the last value of the array, the value previous to the first null
            arrayOfObjects[(findFirstNull()-1)] = null;
            System.out.println("arraysize: " + arrayOfObjects.length);



        }

        System.out.println("remove() method has been run.");
        System.out.println("final size of the array is " + this.size());


    }

    /*
    This is a method method that returns boolean true at the first occurrence of an object n.

    Precondition:   When called this method assumes the array "arrayOfObjects" is initialized and filled with
    references of objects.

    Post condition:  Will return boolean that answers if the Object n is contained inside the array, will return true at the first occurrence.

    Invariants:
    Will not affect the size of the array or the contents contained within.
    */
    public boolean isIn(Object n) {

        //checks to make sure array is not empty before comparing objects
        if(!isEmpty()){

            for (int iterator = 0; iterator < arrayOfObjects.length; iterator++) {


                //System.out.println(arrayOfObjects[iterator].toString());
                //check to see if the element has been found
                if (arrayOfObjects[iterator].equals(n)) {
                    return true;
                }
            }

        }
        return false;

    }


    /*
    This is a method method that returns the location of the first occurrence of the object n
    inside the arrayOfObjects.

    Precondition:   When called this method assumes the array "arrayOfObjects" is initialized and filled with
    references of objects.

    Post condition:  Will return int of the index containing the first occurrence of the Object n.

    Invariants:
    Will not affect the size of the array or the contents contained within.
    */
    public int find(Object n) {
        //iterate through the original array, looking for the first equal object, when found the matchFound boolean is tripped
        //method assumes the object exists in the array and if it is not found it will return a value of -1

        //if the array is not empty then iterate and find the object
        if(!isEmpty()) {
            for (int iterator = 0; iterator < arrayOfObjects.length; iterator++) {

                //check to see if the element has been found
                if (arrayOfObjects[iterator].equals(n)) {
                    return iterator;
                }
            }

        }
        //returns values of -1 for object not found
        return -1;

    }


    /*
   This is a method method that returns the position of the first null contained in the array,
   returns -1 if there are no null values in the arrayOfObjects

   Precondition:   When called this method assumes the array "arrayOfObjects" is initialized and filled with
   references of objects.

   Post condition:  Will return int of the index containing the first null.

   Invariants:
   Will not affect the size of the array or the contents contained within.
   */
    public int findFirstNull() {
        for (int i = 0; i < arrayOfObjects.length; i++) {
            if (arrayOfObjects[i] == null) {
                return i;
            }
        }

        return -1;

    }

    /*
   This is a method to returns the current size of the arrayOfObjects,note that
   this does not return the length of array but the actual number of elements present.

   Precondition: The arrayOfObjects must be initialized before calling the isEmpty() method.

   Post condition:  Will return Boolean that will state if the array contains an element.

   Invariants:
   Will not affect the size of the array or the contents contained within.
   */
    //returns boolean true at the first occurrence of an object n
    public boolean isEmpty() {
        //iterate through the original array, looking for the first equal object, when found the matchFound boolean is tripped
        if (arrayOfObjects.length == 0) {
            return true;
        }

        for (int i = 0; i < arrayOfObjects.length; i++) {
            if (arrayOfObjects[i] != null) {
                return false;
            }
        }

        return true;

    }

    /*
    This is a method to returns the current size of the arrayOfObjects, note that
    this does not return the length of array but the actual number of elements present.

    Precondition:   When called this method assumes the array "arrayOfObjects" is initialized and filled with
    references of objects.

    Post condition:  Will return int count which is the number of elements present in the arrayOfObjects.

    Invariants:
    Will not affect the size of the array or the contents contained within.
    */
    public int size() {
        int count = 0;

        for (int i = 0; i < arrayOfObjects.length; i++){
            if (arrayOfObjects[i] != null){
                count++;
            }
        }

        return count;


    }

    /*
    This is a method to method to swap references inside the array, storing indexA as a temporary object.
    The second index is shifted left and then the indexA object in place in the spot where indexB Object once was.

    Precondition:   When called this method is provided two indices to swap, it assumes the array is filled with
    references of objects and that both indexes are valid.

    Post condition:  Will modify the arrayOfObjects swapping the references for elements at indexA and indexB.

    Invariants:
    Will not affect the size of the array or the contents contained within, only shifts references around.
    */

    public void swapReferences(int indexA, int indexB){
        try{
            Object x = arrayOfObjects[indexA];
            arrayOfObjects[indexA] = arrayOfObjects[indexB];
            arrayOfObjects[indexB] = x;

        }
        catch(IndexOutOfBoundsException e){
            System.out.println("not a valid index! " + e);
            //return not required because method is void
        }
    }
}




