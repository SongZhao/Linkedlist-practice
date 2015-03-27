///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (CS 367 Programming Assignment 2)
// Files:            (MovieQueueMain.java;ListNode.java;LinkedListIterator.java;LinkedListADT.java;LinkedList.java;InvalidListPositionException.java)
// Semester:         CS367 Spring 2013
//
// Author:           (name:Song Zhao email:szhao34@wisc.edu)
// CS Login:         (szhao)
// Lecturer's Name:  (Jim Skrentny)
// Lab Section:      (Lecture 2)
//* no partener 

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;



public class MovieQueueMain {
	
	/* You may create additional private static 
	   variables or methods as needed */

	public static void main(String args[]) throws FileNotFoundException, InvalidListPositionException, NullPointerException {
		
		LinkedList<String> movieQueue = new LinkedList<String>();		
		LinkedList<String> tmpmovieQueue = new LinkedList<String>();      //this list will hold the data when we use a gerne to read a file
		
		Scanner stdin = new Scanner(System.in);  // for reading console input
        boolean done = false;
        while (!done) {
            System.out.print("Enter option - a, c, l, m, p, r, s, w or x: ");
            String input = stdin.nextLine();

            if (input.length() > 0) {
                char choice = input.charAt(0);  // strip off option character
                String remainder = "";  // used to hold the remainder of input
                // trim off any leading or trailing spaces
                remainder = input.substring(1).trim();
                
                switch (choice) {
                /*
		* Add a movie to the movie queue from a database of movies of the given genre.
		* After the movie titles have been printed in order, print "Please enter a number between 1 and N", 
		* where N is the number of movies in the genre. Read the number entered by the user. If it is an 
		* invalid number (not an integer, or an integer less than 1 or greater than N), repeat the prompt 
		* until a valid number is received. The movie corresponding to this number should then be added to 
		* the end of the movie queue. Once added, print: "Added title to queue." where title is the title 
		* of the movie added to the queue. 
		*/
                case 'a' :
                	if (remainder.length() == 0)						
                	{
                		System.out.println("need the name of the file");
                		break;
                	}
                	File srcFile1 = new File(remainder);        						//scan the file name typed in 
    				if(!srcFile1.exists()||!srcFile1.canRead())
    				{      										//if the file does not exist or can not read
    					System.out.println("Cannot find the specified file");  			//print"Cannot find the specified file"
    					break;      								//go back to the console
    				}
    				Scanner fileIn1 = new Scanner(srcFile1);                      			 //scan the file
    				tmpmovieQueue = new LinkedList<String>();         
    				while(fileIn1.hasNext())
    				{                     								//tranverse the file by line
    					String line= fileIn1.nextLine();          
    					tmpmovieQueue.add(line);                            			//add the lines of the file in to the listnode by sequence(linkedlist)
    				}
    				fileIn1.close();
    				System.out.println( tmpmovieQueue.print());					//print out the file
    				int linenumber4 = 0;
    				boolean stringint = true;
    				do
    				{
    					System.out.println("Please enter a number between 1 and "+ tmpmovieQueue.size());	//keep asking user to input a number until an valid number has been inputed
    					String input2 = stdin.nextLine();							//convert the input string into int.	
      
					try
					{
						linenumber4 = Integer.parseInt(input2);
						stringint = true;
    				}
					catch(Exception e)
					{
						stringint = false;
					}
    				} while(linenumber4 < 0 || linenumber4 > tmpmovieQueue.size() || !stringint);
    				movieQueue.add(tmpmovieQueue.get(linenumber4));							//add the specific node to the end of the queue.
    				System.out.println("Added " + tmpmovieQueue.get(linenumber4) + " to queque");
    				break;
    				
                /*
		* Copies the line at line# to the end of the movie queue, and print "Copied title to end of queue.", 
		* where title is the title of the copied movie. This does not remove the line at line#. If an InvalidListPositionException 
		* is thrown, or if the argument is not an int, print "Invalid line number." 	
                */
		case 'c' :
                	if(remainder.length() == 0)                               //check if the arguement is valid 
                	{
                		System.out.println("need the line number.");
                		break;
                	}
                	
                	try
                	{
                		int linenumber = Integer.parseInt(remainder);             //convert input into int
                		movieQueue.add(movieQueue.get(linenumber));                          //add at the end of the nodelist
                		System.out.println("Copied " + movieQueue.get(linenumber) + " to end of the queue"); 
                	}
                	catch(InvalidListPositionException ex)
                	{    											 //catch exception if there is one
                		System.out.println("Invalid line number"); 					//handle the exception by printing "Invalid line number"
                	}
                	catch(Exception e){
                		System.out.println("Invalid line number");
                	}
                	break;
                
                case 'l' :
                	if (remainder.length() == 0)                               
                	{
                		System.out.println("need the name of the file");
                		break;
                	}
                	File srcFile = new File(remainder);        						//scan the file name typed in 
    				if(!srcFile.exists()||!srcFile.canRead())
    				{      										//if the file does not exist or can not read
    					System.out.println("Cannot find the specified file");  //print"Cannot find the specified file"
    					break;      											//go back to the console
    				}
    				movieQueue = new LinkedList<String>();	
    				Scanner fileIn = new Scanner(srcFile);                    	//scan the file
    				while(fileIn.hasNext())
    				{                     						//tranverse the file by line
    					String line= fileIn.nextLine();          
    					movieQueue.add(line);                            	//add the lines of the file in to the listnode by sequence(linkedlist)
    				}
    				fileIn.close();
    				System.out.println( movieQueue.print());
                	break;
                	
                case 'm' :
                	if(remainder.length() == 0)								//check if the arguement is valid 
                	{
                		System.out.println("need the line number.");
                		break;
                	}
                	try
                	{
                		int linenumber1 = Integer.parseInt(remainder);
                		movieQueue.add(0 , movieQueue.remove(linenumber1));                     	 //remove the node and add to the begin of the nodelist
                		System.out.println("Moved " + movieQueue.get(0) + " to front of queue");
                	}
                	catch(InvalidListPositionException ex)
                	{    												 //catch exception if there is one
        				System.out.println("Invalid line number"); 				//handle the exception by printing "Invalid line number"
    			}
			catch(Exception e)
			{
					System.out.println("plz input an int"); 
			}
                	break;
                	
                	
                case 'p' :
                	if(movieQueue.isEmpty())
                	{
                		System.out.println("is Empty");
                	}
                	else
                	{
                		System.out.println(movieQueue.print());
                	}
                	break;
                	
                case 'r' :
                	if(remainder.length() == 0)
                	{
                		System.out.println("need the line number.");
                		break;
                	}
                	try
                	{
				int linenumber2 = Integer.parseInt(remainder);
                		System.out.println("Removed " + movieQueue.get(linenumber2) + " from queue");
                		movieQueue.remove(linenumber2);  
                	}
                	catch(InvalidListPositionException ex)
                	{    											 //catch exception if there is one
        				System.out.println("Invalid line number"); 				//handle the exception by printing "Invalid line number"
    			}
			catch(Exception e)
			{
					System.out.println("Invalid line number"); 
			}
                	break;
                	
                case 's' :
                	if (remainder.length() == 0) 
			{
				System.out.println("need the name of a file");
				break;
                        }
			if(movieQueue.isEmpty())
			{                            //If the movie queue is currently empty, print, "Cannot write to file, movie queue is empty.                     
				System.out.println("Cannot write to file, movie queue is empty");  
			}
			try
			{
				java.io.PrintStream ps = new java.io.PrintStream(remainder);  //Save the file to the specified fileName.
				int i = 0;
				while (i < movieQueue.size())
				{                     										   //print the items line by line in the file
					ps.println(movieQueue.get(i+1));
					i++;
				}
					ps.println("");
					ps.close();   
					System.out.println("Successfully saved");                 //if saved, print success
			}
			catch(InvalidListPositionException d)
			{   														 //catch the exception and print "Invalid line number" 
				System.out.println("Cannot write to the specified file");  
               		}
                	break;
                	
                case 'w' :
                	if(remainder.length() == 0)
                	{
                		System.out.println("need the line number.");
                		break;
                	}
                	try
                	{
				int linenumber3 = Integer.parseInt(remainder);
                		if (linenumber3 > movieQueue.size())
                		{
                			System.out.println("Removed first " + movieQueue.size() + " from queue");
                			while(movieQueue.size() != 0)
                			{
                				movieQueue.remove(1);
                			}    	
                		}
                		else
                		{
                			System.out.println("Removed first " + linenumber3 + " from queue");
                			while(linenumber3 > 0)
                			{
                				movieQueue.remove(1);
                				linenumber3 --;
                			}
                		}
                	}
                	catch(InvalidListPositionException ex)
                	{    											 //catch exception if there is one
        			System.out.println("Invalid line number"); 				//handle the exception by printing "Invalid line number"
    			}
			catch(Exception e)
			{
					System.out.println("Invalid line number"); 
			}
                	break;
                	
                case 'x' :
                	//Exit the program. This command is already implemented.
                	done = true;
                    System.out.println("exit");
                    break;
                	
                default :
                	System.out.println("Unknown Command");
                	break;
                }
            }
        }
	}
}
