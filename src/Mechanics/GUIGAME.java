package Mechanics;

import GUIForms.GUI;
import GUIForms.NumberOfPlayers;
import GUIForms.Workshop;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * The game class handles all other classes
 * and operates on their objects
 */
public class GUIGAME implements Serializable {
    /**
     * Number of players playing
     */
    public final int players;
    public static int first;
    static int numberOfPlayers;
    static boolean isEnd = false;
    static boolean isGameFinished = false;

    public static Client client;
    private static GUIGAME game;

    public static JPanel currentPanel;
    public static String rec1;

    public static ArrayList<Integer> que = new ArrayList<>();

    /**
     * Mechanics.Game mode
     * 1 - local
     * 0 - online
     */
    public final int mode;

    /**
     * Mechanics.Table - one instance per game
     */
    public final Table table;

    /**
     * Mechanics.Player class instances - each player is represented by one
     */
    public final Player[] playersTables;

    /**
     * Default constructor
     */
    public GUIGAME(int numberOfPlayers, int mode) throws Exception {
        playersTables = new Player[numberOfPlayers];
        players = numberOfPlayers;
        table = new Table(players);
        this.mode = mode;
    }

    /**
     * Checking whether the conditions for ending the first stage of the game are met
     *
     * @return true if first stage of game is finished
     */
    public boolean isFirstStageFinished() {
        int i;
        for (i = 0; i < table.factories.length; i++) {
            if (!table.factories[i].isEmpty())
                return false;
        }
        return table.center.isEmpty();
    }


    /**
     * Checking whether the conditions for ending the game are met
     *
     * @return true if game is finished
     */
    public boolean isGameFinished(int indexOfPlayer) {
        for (int i = 0; i < 5; i++) {
            if (playersTables[indexOfPlayer].wall.IsRowFull(i)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method responsible for saving the current game
     */
    public void save(String path) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path + ".bin"))) {
            outputStream.writeObject(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method responsible for loading the game
     */
    public static GUIGAME load(String path) {
        GUIGAME game;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path + ".bin"))) {
            game = (GUIGAME) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return game;
    }

    /**
     * Method for pointing out the winner
     *
     * @return The player who has won
     */
    public Player returnWinner() {
        Player temp = playersTables[0];
        for (Player player : playersTables) {
            if (temp.getPoints() < player.getPoints()) {
                temp = player;
            }
        }
        return temp;
    }

    /**
     * Method for getting the number of players
     *
     * @return Number of players
     */
    public int getNumberOfPlayers() {
        return players;
    }

    /**
     * Method to return the table of players
     *
     * @return Mechanics.Table of Mechanics.Player objects representing the players
     */
    public Player[] getPlayersTables() {
        return playersTables;
    }

    /**
     * Method for printing the factory
     */
    public void printFactory() {
        System.out.println();
        for (int i = 0; i < 2 * players + 1; i++) {
            Tile[] contents = table.factories[i].getContents();
            System.out.print((i + 1) + " Mechanics.Factory: ");
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

    /**
     * Method for checking if move is valid
     *
     * @param number       index of factory or center
     * @param row          index of row in pattern lines to which we want to add tile
     * @param playerNumber players number
     * @param tile         the colour of the tiles which we want to add
     * @return true if move is valid
     */
    public boolean isMoveValid(int number, int row, int playerNumber, Tile tile) {
        if (row == 5) {
            return true;
        }
        if (number == 9) {
            return (table.center.contains(tile) && ((playersTables[playerNumber].pattern.colours[row] == tile &&
                    playersTables[playerNumber].pattern.amounts[row] < (row + 1)) ||
                    playersTables[playerNumber].pattern.colours[row] == null));
        }
        return (playersTables[playerNumber].pattern.colours[row] == tile &&
                playersTables[playerNumber].pattern.amounts[row] < (row + 1)) ||
                playersTables[playerNumber].pattern.colours[row] == null;
    }

    /**
     * Method for finding the first player
     *
     * @return index of player who has the First tile or -1 if players do not have the First tile
     */
    public int findFirstPlayer() {
        for (int i = 0; i < players; i++) {
            if (playersTables[i].getFirst())
                return i;
        }
        return -1;
    }

    /**
     * Method for adding tiles to pattern line
     *
     * @param indexOfPlayer     index of current player
     * @param number            index of factory or center
     * @param tileToAdd         the colour of the tiles which we want to add
     * @param whereToPlaceTiles index of row in pattern lines to which we want to add tile
     */
    public void addTilesToPatternLines(int indexOfPlayer, Tile tileToAdd, int number, int whereToPlaceTiles) {
        if (whereToPlaceTiles == 5 && number != 9) {
            for (int i = 0; i < 4; i++) {
                if (table.factories[number].getContents()[i] == tileToAdd) {
                    if (playersTables[indexOfPlayer].floor.size() < 7)
                        playersTables[indexOfPlayer].floor.add(tileToAdd);
                    else
                        table.box.add(tileToAdd);
                } else
                    table.center.add(table.factories[number].getContents()[i]);
                table.factories[number].getContents()[i] = null;
            }
        } else if (whereToPlaceTiles == 5) {
            if (table.isPriorityTileInCenter()) {
                playersTables[indexOfPlayer].setFirst();
                playersTables[indexOfPlayer].floor.add(Tile.FIRSTTILE);
                table.center.remove(Tile.FIRSTTILE);
            }

            for (int i = 0; i < table.center.size(); i++) {
                if (table.center.get(i) == tileToAdd) {
                    if (playersTables[indexOfPlayer].floor.size() < 7)
                        playersTables[indexOfPlayer].floor.add(tileToAdd);
                    else
                        table.box.add(tileToAdd);
                }
            }
            while (table.center.contains(tileToAdd))
                table.center.remove(tileToAdd);
        } else if (whereToPlaceTiles < 5 && number != 9) {
            for (int i = 0; i < 4; i++) {
                if (table.factories[number].getContents()[i] == tileToAdd &&
                        !playersTables[indexOfPlayer].pattern.isRowFull(whereToPlaceTiles))
                    playersTables[indexOfPlayer].pattern.addToRow(whereToPlaceTiles, tileToAdd, 1);
                else if (table.factories[number].getContents()[i] == tileToAdd &&
                        playersTables[indexOfPlayer].pattern.isRowFull(whereToPlaceTiles)) {
                    if (playersTables[indexOfPlayer].floor.size() < 7)
                        playersTables[indexOfPlayer].floor.add(tileToAdd);
                    else
                        table.box.add(tileToAdd);
                } else
                    table.center.add(table.factories[number].getContents()[i]);
                table.factories[number].getContents()[i] = null;
            }
        } else if (whereToPlaceTiles < 5) {
            for (int i = 0; i < table.center.size(); i++) {
                if (table.isPriorityTileInCenter()) {
                    playersTables[indexOfPlayer].setFirst();
                    playersTables[indexOfPlayer].floor.add(Tile.FIRSTTILE);
                    table.center.remove(Tile.FIRSTTILE);
                }

                if (table.center.get(i) == tileToAdd &&
                        !playersTables[indexOfPlayer].pattern.isRowFull(whereToPlaceTiles)) {
                    playersTables[indexOfPlayer].pattern.addToRow(whereToPlaceTiles, tileToAdd, 1);
                } else if (table.center.get(i) == tileToAdd &&
                        playersTables[indexOfPlayer].pattern.isRowFull(whereToPlaceTiles)) {
                    if (playersTables[indexOfPlayer].floor.size() < 7)
                        playersTables[indexOfPlayer].floor.add(tileToAdd);
                    else
                        table.box.add(tileToAdd);
                }
            }
            while (table.center.contains(tileToAdd))
                table.center.remove(tileToAdd);
        }
    }

    /**
     * Method for adding tiles from pattern lines to wall
     *
     * @param indexOfPlayer index of current player
     */
    public void addToWall(int indexOfPlayer) {
        for (int i = 0; i < 5; i++) {
            if (playersTables[indexOfPlayer].pattern.isRowFull(i)) {
                playersTables[indexOfPlayer].sumPoints(playersTables[indexOfPlayer].wall.addTile(playersTables[indexOfPlayer].pattern.colours[i], i));
                for (int j = 1; j < playersTables[indexOfPlayer].pattern.amounts[i]; j++) {
                    table.box.add(playersTables[indexOfPlayer].pattern.colours[i]);
                }
                playersTables[indexOfPlayer].pattern.clearRow(i);
            }
        }
    }

    /**
     * Method for subtracting points for the tiles on the floor and clearing floor
     *
     * @param indexOfPlayer index of current player
     */
    public void subtractPointsFromFloor(int indexOfPlayer) {
        for (int i = 0; i < playersTables[indexOfPlayer].floor.size(); i++) {
            if (playersTables[indexOfPlayer].floor.get(i) != null) {
                if (i == 0 || i == 1)
                    playersTables[indexOfPlayer].sumPoints(-1);
                else if (i < 5) {
                    playersTables[indexOfPlayer].sumPoints(-2);
                } else {
                    playersTables[indexOfPlayer].sumPoints(-3);
                }
            } else
                break;
        }
        playersTables[indexOfPlayer].clearFloor();
    }

    public static void localGameStart() throws Exception {
        numberOfPlayers = NumberOfPlayers.getClickedNumberOfPlayers();
        game = new GUIGAME(numberOfPlayers, 1);
        int index = 0;
        for (String x : GUI.nameList) {
            game.playersTables[index] = new Player(x);
            index++;
        }

        ArrayList<Integer> que = new ArrayList<>();
        // First starting player is chosen randomly
        Random rand = new Random();

        first = rand.nextInt(numberOfPlayers);


        localGameMainLoop();
    }

    public static void localGameNextTurn(int index) throws Exception {
        if(!isEnd){
            GUI.currentPlayerIndex = index;
            //wywal do GUI na guziki w bordzie
            //localGamePhase1(que.get(index));
            //isEnd = game.isFirstStageFinished();
        }
        if(isEnd) {
            first = game.findFirstPlayer();
            que.clear();
            localGameEmptyFactory();
        }
    }


    public static void localGameMainLoop() throws Exception {
        if (!isGameFinished) {
            for (int i = 0; i < numberOfPlayers; i++)
                que.add((first + i) % numberOfPlayers);
            //TODO podświetl pierwszego gracza?
            isEnd = false;
            localGameNextTurn(0);
        }
    }

    public static void localGameEmptyFactory() throws Exception {
        for (int i = 0; i < numberOfPlayers; i++) {
            game.addToWall(i);
            game.subtractPointsFromFloor(i);
        }

        game.table.refillFactories();

        for (int i = 0; i < numberOfPlayers; i++)
            if (game.isGameFinished(i))
                isGameFinished = true;

        localGameMainLoop();
    }


    public static void localGamePhase1(int order) throws Exception {
                //System.out.println(game.table.bag.size());
                System.out.println("Mechanics.Player : " + (order+1));
                int number;
                String tiles;
                int whereToPlaceTiles;
                Tile tileToAdd;

                // READING FROM KEYBOARD
                do{
                    game.printFactory();
                    System.out.println();
                    System.out.println();

                    //TODO Tura gracza wewnątrz GUI

                    System.out.println("Choose factory or center from which you want to take tiles");
                    //WorkshopID
                    //number = reader.nextInt() - 1;
                    Workshop workshop = new Workshop();
                    number = workshop.getWorkshopid();

                    System.out.println("Choose tile which you want to take from the factory");
                    //tile button -> który przycisk
                    //tiles = reader.next();

                    System.out.println("Choose where you want to add the tiles, 1-5 for pattern lines, 6 for floor");
                    //Sprytna metoda na rząd linii
                    //whereToPlaceTiles = reader.nextInt() - 1;
                    whereToPlaceTiles = 3 - 1;

                    tileToAdd = workshop.takenTile;


                    if(!game.table.isColourInFactory(tileToAdd, number) || !game.isMoveValid(number, whereToPlaceTiles, order, tileToAdd))
                        System.out.println("Chosen tile doesn't exist in this factory, please choose again");
                } while (!game.table.isColourInFactory(tileToAdd, number) || !game.isMoveValid(number, whereToPlaceTiles, order, tileToAdd));
                // END

                game.addTilesToPatternLines(order, tileToAdd, number, whereToPlaceTiles);
                game.playersTables[order].pattern.printPatternLine();
                game.playersTables[order].printFloor();




    }

    private static void localGame() throws Exception {

        NumberOfPlayers numberOfPlayersForm = new NumberOfPlayers();
        GUI.frame.add(numberOfPlayersForm.getPLAYERS());
        numberOfPlayersForm.getPLAYERS().setVisible(true);
        currentPanel.setVisible(false);

        /*
        while(!isGameFinished){
            for(int i = 0; i<numberOfPlayers; i++)
                que.add((first+i)%numberOfPlayers);

            isEnd = false;
            while(!isEnd) {
                for(int order: que) {
                    //System.out.println(game.table.bag.size());
                    System.out.println("Mechanics.Player : " + (order+1));
                    int number;
                    String tiles;
                    int whereToPlaceTiles;
                    Tile tileToAdd;




                    isEnd = game.isFirstStageFinished();
                    if(isEnd) {
                        first = game.findFirstPlayer();
                        que.clear();
                        break;
                    }
                }
            }


            System.out.println(game.table.bag);
            game.playersTables[0].wall.printWall();
            game.table.refillFactories();

            for(int i=0; i<numberOfPlayers; i++)
                if(game.isGameFinished(i))
                    isGameFinished = true;
        }
         */
    }

    public static void choosePlayerNumber(int number){
        numberOfPlayers = number;
        client.sendData(String.valueOf(numberOfPlayers));
    }



    private static void onlineGame() throws Exception {

        //SOCKET
        client = new Client("localhost", 12345);
        client.start();

        rec1 = client.receiveData();
        //System.out.println(rec1);
        if(rec1.charAt(0) == '0') {
            NumberOfPlayers numberOfPlayers = new NumberOfPlayers();
            GUI.frame.add(numberOfPlayers.getPLAYERS());
            numberOfPlayers.getPLAYERS().setVisible(true);
            currentPanel.setVisible(false);
        } else {
            numberOfPlayers = Integer.parseInt(rec1.substring(1,2));
            //TODO przekieruj do czekania na gre (BOARD z napisem Waiting)
            client.sendData("waiting");
        }/*
        int id = Integer.parseInt(rec1.substring(0,1));
        System.out.println("Players: " + (id + 1) + "/" + numberOfPlayers);
        System.out.println("CONNECTED TO SERVER, WAITING FOR PLAYERS");
        for(int i = id+1; i<numberOfPlayers-1; i++) {
            while(!Objects.equals(client.receiveData(), String.valueOf(i))){Thread.onSpinWait();}
            System.out.println("Players: " + (i + 1) + "/" + numberOfPlayers);
        }
        while(!Objects.equals(client.receiveData(), "START")){Thread.onSpinWait();}
        System.out.println("Players: " + numberOfPlayers + "/" + numberOfPlayers);
        System.out.println("STARTED");
        // SOCKET

        // setup Mechanics.Table and factories
        GUIGAME game = new GUIGAME(numberOfPlayers, 2);
        ArrayList<Integer> que = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++){
            String playerName = "playerName";
            game.playersTables[i] = new Player(playerName);
        }
        int first = 0;

        while(!isGameFinished){
            for(int i = 0; i<numberOfPlayers; i++)
                que.add((first+i)%numberOfPlayers);

            while(!isEnd) {
                for(int order: que) {
                    //System.out.println(game.table.bag.size());
                    System.out.println("Mechanics.Player : " + (order+1));
                    int number;
                    String tiles;
                    int whereToPlaceTiles;
                    Tile tileToAdd;

                    if(order == id) {
                        game.playersTables[order].pattern.printPatternLine();
                        // READING FROM KEYBOARD
                        do {
                            game.printFactory();
                            System.out.println();
                            System.out.println();

                            System.out.println("Choose factory or center from which you want to take tiles");
                            number = reader.nextInt() - 1;

                            System.out.println("Choose tile which you want to take from the factory");
                            tiles = reader.next();

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
                            if (!game.table.isColourInFactory(tileToAdd, number) || !game.isMoveValid(number, whereToPlaceTiles, order, tileToAdd))
                                System.out.println("Chosen tile doesn't exist in this factory, please choose again");
                        } while (!game.table.isColourInFactory(tileToAdd, number) || !game.isMoveValid(number, whereToPlaceTiles, order, tileToAdd));

                        client.sendData(String.valueOf(order) + number + whereToPlaceTiles + tiles);
                        // END
                    } else {
                        String temp = client.receiveData();
                        while(temp == null) temp = client.receiveData();
                        number = Integer.parseInt(temp.substring(1,2));
                        whereToPlaceTiles = Integer.parseInt(temp.substring(2,3));
                        tiles = temp.substring(3);
                        tileToAdd = switch (tiles.toUpperCase()) {
                            case "BLACK" -> Tile.BLACK;
                            case "WHITE" -> Tile.WHITE;
                            case "BLUE" -> Tile.BLUE;
                            case "YELLOW" -> Tile.YELLOW;
                            case "RED" -> Tile.RED;
                            default -> null;
                        };
                    }
                    game.addTilesToPatternLines(order, tileToAdd, number, whereToPlaceTiles);
                    game.playersTables[order].pattern.printPatternLine();
                    game.playersTables[order].printFloor();

                    isEnd = game.isFirstStageFinished();
                    if(isEnd) {
                        first = game.findFirstPlayer();
                        que.clear();
                        break;
                    }
                }
            }
            for(int i=0; i<numberOfPlayers; i++){
                game.addToWall(i);
                game.subtractPointsFromFloor(i);
            }

            System.out.println(game.table.bag);
            game.playersTables[0].wall.printWall();
            game.table.refillFactories();

            for(int i=0; i<numberOfPlayers; i++)
                if(game.isGameFinished(i))
                    isGameFinished = true;
        }
    */
        client.end();
    }

    public static void mainGame(int mode) throws Exception {
        if(mode == 1) { // SINGLE PLAYER
            localGame();
        } else { // MULTIPLAYER
            onlineGame();
        }

        // SAVING AND LOADING GAME
        // game.save("test");
        // Mechanics.Game g = Mechanics.Game.load("test");
    }

    public void createPlayers(){
        int i = 0;
        for(String x: GUI.nameList){

        }
    }

}