///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (CS 367 Programming Assignment 2)
// Files:            (MovieQueueMain.java;ListNode.java;LinkedListADT.java;LinkedList.java;InvalidListPositionException.java)
// Semester:         CS367 Spring 2013
//
// Author:           (name:Song Zhao email:szhao34@wisc.edu)
// CS Login:         (szhao)
// Lecturer's Name:  (Jim Skrentny)
// Lab Section:      (Lecture 2)
//* no partener 

public class LinkedList<E> implements ListADT<E> {
	private int numItems;
	private ListNode<E> curr;
	private ListNode<E> head;
	
	
	//constructor
	public LinkedList()
	{
		head = null;
		numItems = 0;
		curr = null;
	}


	/**
	 * Adds the given item to the very end of the list.
	 * 
	 * @param item the item to add
	 */
		public void add(E item)
		{
			ListNode<E> tmp=new ListNode<E>(item);  //make a new node
			curr = head;                            //make curr the first node if there is any                                     
			if(isEmpty())                           //is the list is empty, set the new node as   
			{                                       //the first node.       
				curr = tmp;
				head = tmp;
				curr.setNext(null);
				numItems ++;                     //increament list size 
			}
			else
			{
				while(curr.getNext()!=null)      
				{
					curr = curr.getNext();    //find the last node
				}
				curr.setNext(tmp);                 //add new node to the last node.
				tmp.setNext(null);
				numItems++;                       //increament the list size  
			}		
		}

	/**
	 * Adds the given item to a given position of the list.
	 * @param pos: the position the item will be added.
	 * @param item the item to add
	 */
	public void add(int pos, E item) throws InvalidListPositionException 
	{
		ListNode<E> tmp = new ListNode<E>(item);
		if (pos < 0 || pos > numItems - 1)				//check if the pos is a valid number
		{                                                       //I wrote this method based on how main       
			throw new InvalidListPositionException();       //method works so the valid number will
		}							//be 1 to size rather than 0 to size-1.
		else if (pos == numItems - 1)                               //condition when add at the end of the						//list
		{							//list					
			add(item);
			return;
		}
		else if(pos == 0)					//condition when add at the begining of 
		{							//the list
			tmp.setNext(head);
			head = tmp;
			numItems ++;
			return;
		}
		else 
		{
			curr = head;
			for (int i = 0; i < pos- 1; i++)		//find the right node located at pos-1 and 	
			{						//add the new node after it
				curr = curr.getNext();	
			}
			tmp.setNext(curr.getNext());                    //connect node
			curr.setNext(tmp);
			numItems ++;  					//increament the list size 	
		}
	}


	/**
	 * remove the given item at a given position of the list.
	 * @param pos: the position the item will be removed.
	 * @param item the item to remove
	 */
	public E remove(int pos) throws InvalidListPositionException 
	{
		if (pos < 1 || pos > numItems) 
		{   							//if the pos is out of bound, throw exception
			throw new InvalidListPositionException();
		}
		if (pos==1)
		{                       				//if the item want to be removed is in the front of list
	    		E d=head.getData();             	        //get the string of the removed data
	    		head=head.getNext();            	        //move to the second position                         
	    		numItems--;                     	        //redue the count by one
	    		return d;                      		        //return the removed data
	        }
		else
		{                                       	// find the node n after which to add a new node and add the new node
	    		curr=head;
	    		for (int i = 0; i < pos - 2; i++) 
	    		{      						//find the specific item 
	    			curr = curr.getNext();        
	    		}
	    		E d=curr.getNext().getData();  
	    		curr.setNext(curr.getNext().getNext());		//get the strings in that item
	    		numItems--;                       		//reduce the count by 1
	    		return d;                        		//return the removed string 
	    		}    
		}


	/**
	 * return the data refered by the specific node
	 * @param pos: the position of the node
	 */
	 
	public E get(int pos) throws InvalidListPositionException 
	{
		if (pos < 0 || pos > numItems)				//if the pos is out of bound, throw exception
		{
			throw new InvalidListPositionException();
		}
		if (pos == 1)						//if want the data of the first node
		{
			return head.getData();				//return the data.
		}
		curr = head;
		for (int i = 0; i < pos - 1; i++)			//else find the right node
		{
			curr = curr.getNext();
		}
		return curr.getData();					//return the data.	
	}


	/**
	 * check if the list is an empty list
	 */
	public boolean isEmpty() 
	{
		if(numItems == 0)                             		//return ture if the listsize is 0
		{
			return true;
		}
		return false;						//return false if it's not.							
	}


	/**
	 * return the size of the list
	 */
	public int size() 
	{
		return numItems;					//return the size
	}
	
	/**
	 * return a string contains all the data in a specific format
	 * I didn't use parameter since we don't need to input anything
	 * when we test it
	 */
	public String print(){
		boolean lineNumbers = true;				//the boolean value is always true for test main file
		String r = "";						//declare two new strings
		String n = "";
		curr = head;						//let curr node points at beginning
		if(lineNumbers)
		{
			for (int i = 0; i < numItems; i++)
			{
				n = (String) curr.getData();		//let n has the current node's data each time	
				r += ((i+1) + " " + n +'\n');		//and put n at the end of the r each time
				curr = curr.getNext();			//loops through all the nodes in the list
			}	
		}
		else 
		{
			for (int i = 0; i < numItems; i++)
			{
				E d = curr.getData();	
				r += ((i+1) + " " + d);
				curr = curr.getNext();
			}
		}
		return r;						//return the string contains all the data.
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	




