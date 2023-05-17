public class Move {
    String player;
    Tile tile;
    String fromWhere;
    String toWhere;

    public Move(String player, Tile tile, String fromWhere, String toWhere) {
        this.player = player;
        this.tile = tile;
        this.fromWhere = fromWhere;
        this.toWhere = toWhere;
    }

    public String getPlayer() {
        return player;
    }

    public Tile getTile() {
        return tile;
    }

    public String getFromWhere() {
        return fromWhere;
    }

    public String getToWhere() {
        return toWhere;
    }

    public static boolean isMoveValid(Game game, Move move) {
        return false; // TODO
    }

    public static boolean ifGoToFloor(Game game, Tile tile, String player) {
        return false; // TODO
    }
}
