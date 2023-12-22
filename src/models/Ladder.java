package models;

public class Ladder {

    private int startPosition;
    private int endPosition;

    public Ladder(int start, int end) {
        this.startPosition= start;
        this.endPosition = end;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }
}
