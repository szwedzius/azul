import java.io.*;
import java.util.Scanner;

/**
 * The game class handles all other classes
 * and operates on their objects
 */
public class Game implements Serializable {
    /**
     * Number of players playing
     */
    public final int players;

    /**
     * Game mode
     * 1 - singleplayer
     * 0 - multiplayer
     */
    public final int mode;

    /**
     * Table - one instance per game
     */
    public final Table table;

    /**
     * Player class instances - each player is represented by one
     */
    public final Player[] playersTables;

    /**
     * Default constructor
     */
    public Game(int numberOfPlayers, int mode) {
        playersTables = new Player[numberOfPlayers];
        players = numberOfPlayers;
        table = new Table(players);
        this.mode = mode;
    }

    /**
     * Checking whether the conditions for ending the game are met
     * @return Check result
     */
    public boolean isFinished() {
        // TODO implement here
        return false;
    }

    /**
     * Method responsible for saving the current game
     */
    public void save(String path) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path+".bin"))) {
            outputStream.writeObject(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method responsible for loading the game
     */
    public static Game load(String path) {
        Game game = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path+".bin"))) {
            game = (Game) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return game;
    }

    /**
     * Method for pointing out the winner
     * @return The player who has won
     */
    public Player returnWinner() {
        // TODO implement here
        return null;
    }

    /**
     * Method for getting the number of players
     * @return Number of players
     */
    public int getNumberOfPlayers() {
        return players;
    }

    /**
     * Method to return the table of players
     * @return Table of Player objects representing the players
     */
    public Player[] getPlayersTables() {
        return playersTables;
    }

    public void printFactory() {
        System.out.println();
        for (int i = 0; i < 2 * players + 1; i++) {
            Tile[] contents = table.factories[i].getContents();
            System.out.print((i + 1) + " Factory: ");
            for (int j = 0; j < 4; j++) {
                System.out.print(contents[j] + " ");
            }
            System.out.println();
        }
        // Printing what center contains
        System.out.print("10 Center: ");
        for (int i = 0; i < table.center.size(); i++)
            System.out.print(table.center.get(i) + " ");
        System.out.println();
    }

    public boolean isMoveValid(int number, int row, int playerNumber, Tile tile) {
        if(row == 5)
            return true;
        else
            return (playersTables[playerNumber].pattern.colours[row] == tile &&
                playersTables[playerNumber].pattern.amounts[row] < (row + 1) ) ||
                playersTables[playerNumber].pattern.colours[row] == null;
    }

    public void addTilesToPatternLines (int indexOfPlayer) {

        Tile tileToAdd;
        int number;
        int whereToPlaceTiles;

        Scanner reader = new Scanner(System.in);
        System.out.println();

        System.out.println("Choose factory or center from which you want to take tiles, 10 for center");
        number = reader.nextInt() - 1;

        System.out.println("Choose tile which you want to take from the factory");
        String tiles = reader.next();

        System.out.println("Choose where you want to add the tiles, 1-5 for pattern lines, 6 for floor");
        whereToPlaceTiles = reader.nextInt() - 1;

        tileToAdd = switch (tiles.toUpperCase()) {
            case "BLACK" -> Tile.BLACK;
            case "WHITE" -> Tile.WHITE;
            case "BLUE" -> Tile.BLUE;
            case "YELLOW" -> Tile.YELLOW;
            case "RED" -> Tile.RED;
            default -> null;
        };

        while (!table.isColourInFactory(tileToAdd, number) || !isMoveValid(number, whereToPlaceTiles, indexOfPlayer, tileToAdd)){
            System.out.println("Chosen tile doesn't exist in this factory, please choose again");
            System.out.println();

            System.out.println("Choose factory or center from which you want to take tiles");
            number = reader.nextInt() - 1;

            System.out.println("Choose tile which you want to take from the factory");
            tiles = reader.next();

            System.out.println("Choose where you want to add the tiles, 1-5 for pattern lines, 6 for floor");
            whereToPlaceTiles = reader.nextInt() - 1;

            tiles = reader.next();
            tileToAdd = switch (tiles.toUpperCase()) {
                case "BLACK" -> Tile.BLACK;
                case "WHITE" -> Tile.WHITE;
                case "BLUE" -> Tile.BLUE;
                case "YELLOW" -> Tile.YELLOW;
                case "RED" -> Tile.RED;
                default -> null;
            };
        }


        if (whereToPlaceTiles == 5 && number != 9) {
            for (int i =0; i < 4; i++) {
                if (table.factories[number].getContents()[i] == tileToAdd){
                    if (playersTables[indexOfPlayer].floor.size() < 7)
                        playersTables[indexOfPlayer].floor.add(tileToAdd);
                    else
                        table.box.add(tileToAdd);
                }
                else
                    table.center.add(table.factories[number].getContents()[i]);
                table.factories[number].getContents()[i] = null;
            }
        } else if (whereToPlaceTiles == 5 && number == 9){
            if (table.isPriorityTileInCenter()){
                playersTables[indexOfPlayer].setFirst();
                playersTables[indexOfPlayer].floor.add(Tile.FIRSTTILE);
                table.center.remove(Tile.FIRSTTILE);
            }

            for (int i = 0; i < table.center.size(); i++){
                if (table.center.get(i) == tileToAdd){
                    if (playersTables[indexOfPlayer].floor.size() < 7)
                        playersTables[indexOfPlayer].floor.add(tileToAdd);
                    else
                        table.box.add(tileToAdd);
                    table.center.remove(i);
                }
            }
        }else if (whereToPlaceTiles < 5 && number != 9) {
            for (int i = 0; i < 4; i++) {
                if (table.factories[number].getContents()[i] == tileToAdd &&
                    playersTables[indexOfPlayer].pattern.amounts[whereToPlaceTiles] < (whereToPlaceTiles + 1))
                    playersTables[indexOfPlayer].pattern.addToRow(whereToPlaceTiles, tileToAdd, 1);
                else if (table.factories[number].getContents()[i] == tileToAdd &&
                        playersTables[indexOfPlayer].pattern.amounts[whereToPlaceTiles] == (whereToPlaceTiles + 1)){

                    if (playersTables[indexOfPlayer].floor.size() < 7)
                        playersTables[indexOfPlayer].floor.add(tileToAdd);
                    else
                        table.box.add(tileToAdd);
                }
                else
                    table.center.add(table.factories[number].getContents()[i]);
                table.factories[number].getContents()[i] = null;
            }
        } else if (whereToPlaceTiles < 5 && number == 9){
            for (int i = 0; i < table.center.size(); i++){
                if (table.isPriorityTileInCenter()){
                    playersTables[indexOfPlayer].setFirst();
                    playersTables[indexOfPlayer].floor.add(Tile.FIRSTTILE);
                    table.center.remove(Tile.FIRSTTILE);
                }

                else if (table.center.get(i) == tileToAdd &&
                        playersTables[indexOfPlayer].pattern.amounts[whereToPlaceTiles] < (whereToPlaceTiles + 1)) {
                    playersTables[indexOfPlayer].pattern.addToRow(whereToPlaceTiles, tileToAdd, 1);
                    table.center.remove(i);
                }
                else if (table.center.get(i) == tileToAdd &&
                        playersTables[indexOfPlayer].pattern.amounts[whereToPlaceTiles] == (whereToPlaceTiles + 1)){
                    if (playersTables[indexOfPlayer].floor.size() < 7)
                        playersTables[indexOfPlayer].floor.add(tileToAdd);
                    else
                        table.box.add(tileToAdd);
                    table.center.remove(i);
                }
            }
        }
    }
    public void addToWall(int indexOfPlayer){

        for (int i = 0; i < 5; i++){
            if (playersTables[indexOfPlayer].pattern.isRowFull(i)){
                playersTables[indexOfPlayer].sumPoints(playersTables[indexOfPlayer].wall.addTile(playersTables[indexOfPlayer].pattern.colours[i],i));
                for (int j = 1; j < i; j++){
                    table.box.add(playersTables[indexOfPlayer].pattern.colours[j]);
                }
                playersTables[indexOfPlayer].pattern.clearRow(i);
            }
        }

    }

    public void subtractPointsFromFloor (int indexOfPlayer) {
        for (int i = 0; i < 7; i++) {
            if (playersTables[indexOfPlayer].floor.get(i) != null ){
                if ( i == 0 || i == 1)
                    playersTables[indexOfPlayer].sumPoints(-1);
                else if (i > 1 && i < 5) {
                    playersTables[indexOfPlayer].sumPoints(-2);
                } else {
                    playersTables[indexOfPlayer].sumPoints(-3);
                }
            }
            else
                break;
        }
        playersTables[indexOfPlayer].clearFloor();
    }
    public static void main(String[] args){

        int numberOfPlayers = 2;
        int mode = 0;
        boolean isEnd = true;
        boolean ifPossible = true;
        Tile tile = Tile.BLACK;
        // setup Table and factories
        Game game = new Game(numberOfPlayers, mode);
        for (int i = 0; i < numberOfPlayers; i++){
            String playerName = "XD";
            game.playersTables[i] = new Player(playerName);
        }

            game.printFactory();
            game.addTilesToPatternLines(0);
            game.playersTables[0].pattern.printPatternLine();
            game.addTilesToPatternLines(0);
            game.playersTables[0].pattern.printPatternLine();
            game.addTilesToPatternLines(0);
            game.playersTables[0].pattern.printPatternLine();

            game.addToWall(0);
            game.playersTables[0].wall.printWall();
            game.playersTables[0].printFloor();
            game.printFactory();

        game.addTilesToPatternLines(1);
        game.playersTables[1].pattern.printPatternLine();

            game.printFactory();
            game.addTilesToPatternLines(0);
            game.playersTables[0].pattern.printPatternLine();

        

        //game.save("test");
        //Game g = Game.load("test");
    }
}