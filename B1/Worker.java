package B1;

public class Worker extends Officer {
	private int level;
	public Worker(String name, int age, String gender, String address, int level) {
		super(name, age, gender, address);
		// TODO Auto-generated constructor stub
		this.level = level;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

}
