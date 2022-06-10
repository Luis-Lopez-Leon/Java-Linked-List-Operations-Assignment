import java.util.LinkedList;
import java.util.Scanner;

//Luis Lopez
//Assignment 3

// SINGLE-ENDED SINGLY LINKED LISTS ONLY
// Traverse one way and ends at the last link being null.

public class LinkedListOpApp {

	public static void main(String[] args) {
		
		Scanner userString = new Scanner(System.in);
		Scanner userNumbers = new Scanner(System.in);
		String wordString;
		int firstNumItems,secondNumItems;
		
		System.out.println("Please enter a string with no spaces:\n");
		wordString = userString.nextLine();//user inputs a word (String)
		
		char[] wordArr = new char[wordString.length()];//making a char string array to dissect each character so we can then add them to Link List
		
		
		System.out.println(wordString + "\n\n");
		
		for(int i = 0; i < wordString.length(); i++)//populating char array
			wordArr[i] = wordString.charAt(i);

		//for(int i = 0; i < wordString.length(); i++)//testing char array
			//System.out.printf("%c",wordArr[i]);
		
		LinkList wordList = new LinkList(); //making a new Link list to store a character in each link.
		
		for(int i = wordString.length() - 1; i >= 0 ; i--) {//starting from the end of the array so my insertFirst method works correctly when its time to display the link list.
			
			wordList.insertFirst(wordArr[i]);
			
		}
		System.out.println("\nOriginal List:");
		wordList.displayList();//testing LinkList
		
		//PART I - Word game 
		//RULES:
		//1. When encounter "rm", REMOVE the character that follows it. IF "rm" is at the end and has no character following it, DELETE "rm".
		//2. No bowels between consonants! Delete them if they are.
		//Display the current state of the link list after each round.
	
	
		//Check rule 2 first
		//Check for rule 1 second
		//checking multiple times
		
		
		while(wordList.findVowelBConst(wordList)) {//loop to check rule 2 first
			
			System.out.println("\n");
			wordList.displayList();
			wordList.findVowelBConst(wordList);
		}
		
		while(wordList.findRM(wordList)) {//loop to check rule 1 second
			
			System.out.println("\n");
			wordList.displayList();
			wordList.findRM(wordList);
		}
		
	
		
		System.out.println("\nFinal output: ");
		wordList.displayList();
		System.out.println("\n");
		
		//**************************************************************************************************************
		
		//PART II - Numbers game 
		
		LinkList firstNumList = new LinkList();
		LinkList secondNumList = new LinkList();
		LinkList tempList = new LinkList();
		
		System.out.println("Please enter the number of items for the first list:\n");
		firstNumItems = userString.nextInt();//user inputs a word (String)
		int[] intArr1 = new int[firstNumItems];
		
		System.out.println("Now please enter that many number of items sorted in ascending order:\n");
		
		for(int i = 0; i < firstNumItems; i++)
			intArr1[i] = userString.nextInt();
			
		for(int i = firstNumItems - 1; i >= 0; i--) {
			
			firstNumList.insertFirst(intArr1[i]);
			
		}

		//firstNumList.displayListInt();//test firstnumList
		
		System.out.println("\n\n");
		
		System.out.println("Please enter the number of items for the second list:\n");
		secondNumItems = userString.nextInt();//user inputs a word (String)
		int[] intArr2 = new int[secondNumItems];
		
		System.out.println("Now please enter that many number of items sorted in ascending order:\n");
		
		for(int i = 0; i < secondNumItems; i++)
			intArr2[i] = userString.nextInt();
			
		for(int i = secondNumItems - 1; i >= 0; i--) {
			
			secondNumList.insertFirst(intArr2[i]);
			
		}

		//secondNumList.displayListInt();//test secondnumList
		
		//Merging both lists into one
		LinkList mergedList = tempList.merge2(firstNumList, secondNumList);
		System.out.println("Complete merged list:");
		mergedList.displayListInt();
		
		
		System.out.println("\n\n");
		System.out.println("Sublist of duplicates:\n");
		mergedList.printDuplicates(mergedList);
		
		
	}

}