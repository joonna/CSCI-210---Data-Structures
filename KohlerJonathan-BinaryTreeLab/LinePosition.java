/**
 * This class is used to store the words of the getty address by its line and position.
 * @author Jonathan Kohler
 * @version 8/14/19
 */
public class LinePosition {
    private int line;
    private int position;

    /**
     * This is the default constructor for LinePosition.
     */
    public LinePosition() {
        this.line = 0;
        this.position = 0;
    }

    /**
     * This is the constructor to create a LinePosition object.
     * @param line
     * @param position
     */
    public LinePosition(int line, int position) {
        this.line = line;
        this.position = position;
    }

    /**
     * This method returns the line of the word.
     * @return line
     */
    public int getLine() {
        return line;
    }

    /**
     * This method returns the position of the word.
     * @return position
     */
    public int getPosition() {
        return position;
    }
}