package lab10;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;


public class TestHashTable {
			
		public static HashTableData create_student()
		{
			Scanner s= new Scanner(System.in); //System.in is a standard input stream  
			 
			System.out.print("Enter student data \n");
			System.out.print("first name:");
			String t1=s.nextLine();
			
			System.out.print("last name:");
			String t2=s.nextLine();
			
			System.out.print("id:");
			Long t3=s.nextLong();
			
			System.out.print("age:");
			int t4=s.nextInt();
			System.out.print("average:");
			Double t5=s.nextDouble();
			return new HashTableData(t1,t2,t3,t4,t5);
			
		}  
		public static void main(String[] args) throws Exception {
			Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
			System.out.print("ENTER HASH TABLE SIZE:");
			int t1=sc.nextInt();
			 
			HashTable my_hashtable=new HashTable(t1);
			InputStreamReader reader = new InputStreamReader(System.in);
			StreamTokenizer tokens = new StreamTokenizer(reader);
			
			String tmpString;
			if((tokens.nextToken())!=StreamTokenizer.TT_WORD)
			{
				tmpString = new String("" + tokens.nval);
			}else
			{
				tmpString = tokens.sval;
			}while(!tmpString.equals("Q"))
			{

				switch (tmpString) {
 
				case "ADD":
			
					
					
					my_hashtable.insert(create_student());
					break;
				case "FIND":
			
					if(my_hashtable.retrieve(create_student())==true)
						System.out.println("student is in the hash table");
					else	
						System.out.println("student is NOT in the hash table");
					
					break;
				case "REMOVE":
					if(my_hashtable.remove(create_student())==true)
						System.out.println("student has been removed from the hash table");
					else	
						System.out.println("student not found");
					
						         
						break;
				case "PRINT":
					System.out.println(my_hashtable.toString());
					break;	
				case "E":
					System.out.println(my_hashtable.isEmpty());
					
					break;
				case "F":
					System.out.println(my_hashtable.isFull());
					break;
				case "C":
					my_hashtable.clear();
					break;
						default:
	   
					break;
				}

				if ((tokens.nextToken()) != StreamTokenizer.TT_WORD) {
					tmpString = new String("" + tokens.nval);
				} else {

					tmpString = tokens.sval;
				}

			}

		
		}

	


}


