package options;

import java.util.Scanner;
import database.Database;
import movie.Movie;
import filewrite.fileWrite;

public class Options {
    private Scanner scanner;
    private Database db;
    private fileWrite fw;

    public Options() {
        scanner = new Scanner(System.in);
        db = new Database("src/db.txt");
        fw = new fileWrite("src/db.txt");
    }

    public void options() {
        System.out.println("a) New Entry");
        System.out.println("b) Search by Actor");
        System.out.println("c) Search by Year");
        System.out.println("d) Search by Runtime (minutes)");
        System.out.println("e) Search by Director");
        System.out.println("f) Search by Title");
        System.out.println("g) Quit");
        System.out.println("");
        String userChoice = scanner.nextLine();
        if (!userChoice.equalsIgnoreCase("g"))
            prompt(userChoice);
        else
            System.out.println("\nHope You Enjoyed");
    }

    public void nice(String userChoice) {
        if (userChoice.equalsIgnoreCase("a") || userChoice.equalsIgnoreCase("new entry")) {
            String title = scanner.nextLine();
            String actor1 = scanner.nextLine();
            String actor2 = scanner.nextLine();
            String runtime = scanner.nextLine();
            String year = scanner.nextLine();
            String director = scanner.nextLine();
            fw.writeLine(title + "," + actor1 + "," + actor2 + "," + runtime + "," + year + "," + director + ",");
            Movie a = new Movie(title, actor1, actor2, runtime, year, director);
           db.addEntry(a);
        }
    }
        public void prompt(String userChoice) {
            switch (userChoice.toLowerCase()) {
                case "a":
                case "new entry":
                    addNewEntry();
                    break;
                case "b":
                case "search by actor":
                    searchByActor();
                    break;
                case "c":
                case "search by year":
                    searchByYear();
                    break;
                case "d":
                case "search by runtime":
                    searchByRuntime();
                    break;
                case "e":
                case "search by director":
                    searchByDirector();
                    break;
                case "f":
                case "search by title":
                    searchByTitle();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println("");
            options();
        }

        private void addNewEntry() {
        	System.out.print("enter Title: ");
            String title = scanner.nextLine();
        	System.out.print("enter actor: ");
            String actor1 = scanner.nextLine();
        	System.out.print("enter another actor: ");
            String actor2 = scanner.nextLine();
        	System.out.print("enter runtime: ");
            String runtime = scanner.nextLine();
        	System.out.print("enter Year: ");
            String year = scanner.nextLine();
        	System.out.print("enter director: ");
            String director = scanner.nextLine();
            fw.writeLine(title + "," + actor1 + "," + actor2 + "," + runtime + "," + year + "," + director + ",");
            Movie newMovie = new Movie(title, actor1, actor2, runtime, year, director);
            db.addEntry(newMovie);
        }

        private void searchByActor() {
        	System.out.println("Enter Actor:");
            String searchActor = scanner.nextLine();
            db.searchByActor(searchActor);
        }

        private void searchByYear() {
        	System.out.println("Enter Year:");
            String searchYear = scanner.nextLine();
            db.searchByYear(searchYear);
        }

        private void searchByRuntime() {
            String searchRuntime = scanner.nextLine();
            db.searchByRuntime(searchRuntime);
        }

        private void searchByDirector() {
            String searchDirector = scanner.nextLine();
            db.searchByDirector(searchDirector);
        }

        private void searchByTitle() {
        	System.out.println("Enter Title:");
            String searchTitle = scanner.nextLine();
            db.searchByTitle(searchTitle);
    }
}
