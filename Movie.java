package movie;

public class Movie{
	// fields
	private String title;
	private String actor1;
	private String actor2;
	private String director;
	private String year;
	private String runtimeMinutes;
	
	// constructor 
	public Movie(String title, String actor1, String actor2, String runtimeMinutes, String year, String director) {
		this.title = title;
		this.actor1 = actor1;
		this.actor2 = actor2;
		this.director = director;
		this.year = year;
		this.runtimeMinutes = runtimeMinutes;
	}
	
	//methods
	public String getTitle() {
		return title;
	}
	
	public String getActor1() {
		return actor1;
	}
	
	public String getActor2() {
		return actor2;
	}
	
	public String getDirector() {
		return director;
	}
	
	public String getYear() {
		return year;
	}
	
	public String getRunTime() {
		return runtimeMinutes;
	}
}