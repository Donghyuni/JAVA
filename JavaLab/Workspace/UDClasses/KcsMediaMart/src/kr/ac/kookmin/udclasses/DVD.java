package kr.ac.kookmin.udclasses;
public class DVD {
    private String title;
	private String category;
	private String director;
	private int length;
	private float cost;

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getLength() {
		return this.length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public float getCost() {
		return this.cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

    	/**
	* Returns the title
	*/
	public String getTitle() {
		return title;
	}
	/**
	* Sets the title
	*/
	public void setTitle(String title) {
		this.title = title;
	}
}
