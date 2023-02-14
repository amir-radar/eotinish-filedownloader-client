package education.firsthead.sinksite;

import java.util.Objects;

public class Coordinate {

    public Coordinate(){
    }

    public Coordinate(int v, int h){
        this.setVertical(v);
        this.setHorizontal(h);
    }
    private int vertical;
    private int horizontal;

    public int getVertical() {
        return vertical;
    }

    public void setVertical(int vertical) {
        this.vertical = vertical;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(int horizontal) {
        this.horizontal = horizontal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return vertical == that.vertical && horizontal == that.horizontal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertical, horizontal);
    }
}
