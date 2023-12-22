package models;

public class Dice {
    private int faces;

    public Dice(int noOfDiceFaces) {
        this.faces = noOfDiceFaces;
    }

    public int getFaces() {
        return faces;
    }

    public void setFaces(int faces) {
        this.faces = faces;
    }
}
