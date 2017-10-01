package learn.springioc.entity;

public class Festival {
	private String name;
	private int capacity;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Festival(String name, int capacity) {
		super();
		this.name = name;
		this.capacity = capacity;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("name - %s, capacity - %d", name, capacity);
	}
	
	
}
