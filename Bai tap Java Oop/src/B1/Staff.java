package B1;

public class Staff extends Officer{
	private String task;

	public Staff(String name, int age, String gender, String address, String task) {
		super(name, age, gender, address);
		// TODO Auto-generated constructor stub
		this.setTask(task);
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}
	
	

}
