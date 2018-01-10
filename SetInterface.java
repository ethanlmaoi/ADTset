/**
 * Name: Liao, Ethan
 * Assignment: Project #2
 * Due: 5/04/2017
 * Course: cs-240-02
 * 
 * Description: This second project requires me to implement a Set ADT using a singly
 * linked list. Singly Linked List is filled with nodes and nodes have two fields:
 * the data and the link. Nodes are generic classes.
 */
package eliao.proj2;

/**
 * @author Ethan Liao
 * This is an interface for all sets, not specifically just for the LinkSet.
 * A set will have the following methods below (add, remove, etc.)
 */
public interface SetInterface<T>
{
    /**
    * This method will check if the set contains a specified element.
    * Will return true if the element is in the set, false otherwise.
    */
    boolean contains(T entry);
    
    /**
    * This method will remove from the set a specified element.
    * Will return true if the element was removed successfully, false otherwise.
    */
    boolean remove(T entry);
    
    /**
    * This method will add a specified element to the set.
    * Will return true if the element was successfully added.
    */
    boolean add(T entry);
    
    /**
    * This method will return the number of entries inside of the set.
    */
    int length();
    
    /**
    * This method will return true if every element in this set is in the
    * specified set, false otherwise.
    */
    boolean subset(SetInterface<T> set);
    
    /**
    * This method will check if this set is the exact same as the specified set.
    */
    boolean equals(SetInterface<T> set);
            
    /**
    * This method will return a set that contains all the elements in both the
    * current set and the specified set.
    */
    SetInterface<T> union(SetInterface<T> set);
    
    /**
    * This method will return a set that contains elements only in both the current
    * set and the specified set.
    */
    SetInterface<T> intersection(SetInterface<T> set);
    
    /**
    * This method will return a set that contains elements that are in the current
    * set, but not in the specified set.
    */
    SetInterface<T> complement(SetInterface<T> set);
    
    /**
    * This method will return a String that indicates the object's state.
    * Will have format: {1,2,3} or {} (no elements)
    */
    String toString();
}
