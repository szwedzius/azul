import java.util.Scanner;

/**
 * The game class handles all other classes
 * and operates on their objects
 */
public class Game {
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
    public void save() {
        // TODO implement here
    }

    /**
     * Method responsible for loading the game
     */
    public void load() {
        // TODO implement here
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

    public void applyMove(Move move) {
        // TODO
    }

    public void printFactory() {
        for (int i = 0; i < 2 * players + 1; i++) {
            Tile[] contents = table.factories[i].getContents();
            System.out.print((i + 1) + " Factory : ");
            for (int j = 0; j < 4; j++) {
                System.out.print(contents[j] + " ");
            }
            System.out.println();
        }
        // Printing what center contains
        System.out.print("10 Center : ");
        for (int i = 0; i < table.center.size(); i++)
            System.out.print(table.center.get(i) + " ");

    }


    public static void main(String[] args){

        int numberOfPlayers = 1;
        int mode = 0;
        int counter = 36;
        boolean isEnd = true;
        boolean ifPossible = true;
        Tile tile = Tile.BLACK;
        // setup Table and factories
        Game game = new Game(numberOfPlayers, mode);
        for (int i = 0; i < numberOfPlayers; i++){
            String playerName = "XD";
            game.playersTables[i] = new Player(playerName);
        }

        // Printing all factories
        while (isEnd){
            ifPossible = true;
            int amount = 0;
            game.printFactory();

            Scanner reader = new Scanner(System.in);
            System.out.println();

            Tile tileToAdd = null;
            int number = 0;
            int row = 0;
            while (ifPossible){
                // Choosing tile from factory
                System.out.println("Choose tile which you want to take from factory");
                String tiles = reader.next();
                System.out.println("Choose factory or center from which you want to take tiles");
                number = reader.nextInt() - 1;
                System.out.println("Choose where you want to add the tiles");
                row = reader.nextInt() - 1;

                tileToAdd = switch (tiles.toUpperCase()) {
                    case "BLACK" -> Tile.BLACK;
                    case "WHITE" -> Tile.WHITE;
                    case "BLUE" -> Tile.BLUE;
                    case "YELLOW" -> Tile.YELLOW;
                    case "RED" -> Tile.RED;
                    default -> null;
                };
                Move move = new Move(0, tileToAdd, number, row);
                if (move.isMoveValid(game)){
                    ifPossible = false;
                } else {
                    System.out.println();
                    System.out.println("This move is impossible");
                }
                System.out.println();
            }


            if (number < 9){
                // Counting number of tile in factory
                for(int i = 0; i < 4; i++){
                    if (game.table.factories[number].getContents()[i] == tileToAdd)
                        amount++;
                }

                // Getting tile from factory and adding it to patternLine
                if (row < amount){
                    game.playersTables[0].pattern.addToRow(row, tileToAdd, row);
                    for (int i = 0; i < amount - row; i++)
                        game.playersTables[0].floor.add(tileToAdd);
                }
                else
                    game.playersTables[0].pattern.addToRow(row, tileToAdd, amount);
                game.table.factories[number].remove(tileToAdd);

                for (int i = 0; i < 4; i++){
                    if (game.table.factories[number].getContents()[i] != null){
                        game.table.center.add(game.table.factories[number].getContents()[i]);
                        game.table.factories[number].getContents()[i] = null;
                        counter++;
                    }
                }
            }
            else {
                if (game.table.isPriorityTileInCenter()){
                    game.playersTables[0].setFirst();
                    game.table.center.remove(Tile.FIRSTTILE);
                }


                // Getting tile from center and counting amount
                while (game.table.center.contains(tileToAdd)){
                    System.out.println("XD");
                    amount++;
                    game.table.center.remove(tileToAdd);
                }
                // Getting tile from factory and adding it to patternLine or floor
                if (row < amount){
                    game.playersTables[0].pattern.addToRow(row,tileToAdd,row);
                    for (int i = 0; i < amount - row; i++)
                        game.playersTables[0].floor.add(tileToAdd);
                }
                else
                    game.playersTables[0].pattern.addToRow(row, tileToAdd, amount);
            }

            counter -= amount;
            // end of this phase (all factories and center is empty)
            if (counter == 0)
                isEnd = false;
        }


    }
}