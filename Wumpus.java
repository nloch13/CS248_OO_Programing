import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
public class Wumpus {
//Array of all rooms
 static Room[] rooms;
 //Random variable for obstacle generation
 static Random r = new Random();
 public static void main(String args[]) throws FileNotFoundException {
 //Scanner for the rooms text file
 Scanner sc = new Scanner(new File("wumpus.txt"));
 int roomCount = Integer.parseInt(sc.nextLine());
//Declare rooms list to be the size specificed in the text file
 rooms = new Room[roomCount];

 //Instantiate each room w/ adjacent rooms and descriptions from text file and
//add them to the list
 for(int i = 0; i < roomCount; i++){
 Room room = new Room(i+1, findAdjacentRooms(sc.nextLine()), sc.nextLine(),"Empty");
 rooms[i] = room;
 }

//Spawns the obstacles
 spawnObstacle(roomCount, "Spider");
 spawnObstacle(roomCount, "Spider");
 spawnObstacle(roomCount, "Pit");
 spawnObstacle(roomCount, "Pit");
 spawnObstacle(roomCount, "Wumpus");
//Calls game function
 game();

//Closes sc scanner
 sc.close();
 }
 //Game function
 private static void game(){

 //Variable declarations
 boolean playing = true;
 boolean win = false;
 int currentRoom = 0;
 int ammo = 3;
//Allows user to input
 Scanner sc = new Scanner(System.in);

 System.out.println("Welcome to **Hunt The Wumpus!**");
//Game loop
 while(playing){
//Displays current game info to user
 System.out.println("You are in room " + (currentRoom+1) + ".");
 System.out.println("You have " + ammo + " arrows left.");
 System.out.println(getRoom(currentRoom).getDescription());
 System.out.println("There are tunnels to rooms " +
(getRoom(currentRoom).getAdjacent()[0]+1) + ", " +
 (getRoom(currentRoom).getAdjacent()[1]+1) + ", and " +
(getRoom(currentRoom).getAdjacent()[2]+1) + ".");

//Variable declarations
 boolean spider = false, wumpus = false, pit = false;
//Tells you if adjacent rooms have obstacles
 for(int i = 0; i < getRoom(currentRoom).getAdjacent().length; i++){
 if(getRoom(getRoom(currentRoom).getAdjacent()
[i]).getObstacle().equals("Spider"))
 spider = true;

 if(getRoom(getRoom(currentRoom).getAdjacent()
[i]).getObstacle().equals("Wumpus"))
 wumpus = true;

 if(getRoom(getRoom(currentRoom).getAdjacent()
[i]).getObstacle().equals("Pit"))
 pit = true;

 }
 if(spider)
 System.out.println("You hear a faint clicking sound.");
 if(pit)
 System.out.println("You smell a dank odor.");
 if(wumpus)
 System.out.println("You smell some nasty Wumpus!");
 System.out.println("(M)ove or (S)hoot?");
 String choice;

 //User input
 do{
 choice = sc.nextLine();
//Moving to adjacent room
 if(choice.equals("M")){
 System.out.println("Which room?");
 int roomChoice = sc.nextInt() - 1;
 int initialRoom = currentRoom;
 for(int i = 0; i < getRoom(currentRoom).getAdjacent().length; i++){
 if(roomChoice == getRoom(currentRoom).getAdjacent()[i]){
 currentRoom = getRoom(currentRoom).getAdjacent()[i];
 }
 }
 if(currentRoom == initialRoom){
 System.out.println("Dimwit! You can't get to there from here.");
 }
 }
//Shoots arrow in adjacent room
 else if(choice.equals("S")){
 System.out.println("Which room?");
 int roomChoice = sc.nextInt() - 1;
 int initialAmmo = ammo;
 for(int i = 0; i < getRoom(currentRoom).getAdjacent().length; i++){
 if(roomChoice == getRoom(currentRoom).getAdjacent()[i]){
 ammo--;
 //User hits the wumpus and wins
 if(getRoom(getRoom(currentRoom).getAdjacent()
[i]).getObstacle().equals("Wumpus")){
 System.out.println("Your arrow goes down the tunnel and finds its mark!");
 win = true;
 playing = false;
 }
 //User misses
 else{
 System.out.println("Your arrow goes down the tunnel is lost. You missed.");
 }
 }
 }
 //User enters invalid room
 if(ammo == initialAmmo){
 System.out.println("Dimwit! You can't shoot there from here.");
 }
 }
 }
 while(choice.equals(""));
 //Checks if theres an obstacle in current room and kills you if there is
 if(!getRoom(currentRoom).getObstacle().equals("Empty")){
 if(getRoom(currentRoom).getObstacle().equals("Spider")){
 System.out.println("Several giant spiders bite you, killing you instantly!");
 }
 else if(getRoom(currentRoom).getObstacle().equals("Pit")){
 System.out.println("You fall down a bottomless pit!");
 }
 else if(getRoom(currentRoom).getObstacle().equals("Wumpus")){
 System.out.println("The Wumpus grabs you and eats you!");
 }
 playing = false;
 }
 //User runs out of ammo and loses
 if(ammo == 0){
 System.out.println("You ran out of ammo!");
 playing = false;
 }
 }
//Win/loss messages
 if(win){
 System.out.println("You shot the Wumpus! ** You Win! **\n\nEnjoy your fame!");
 }
 else{
 System.out.println("You succumb to The Caves! ** You Lose. **\n\nYou are a failure.");
 }
 }
 //Function to spawn obstacle in a random room (except for room 1)
 private static void spawnObstacle(int roomCount, String obstacle){
 int roll = r.nextInt(9);
 while(!getRoom(roll+1).getObstacle().equals("Empty")){
 roll = r.nextInt(9);
 }
 getRoom(roll+1).setObstacle(obstacle);
 }
 //Function to get adjacent rooms from the text file
 private static int[] findAdjacentRooms(String line){
 String[] splitLine = line.split(" ");
 int[] adjacent = {Integer.parseInt(splitLine[1])-
1,Integer.parseInt(splitLine[2])-1, Integer.parseInt(splitLine[3])-1};
 return adjacent;
 }
 //Returns room based on number
 private static Room getRoom(int number){
 return rooms[number];
 }
}