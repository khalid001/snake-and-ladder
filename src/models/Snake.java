package models;

public class Snake {

    private int head;

    public Snake(int head, int tail) {
        this.head = head;
        this.tail = tail;
    }

    private int tail;

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }
}
