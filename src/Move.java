public class Move {
    int player;
    Tile tile;
    String fromWhere;
    int toWhere;

    public Move(int player, Tile tile, String fromWhere, int toWhere) {
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

    public String getFromWhere() {
        return fromWhere;
    }

    public int getToWhere() {
        return toWhere;
    }

    public static boolean isMoveValid(Game game, Move move) {;
        return game.playersTables[move.getPlayer()].pattern.colours[move.getToWhere()] == move.getTile() &&
                game.playersTables[move.getPlayer()].pattern.colours[move.getToWhere()] != null;
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
