/**
 * 
 * Class for storing topic
 *
 */
public class Topic {

	private String name;
	private String imagePath;

	public Topic(String name, String imagePath) {
		super();
		this.name = name;
		this.imagePath = imagePath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
