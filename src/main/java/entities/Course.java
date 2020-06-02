package entities;

public class Course {

	private int id;
	private String username;
	private String description;

	public Course() {

	}

	public Course(int id, String username, String description) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int i) {
		this.id = i;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", username=" + username + ", description=" + description + "]";
	}

	
}
