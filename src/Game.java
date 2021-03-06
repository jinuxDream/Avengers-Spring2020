import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

//This class will store all of the methods for the game to run
public class Game {
	
	//Stores all of the rooms in the game
	HashMap<Integer, Room> hmRooms;
	
	//Stores all the items in the game
	HashMap<Integer, Item> hmItems;
	
	//Stores all the puzzles in the game
	HashMap<Integer, Puzzle> hmPuzzles;
	
	//Stores all the monsters in the game
	HashMap<Integer, Monster> hmMonsters;
	
	//Stores all the help commands in the game
	HashMap<String, String> hmHelpCommands;
	
	//Stores the current Player
	Player player;
	
	//Scanner for the game class
	Scanner sc;
	
	//Stores the game description
	String description;
	
	
	
	Game(File rooms, File items, File puzzles, File monsters, File helpCommands, File description)
	{
		//Read all of the files
		readRooms(rooms);
//		readItems(items);
		readPuzzles(puzzles);
//		readMonsters(monsters);
//		readHelpCommands(helpCommands);
		readDescription(description);
		
	}
	
	//Method to read the rooms text file
	void readRooms(File rooms) {
		try {
			sc = new Scanner(rooms);
		} catch (FileNotFoundException e) {
			System.out.print("No such file exists");
		}
		hmRooms = new HashMap<Integer, Room>();
		
		//split file into lines
		while (sc.hasNextLine()) {
			
			//split each line on the comma and add to array
			String[] strParts = sc.nextLine().split( "," ); 
			
			if(strParts[0]!= "") {
			//read from array and create Room object and add to ArrayList
				int id = Integer.parseInt(strParts[0]);
				String name = strParts[1];
				String desc = strParts[2];
				int north = Integer.parseInt(strParts[3]);
				int east = Integer.parseInt(strParts[4]);
				int south = Integer.parseInt(strParts[5]);
				int west = Integer.parseInt(strParts[6]);
				int up = Integer.parseInt(strParts[7]);
				int down = Integer.parseInt(strParts[8]);
					
				Room room = new Room(id, name, desc, north, east, south, west, up, down);
				
				hmRooms.put(room.getID(), room);
			}
		  }
	}
	
	//Method to read the items file
	void readItems(File items) 
	{
		try 
		{
			sc = new Scanner(items);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.print("No such file exists ");
		}
		
		hmItems = new HashMap<Integer, Item>();
		
		//split file into lines
		while (sc.hasNextLine()) 
		{
			//split each line on the comma and add to array
			String[] strParts = sc.nextLine().split( "," ); 
			
			Item item = null;
			//read from array and create Item object and add to ArrayList
			if(Integer.parseInt(strParts[4]) == 1) 
			{
				
			}
			
			else 
			{
				
			}
			
		}
	}
	
	//Method to read the puzzle file
	void readPuzzles(File puzzles) {
			try 
			{
				sc = new Scanner(puzzles);
			} 
			catch(FileNotFoundException e) 
			{
				System.out.print("No such file exists");
			}
			hmPuzzles = new HashMap<Integer, Puzzle>();
			while(sc.hasNextLine()) 
			{
				String[] strParts = sc.nextLine().split(",");
				
				if(strParts[0]!= "") {
					//read from array and create Puzzle object and add to Hashmap
						int id = Integer.parseInt(strParts[0]);
						String desc = strParts[1];
						String hint = strParts[2];
						String solution = strParts[3];
						int locationOpen = Integer.parseInt(strParts[4]);
						int locationPlaced = Integer.parseInt(strParts[5]);
							
						Puzzle puzzle = new Puzzle(id, desc, hint, solution, locationOpen, locationPlaced);
						
						hmPuzzles.put(puzzle.getID(), puzzle);
					}
			}
	}
	
	//Method to read the monster file
	void readMonsters(File monster) {
		
	}
	
	//Method to read the helpCommands file
	void readHelpCommands(File helpCommands) {
		
	}
	
	//Method to read the game description
	void readDescription(File description) {
		try {
			sc = new Scanner(description);
		} catch(FileNotFoundException e) {
			System.out.print("No such file exists");
		}
		while(sc.hasNextLine()) {
			this.description = sc.nextLine();
		}
	}
	
	
	
	
	
	
	
	//Method to display the game description
	String displayDescription() {
		return description;
	}
	
	//Method to set the player
	void setPlayer(Player p) {
		this.player = p;
	}
	
	
	//Methods to move directions
	String moveNorth(){
		Room currentRoom = hmRooms.get(player.getLocation());
		int newRoom = currentRoom.getNorth();
		
		if (newRoom==0) {
			return "Sorry, you can not move that direction.";
		}
		
		else {
			currentRoom.setVisited(true);
			player.setLocation(newRoom);
			return "You are now in the " + currentRoom.getName() + ".";
		}
		
	}
	String moveEast(){
		Room currentRoom = hmRooms.get(player.getLocation());
		int newRoom = currentRoom.getEast();
		
		if (newRoom==0) {
			return "Sorry, you can not move that direction.";
		}
		
		else {
			currentRoom.setVisited(true);
			player.setLocation(newRoom);
			return "You are now in the " + currentRoom.getName() + ".";
		}
		
	}
	String moveSouth(){
		Room currentRoom = hmRooms.get(player.getLocation());
		int newRoom = currentRoom.getSouth();
		
		if (newRoom==0) {
			return "Sorry, you can not move that direction.";
		}
		
		else {
			currentRoom.setVisited(true);
			player.setLocation(newRoom);
			return "You are now in the " + currentRoom.getName() + ".";
		}
		
	}
	String moveWest(){
		Room currentRoom = hmRooms.get(player.getLocation());
		int newRoom = currentRoom.getWest();
		
		if (newRoom==0) {
			return "Sorry, you can not move that direction.";
		}
		
		else {
			currentRoom.setVisited(true);
			player.setLocation(newRoom);
			return "You are now in the " + currentRoom.getName() + ".";
		}
		
	}
	String moveUp(){
		Room currentRoom = hmRooms.get(player.getLocation());
		int newRoom = currentRoom.getUp();
		
		if (newRoom==0) {
			return "Sorry, you can not move that direction.";
		}
		
		else {
			currentRoom.setVisited(true);
			player.setLocation(newRoom);
			return "You are now in the " + currentRoom.getName() + ".";
		}
		
	}
	
	String moveDown(){
		Room currentRoom = hmRooms.get(player.getLocation());
		int newRoom = currentRoom.getDown();
		
		if (newRoom==0) {
			return "Sorry, you can not move that direction.";
		}
		
		else {
			currentRoom.setVisited(true);
			player.setLocation(newRoom);
			return "You are now in the " + currentRoom.getName() + ".";
		}
		
	}
	
	//Method to apply other commands 
	String applyCommand(String text) {
		return "";
	}
	

}
