package leetcode.random.problms;

/**
 * Design HashMap
 * 
 * Design a HashMap without using any built-in hash table libraries.
 * 
 * To be specific, your design should include these functions:
 * 
 * put(key, value) : Insert a (key, value) pair into the HashMap. If the value
 * already exists in the HashMap, update the value. 
 * get(key): Returns the value to which the specified key is mapped, or -1 
 * if this map contains no mapping for the key. 
 * remove(key) : Remove the mapping for the value key if this map contains the 
 * mapping for the key.
 * 
 * Example:
 * 
 * MyHashMap hashMap = new MyHashMap(); 
 * hashMap.put(1, 1); 
 * hashMap.put(2, 2);
 * hashMap.get(1); // returns 1 
 * hashMap.get(3); // returns -1 (not found)
 * hashMap.put(2, 1); // update the existing value 
 * hashMap.get(2); // returns 1
 * hashMap.remove(2); // remove the mapping for 2 
 * hashMap.get(2); // returns -1 (not found)
 * 
 * Note:
 * 
 * 1. All keys and values will be in the range of [0, 1000000]. 
 * 2. The number of operations will be in the range of [1, 10000]. 
 * 3. Please do not use the built-in HashMap library.
 * 
 * @author Vivek
 *
 */
public class MyHashMap
{
	int DEFAULT_SIZE = 16;
	private Node [] data = new Node[DEFAULT_SIZE];
	 /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
    	
    	int index = key % DEFAULT_SIZE;
    	Node node = data[index];
    	
    	Node newnode = new Node(key, value);
    	if(node == null)
    	{
    		data[index] = newnode;
    	}
    	else
    	{
    		Node localNode = searchNodeWithkey(node,key);
    		if(localNode == null)
    		{
    			newnode.nextNode = node;
    			data[index] = newnode;
    		}
    		else
    		{
    			localNode.data = value;
    		}
    	}
    	
    }
    

    private Node searchNodeWithkey(Node node, int key)
	{
		Node localNode = node;
		while(localNode != null)
		{
			if(localNode.key == key)
			{
				return localNode;
			}
			localNode = localNode.nextNode;
		}
		return null;
	}

	/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
    	
    	int index = key % DEFAULT_SIZE;
    	Node node = data[index];
    	
    	Node searchNodeWithkey = searchNodeWithkey(node, key);
    	
    	if(searchNodeWithkey == null)
    	{
    		return -1;
    	}
    	else
    	{
    		return searchNodeWithkey.data;
    	}
    	
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) 
    {
    	int index = key % DEFAULT_SIZE;
    	Node node = data[index];
    	
    	Node searchNodeWithkey = searchNodeWithkey(node, key);
    	
    	if(searchNodeWithkey != null)
    	{
    		removeData(node, key, index);
    	}
    	
        
    }
    
    private void removeData(Node node, int key, int index)
	{
    	Node localNode = node;
    	Node prev = null;
		while(localNode != null)
		{
			if(localNode.key == key)
			{
				if(prev != null)
				{
					prev.nextNode = localNode.nextNode;
				}
				else
				{
					data[index] = localNode.nextNode;
					
				}
				return;
			}
			prev = localNode;
			localNode = localNode.nextNode;
		}
	}

	private class Node
    {
    	private int data;
    	private int key; 
    	private Node nextNode;
    	
    	public Node(int key, int data)
    	{
    		this.key = key;
    		this.data = data;
    	}
    	
    }
	
//	public static void main(String[] args)
//	{
//		MyHashMap hashMap = new MyHashMap();
//		hashMap.put(1, 1);          
//		hashMap.put(2, 2);         
//		System.out.println(hashMap.get(1));            // returns 1
//		System.out.println(hashMap.get(3));            // returns -1 (not found)
//		hashMap.put(2, 1);          // update the existing value
//		System.out.println(hashMap.get(2));            // returns 1 
//		hashMap.remove(2);          // remove the mapping for 2
//		System.out.println(hashMap.get(2));            // returns -1 (not found) 
//	}
}
