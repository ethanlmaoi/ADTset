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
 * This class is the generic class for a Node class.
 * Nodes have two instance variables: the first is the data portion (T) and the other is
 * the next Node (Node<T>)
 */
public class Node<T>
{
    private T data;
    private Node<T> next;
        
    /**
    * This constructor will construct a Node object with a data inside, but no
    * reference to the next Node.
    */
    public Node(T dataPortion)
    {
        this(dataPortion,null);
    }
    
    /**
    * This constructor will construct a Node Object with both the data and the
    * reference to the nextNode.
    */
    public Node(T dataPortion, Node<T> nextNode)
    {
        data = dataPortion;
        next = nextNode;
    }
    
    /**
    * This method will return the data inside of the Node.
    */
    public T getData()
    {
        return data;
    }
    
    /**
    * This method will set the data (or replace the data) inside of the Node.
    */
    public void setData(T dataPortion)
    {
        data = dataPortion;
    }
    
    /**
    * This method will return a Node which is a reference to the next Node from the current one.
    */
    public Node<T> getNext()
    {
        return next;
    }
    
    /**
    * This method will set the next Node (or replace the next Node).
    */
    public void setNext(Node<T> nextNode)
    {
        next = nextNode;
    }
    
    /**
    * This will tell the console what to print out for a Node object.
    */
    public String toString()
    {
        return data + " " + next;
    }
}