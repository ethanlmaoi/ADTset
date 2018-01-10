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
 * This class is a LinkSet that implements the set interface.
 * A linked set has nodes that can "link" together to create a list (see Node).
 */
public class LinkSet<T> implements SetInterface<T>
{
    /**
    * The head (first) node that has a reference to the second node.
    */
    private Node<T> head;
    
    /**
    * The number of entries or nodes or elements inside of the link set.
    */
    private int numberOfEntries;
    
    /**
    * This default constructor will create a LinkSet with the head node set to null and
    * the starting number of entries to 0. (list is empty)
    */
    public LinkSet()
    {
        head = null;
        numberOfEntries = 0;
    }
    
    /**
    * @param copy 
    * This constructor requires a LinkSet<T> for an input.
    * This constructor is needed so a set can be created/referenced from a SetInterface set.
    */
    public LinkSet(LinkSet<T> copy)
    {
        Node<T> currentNode = copy.head;
        while (currentNode != null)
        {
            add(currentNode.getData());
            currentNode = currentNode.getNext();
        }
    }
    
    /**
    * @param entry
    * @return boolean
    * This method will check if the set contains a specified element.
    * Will return true if the element is in the set, false otherwise.
    */
    public boolean contains(T entry)
    {
        boolean doesHave = false;
        if (length() == 0)
        {
            return doesHave;
        }
        else
        {
            Node<T> currentNode = head;
            while (currentNode != null && !doesHave)
            {
                if ((currentNode.getData()).equals(entry))
                {
                    doesHave = true;
                }
                    currentNode = currentNode.getNext();               
            }
        }
        return doesHave;
    }
    
    /**
    * @param entry
    * @return boolean
    * This method will remove from the set a specified element.
    * Will return true if the element was removed successfully, false otherwise.
    */
    public boolean remove(T entry)
    {
        boolean removed = false;
        if (!contains(entry) || length() == 0)
        {
            return removed;
        }
        else if (length() == 1)
        {
            head.setData(null);
            numberOfEntries--;
            return true;
        }
        else
        {
            Node currentNode = head.getNext();
            Node prevNode = head;
            int i = 1;
            while (i < length() && !removed)
            {
                if ((currentNode.getData()).equals(entry))
                {
                    Node<T> nextNode = currentNode.getNext();
                    currentNode.setData(null);
                    prevNode.setNext(nextNode);
                    numberOfEntries--;
                    removed = true;
                }
                else
                {
                    currentNode = currentNode.getNext();
                    prevNode = prevNode.getNext();
                    i++;
                }
            }
        }
        return removed;
    }
    
    /**
    * This method will add a specified element to the set.
    * Will return true if the element was successfully added.
    */
    public boolean add(T entry)
    {
        boolean added = false;
            if (this.contains(entry))
        {
            return added;
        }
        else if (length() == 0)
        {
            head = new Node(entry);
            numberOfEntries++;
            added = true;
        }
        else
        {
            Node<T> newNode = new Node(entry);
            Node<T> nextNode = head.getNext();
            head.setNext(newNode);
            newNode.setNext(nextNode);
            numberOfEntries++;
            added = true;
        }
        return added;
    }
    
    /**
    * This method will return the number of entries inside of the set.
    */
    public int length()
    {
        return numberOfEntries;
    }
    
    /**
    * This method will return true if every element in this set is in the
    * specified set, false otherwise.
    */
    public boolean subset(SetInterface<T> entrySet)
    {
        LinkSet<T> set = new LinkSet<T>((LinkSet<T>) entrySet);
        boolean isSubset = true;
        if (this.equals(set) || this.length() == 0)
        {
            return isSubset;
        }
        else if (this.length() > set.length())
        {
            return false;
        }
        else
        {
            Node<T> currentNode = head;
            while (currentNode != null && isSubset)
            {
                if (!(set.contains(currentNode.getData())))
                {
                    isSubset = false;
                }
                    currentNode = currentNode.getNext();
            }
        }
        return isSubset;
    }
    
    /**
    * This method will check if this set is the exact same as the specified set.
    */
    public boolean equals(SetInterface<T> entrySet)
    {
        LinkSet<T> set = new LinkSet<T>((LinkSet<T>) entrySet);
        boolean isEquals = true;
        if (this.length() != set.length())
        {
            return false;
        }
        else
        {
            Node<T> currentNode = head;
            while (currentNode != null  && isEquals)
            {
                if (!set.contains(currentNode.getData()))
                {
                    isEquals = false;
                }
                    currentNode = currentNode.getNext();
            }
        }
        return isEquals;
    }
    
    /**
    * This method will return a set that contains all the elements in both the
    * current set and the specified set.
    */
    public SetInterface<T> union(SetInterface<T> entrySet)
    {
        LinkSet<T> set = new LinkSet<T>((LinkSet<T>) entrySet);
        LinkSet<T> newLinkSet = set;
        
        if (this.length() == 0)
        {
            return set;
        }
        if (set.length() == 0)
        {
            return this;
        }
        
        Node<T> currentNode = head;
        while (currentNode != null)
        {
            newLinkSet.add(currentNode.getData());
            currentNode = currentNode.getNext();
        }
        return newLinkSet;
    }
    
    /**
    * This method will return a set that contains elements only in both the current
    * set and the specified set.
    */
    public SetInterface<T> intersection(SetInterface<T> entrySet)
    {
        LinkSet<T> set = new LinkSet<T>((LinkSet<T>) entrySet);
        LinkSet<T> newLinkSet = new LinkSet<T>();
        Node<T> currentNode = null;
        if (this.length() <= set.length())
        {
            currentNode = head;
            while (currentNode != null)
            {
                if (set.contains(currentNode.getData()))
                {
                    newLinkSet.add(currentNode.getData());
                }
                    currentNode = currentNode.getNext();
            }
        }
        else
        {
            currentNode = set.head;
            while (currentNode != null)
            {
                if (this.contains(currentNode.getData()))
                {
                    newLinkSet.add(currentNode.getData());
                }
                    currentNode = currentNode.getNext();
            }
        }
        return newLinkSet;
    }
    
    /**
    * This method will return a set that contains elements that are in the current
    * set, but not in the specified set.
    */
    public SetInterface<T> complement(SetInterface<T> entrySet)
    {
        LinkSet<T> newLinkSet = new LinkSet<T>();
        LinkSet<T> set = new LinkSet<T>((LinkSet<T>) entrySet);
        
        if (this.length() == 0)
        {
            return this;
        }
        
        Node<T> currentNode = head;
        while (currentNode != null)
        {
            if (!set.contains(currentNode.getData()))
            {
                newLinkSet.add(currentNode.getData());
            }
            currentNode = currentNode.getNext();
        }
        return newLinkSet;
    }
    
    /**
    * This method will return a String that indicates the object's state.
    * Will have format: {1,2,3} or {} (no elements)
    */
    public String toString()
    {
        String result = "{";
        Node<T> currentNode = head;
        if (numberOfEntries == 0)
        {
            return "{}";
        }
        for (int i = 0; i < this.length(); i++)
        {
            if (i == this.length()-1)
            {
                result+=currentNode.getData();
            }
            else
            {
                result+=currentNode.getData()+", ";
            }
            currentNode = currentNode.getNext();
        }
        result+="}";
        return result;
    }
}