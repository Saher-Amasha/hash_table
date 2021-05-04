package lab10;

public class HashTable {
	private static final int DEF_MAX_HASH_SIZE = 10; // Default maximum hash table size
	private SLinkedList<HashTableData>[] hashArray; // Array containing the lists of keys
	private int counter = 0;
	private int maxNumber;

	public HashTable() // Constructor: default size
	{
		hashArray = new SLinkedList[DEF_MAX_HASH_SIZE];
		this.maxNumber=DEF_MAX_HASH_SIZE;

	}

	public HashTable(int maxNumber) throws Exception // Constructor: specific size
	{
		if(maxNumber>0)
		{
			hashArray = new SLinkedList[maxNumber];
			this.maxNumber=maxNumber;
		}
		else
		{
			throw new Exception();
		}

	}

	// HashFunctions
	int HashFunction(int key) {
		if (key > 0)
			return key % hashArray.length;
		return -1;

	}

	int HashFunction(String key) {
		int sum = 0;
		for (int i = 0; i < key.length(); i++) {
			sum += (int) (key.charAt(i));
		}
		return HashFunction(sum);
	}
	//Hash status methods
		public boolean isEmpty() {
			return counter == 0;
		}

		public boolean isFull() {
			return false;
		}

	// Hash manipulation methods
	public boolean retrieve(HashTableData searchElem) {
		int index = HashFunction(searchElem.getKey());
		if (hashArray[index] != null&&counter>0) {
			hashArray[index].gotoBeginning();
			do {
				if (hashArray[index].getCursor().HTD_equals(searchElem))
				{
					return true;
				}
			} while (hashArray[index].gotoNext() == true);
		}
		return false;

	}  

	public boolean insert(HashTableData newElem) {
		if (isFull() == false) {
			
			int index = HashFunction(newElem.getKey());
			if(hashArray[index]!=null)
			{
			hashArray[index].gotoBeginning();
			}
			if (hashArray[index] == null) {
				hashArray[index] = new SLinkedList<HashTableData>();
			}
			hashArray[index].insert(newElem);
			//INSERT ELEMENT
			

			hashArray[index].gotoBeginning();
			if(hashArray[index].gotoNext()==true) {
				
			hashArray[index].gotoBeginning();
			
			HashTableData temp1=hashArray[index].getCursor();
			hashArray[index].gotoNext();
			HashTableData temp2=hashArray[index].getCursor();
			hashArray[index].replace(temp1);
			hashArray[index].gotoBeginning();
			hashArray[index].replace(temp2);
			
			}
			counter++;
			return true;

		}
		return false;

	} 

	public boolean remove(HashTableData remElem) {
		
		int index = HashFunction(remElem.getKey());
		if (hashArray[index] != null &&counter>0) {
			
			hashArray[index].gotoBeginning();
			do {
				
				if (hashArray[index].getCursor().HTD_equals(remElem)==true) {
					hashArray[index].remove();
					counter--;
					return true;
				}
			} while (hashArray[index].gotoNext() == true);
		}
		return false;

	}

	public void clear() {
		for (int i = 0; i < hashArray.length; i++) {
			hashArray[i] = null;
		}
		counter = 0;
	}


//Output the hash structure
	public String toString() {
		if(counter==0)
		return "Empty hash table";
		String temp = "";

		for (int i = 0; i < hashArray.length; i++) {
			temp +="["+i+"]->";
			if(hashArray[i]!=null)
			temp += hashArray[i].toString() ;
			else
				temp+=null;
			temp+='\n';
		}
		return temp;

	}
} // class HashTable
