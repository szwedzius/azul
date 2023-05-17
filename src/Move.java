public class Move {
    int player;
    Tile tile;
    int fromWhere;
    int toWhere;

    public Move(int player, Tile tile, int fromWhere, int toWhere) {
        this.player = player;
        this.tile = tile;
        this.fromWhere = fromWhere;
        this.toWhere = toWhere;
    }

    public int getPlayer() {
        return player;
    }

    public Tile getTile() {
        return tile;
    }

    public int getFromWhere() {
        return fromWhere;
    }

    public int getToWhere() {
        return toWhere;
    }

    public boolean isMoveValid(Game game) {
        for ( int i = 0; i < 4; i++) {
            if ( game.table.factories[fromWhere].getContents()[i] == tile) {
                return game.playersTables[player].pattern.colours[toWhere] == tile ||
                        game.playersTables[player].pattern.colours[toWhere] == null;
            }
        }
        return false;
    }

    public static boolean ifGoToFloor(Game game, Tile tile, int player) {

        for (int i = 0 ; i < 5; i++){
            if (game.playersTables[player].pattern.colours[i] == tile ||
                    game.playersTables[player].pattern.colours[i] == null){
                return false;
            }
        }
        return true;
    }
}
