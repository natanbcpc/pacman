public enum SpriteString {
    BLOCK ('#'),
    DOOR ('d'),
    PACMAN ('c'),
    GHOST_RED ('r'),
    GHOST_BLUE ('b'),
    GHOST_PINK ('p'),
    GHOST_ORANGE ('o'),
    BALL ('.'),
    SPECIAL_BALL('*'),
    EMPTY('_');


    private final char symbol;

    SpriteString(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
