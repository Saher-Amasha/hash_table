
public class HashTableData
{
	
	private String key; // Hash Table key
	
	// Additional fields
	private String first_name;
	private Long id;
	private int age;
	private double average;
	
	public HashTableData(String first_name, String key, Long id, int age, double average) {
		this.first_name = first_name;
		this.key = key;
		this.id = id;
		this.age = age;
		this.average = average;
	}

	public boolean HTD_equals(HashTableData obj)
	{
		if (key.equals(obj.getKey())&&
				first_name.equals(obj.getFirst_name())&&
				id==obj.getId()&&
				age==obj.getAge()&&
				average==obj.getAverage())
			return true;
		return false;
	}

	public String getKey() {
		return key;
	}

	public String getFirst_name() {
		return first_name;
	}

	public Long getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public double getAverage() {
		return average;
	}
	@Override
	public String toString() {
		return "[key=" + key + ", first_name=" + first_name + ", id=" + id + ", age=" + age + ", average="
				+ average + "]";
	}
	
} // class HashTableData


