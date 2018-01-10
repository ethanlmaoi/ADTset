/**
 * Name: Liao, Ethan
 * Assignment: Project #2
 * Due: 5/04/2017
 * Course: cs-240-02
 * 
 * Description: This second project requires me to implement a Set ADT using a singly
 * linked list. Singly Linked List is filled with nodes and nodes have two fields:
 * the data and the link. Node will be a generic class.
 */
package eliao.proj2;

/**
 * @author Ethan Liao
 * This class is the main class with the main method. The main method will first create
 * two sets and test the add(), length(), remove(), equals(), and contains() methods.
 * Then, then program will create additional sets to test the subset(), union(),
 * intersection(), and complement() methods. 
 * For these methods, five cases will need to be tested and met successfully:
 * 
 * Case 1: A and B are equal but distinct sets
 * Case 2: A and B are such that they have different sizes but one is a subset of the other
 * Case 3: A and B are non-empty and different in size but have common elements
 * Case 4: they are non-empty with nothing in common
 * Case 5: one is non-empty and the other empty
 */
public class SetTest
{
    /**
    * The main method of this class and will start and run the program to 
    * test the methods inside of LinkSet (specified above).
    */
    public static void main(String args[])
    {
        System.out.println("E. Liao's Set ADT");
        
        // creation of setA and setB
        SetInterface<Integer> setA = new LinkSet<>();
        SetInterface<Integer> setB = new LinkSet<>();
        
        // tests for add() and length() methods 
        System.out.println("\nTests for add() and length()");
        setA.add(3);
        setA.add(2);
        setA.add(2);
        setA.add(1);
        setA.add(4);
        System.out.println("Set A: " + setA + " (Added 3, 2, 2, 1, and 4)");
        System.out.println("There are " + setA.length() + " entries in Set A.");
        
        setB.add(1);
        setB.add(3);
        setB.add(5);
        System.out.println("Set B: " + setB + " (Added 1, 3, and 5)");
        System.out.println("There are " + setB.length() + " entries in Set B.\n");
        
        // test for remove() method
        System.out.println("Tests for remove()");
        setA.remove(4);
        setA.remove(2);
        System.out.println("Set A: " + setA + " (Removed 2 and 4)");
        
        setB.remove(5);
        System.out.println("Set B: " + setB + " (Removed 5)");
        
        // test for equals() method
        System.out.println("\nTest for equals()");
        System.out.println("Does setA equals setB? " + "Set A: " + setA + " Set B: " + setB);
        if (setA.equals(setB))
        {
            System.out.println("Yes, setA equals setB! (Order does not matter)");
        }
        else
        {
            System.out.println("No, setA does not equal to setB!");
        }
        
        // test for contains() method
        System.out.println("\nTest for contains()");
        System.out.println("Does setA have the element 1? Set A: " + setA);
        if (setA.contains(1))
        {
            System.out.println("Yes, setA has the element 1!\n");
        }
        else
        {
            System.out.println("No, setA does not have the element!\n");
        }
        
        // creating setC, setD, setE, setF, setG, setH (and changing set A)
        setA.remove(1);
        setA.remove(3);
        SetInterface<Integer> setC = new LinkSet<>();
        setC.add(5);
        setC.add(6);
        setC.add(7);
        SetInterface<Integer> setD = new LinkSet<>();
        setD.add(6);
        setD.add(7);
        setD.add(8);
        setD.add(9);
        SetInterface<Integer> setE = new LinkSet<>();
        setE.add(1);
        setE.add(3);
        setE.add(2);
        SetInterface<Integer> setF = new LinkSet<>();
        setF.add(2);
        setF.add(3);
        setF.add(1);
        SetInterface<Integer> setG = new LinkSet<>();
        setG.add(2);
        SetInterface<Integer> setH = new LinkSet<>();
        setH.add(1);
        setH.add(2);
        
        System.out.println("Set A: " + setA + "     Set C: " + setC + "     Set E: " + setE + "  Set G: " + setG);
        System.out.println("Set B: " + setB + " Set D: " + setD + "  Set F: " + setF + "  Set H: " + setH);
        
        // test for subset() method
        System.out.println("\nTest for subset()");
        System.out.println("Case 1: E Subset F - " + setE.subset(setF));
        System.out.println("Case 2: G Subset H - " + setG.subset(setH));
        System.out.println("Case 3: C Subset D - " + setC.subset(setD));
        System.out.println("Case 4: B Subset G - " + setB.subset(setG));
        System.out.println("Case 5: A Subset D - " + setA.subset(setD));
        
        // test for union() method
        System.out.println("\nTest for union()");
        System.out.println("Case 1: E Union F - " + setE.union(setF));
        System.out.println("Case 2: G Union H - " + setG.union(setH));
        System.out.println("Case 3: C Union D - " + setC.union(setD));
        System.out.println("Case 4: B Union G - " + setB.union(setG));
        System.out.println("Case 5: A Union D - " + setA.union(setD));
        
        // test for intersection() method
        System.out.println("\nTest for intersection()");
        System.out.println("Case 1: E Intersection F - " + setE.intersection(setF));
        System.out.println("Case 2: G Intersection H - " + setG.intersection(setH));
        System.out.println("Case 3: C Intersection D - " + setC.intersection(setD));
        System.out.println("Case 4: B Intersection G - " + setB.intersection(setG));
        System.out.println("Case 5: A Intersection D - " + setA.intersection(setD));
        
        // test for complement() method
        System.out.println("\nTest for complement()");
        System.out.println("Case 1: E Complement F - " + setE.complement(setF));
        System.out.println("Case 2: G Complement H - " + setG.complement(setH));
        System.out.println("Case 3: C Complement D - " + setC.complement(setD));
        System.out.println("Case 4: B Complement G - " + setB.complement(setG));
        System.out.println("Case 5: A Complement D - " + setA.complement(setD));
    }
}