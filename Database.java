package database;

import java.util.ArrayList;
import java.util.StringTokenizer;
import fileread.fileRead;
import movie.Movie;

public class Database{
	// fields
	private ArrayList<Movie> movies;
	
	// constructor
	public Database(String filename) {
		movies = new ArrayList<>();
		fileRead fr = new fileRead(filename);
		for(int i = 0; i < fr.getNumberOfLines(); i++) {
			String raw = fr.getLine(i);
			StringTokenizer st = new StringTokenizer(raw, ",");
			String title = st.nextToken().trim();
			String actor1 = st.nextToken().trim();
			String actor2 = st.nextToken().trim();
			String runtime = st.nextToken().trim();
			String year = st.nextToken().trim();
			String director = st.nextToken().trim();
			Movie x = new Movie(title, actor1, actor2, runtime, year, director);
			movies.add(x);
		}
	}
	
	// methods
	public void addEntry(Movie newEntry) {
		movies.add(newEntry);
	}
	
	public void searchByActor(String actor) {
		boolean found = false;
		for(Movie movie: movies) {
			if(actor.equalsIgnoreCase(movie.getActor1()) || actor.equalsIgnoreCase(movie.getActor2())) {
				found = true;
				System.out.println("\n" + movie.getTitle());
			}
			if(!found)
				System.out.println("\nNo movies with that actor");
		}
	}
	
	public void searchByYear(String year) {
		boolean found = false;
		for(Movie movie: movies) {
			if(year.equals(movie.getYear())){
				found = true;
				System.out.println("\n" + movie.getTitle());
			}
		}
		if(!found)
			System.out.println("\nNo movies from that year\n");
	}
	
	public void searchByRuntime(String runtime) {
		boolean found = false;
		for(Movie movie: movies) {
			if(runtime.equals(movie.getRunTime())){
				found = true;
				System.out.println("\n" + movie.getTitle());
			}
		}
		if(!found)
			System.out.println("\nNo movies with that runtime\n");
	}
	
	public void searchByDirector(String director) {
		boolean found = false;
		for(Movie movie: movies) {
			if(director.equalsIgnoreCase(movie.getDirector())){
				found = true;
				System.out.println("\n" + movie.getTitle());
			}
		}
		if(!found)
			System.out.println("\nNo movies with that director\n");
	}
	
	public void searchByTitle(String title) {
        boolean found = false;
        for (Movie movie : movies) {
            if (title.equalsIgnoreCase(movie.getTitle())) {
                found = true;
                System.out.println("\n" + "Actors: " + movie.getActor1() + ", " + movie.getActor2());
                System.out.println("Year: " + movie.getYear());
                System.out.println("Director: " + movie.getDirector());
                System.out.println("Runtime: " + movie.getRunTime());
            }
        }
        if (!found) {
            System.out.println("\nNo movies with that title\n");
        }
    }
}