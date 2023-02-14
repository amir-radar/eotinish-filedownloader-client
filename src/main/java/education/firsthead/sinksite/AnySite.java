package education.firsthead.sinksite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnySite {
    private String name;
    private List<Coordinate> coordinates = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates.addAll(coordinates);
    }

    public AnySite(){

    }

    public AnySite(String name, List<Coordinate> busyCoordinates){
        this.name = name;

        //1
        System.out.println("Generate " + this.name + " coordinates ...");
        Coordinate coordinate = generateNotUsedRandomCoordinate(busyCoordinates);
        this.coordinates.add(coordinate);
        System.out.println("First coordinate " + coordinate.getVertical() + " " + coordinate.getHorizontal());
        busyCoordinates.addAll(findCloseCoordinates(coordinate));

        //2
        Coordinate coordinate2 = generateNextCoordinate(this.coordinates);
        this.coordinates.add(coordinate2);
        System.out.println("");
        System.out.println("Second coordinate " + coordinate2.getVertical() + " " + coordinate2.getHorizontal());
        busyCoordinates.addAll(findCloseCoordinates(coordinate2));

        //3
        Coordinate coordinate3 = generateNextCoordinate(this.coordinates);
        this.coordinates.add(coordinate3);
        System.out.println("");
        System.out.println("Third coordinate " + coordinate3.getVertical() + " " + coordinate3.getHorizontal());
        busyCoordinates.addAll(findCloseCoordinates(coordinate3));

        busyCoordinates.add(coordinate);
        busyCoordinates.add(coordinate2);
        busyCoordinates.add(coordinate3);
    }

    private Coordinate generateNotUsedRandomCoordinate(List<Coordinate> busyCoordinates){
        Coordinate coordinate = generateRandomCoordinate();
        while (busyCoordinates.contains(coordinate)){
            coordinate = generateRandomCoordinate();
        }
        return coordinate;
    }
    private Coordinate generateRandomCoordinate(){
        return new Coordinate((int)(Math.random()*8), (int)(Math.random()*8));
    }

    private Coordinate generateNextCoordinate(List<Coordinate> coordinates){
        Coordinate coordinate = coordinates.get(coordinates.size() - 1);
        List<Coordinate> closeCoordinates = findCloseCoordinates(coordinate);
        closeCoordinates.removeAll(coordinates);
        for (Coordinate nextPossibleCoordinate : closeCoordinates) {
            System.out.print("nextPossibleCoordinate: " + nextPossibleCoordinate.getVertical() + " " + nextPossibleCoordinate.getHorizontal() + "; ");
        }
        List<Coordinate> notDiagonalCoordinates = new ArrayList<>();
        for (Coordinate closeCoordinate : closeCoordinates) {
            if (isNotDiagonalCoordinate(coordinate, closeCoordinate)){
                notDiagonalCoordinates.add(closeCoordinate);
            }
        }
        return randomlyChooseOneOfCoordinates(notDiagonalCoordinates);
    }

    private List<Coordinate> findCloseCoordinates(Coordinate coordinate){
        List<Coordinate> closeCoordinates = new ArrayList<>();
        int[] possibleVerticalPositionsArray = getPossiblePositionsArray(coordinate.getVertical());
        int[] possibleHorizontalPositionsArray = getPossiblePositionsArray(coordinate.getHorizontal());
        for (int k : possibleVerticalPositionsArray) {
            for (int i : possibleHorizontalPositionsArray) {
                closeCoordinates.add(new Coordinate(k, i));
            }
        }
        return closeCoordinates;
    }

    private Coordinate randomlyChooseOneOfCoordinates(List<Coordinate> coordinates){
        return coordinates.get((int)(Math.random()*coordinates.size()));
    }

    private boolean isNotDiagonalCoordinate(Coordinate coordinate, Coordinate possibleCoordinate){
        return coordinate.getVertical() == possibleCoordinate.getVertical() || coordinate.getHorizontal() == possibleCoordinate.getHorizontal();
    }

    /**
     * Возможные позиции исходя от предыдущей позиции (Возвращает возможные значения по вертикали либо по горизонтали)
     */
    private int[] getPossiblePositionsArray(int previousPosition){
        int[] possiblePositionsArray = new int[getPossiblePositionsCount(previousPosition)];
        if (previousPosition == 0){
            for (int i = 0; i < possiblePositionsArray.length; i++) {
                possiblePositionsArray[i] = previousPosition + i;
            }
        } else if (previousPosition == 7) {
            for (int i = 0; i < possiblePositionsArray.length; i++) {
                possiblePositionsArray[i] = previousPosition - i;
            }
        } else {
            for (int i = 0; i < possiblePositionsArray.length; i++) {
                possiblePositionsArray[i] = previousPosition + i - 1;
            }
        }
        //System.out.println("AnySite.getPossiblePositionsArray: " + Arrays.toString(possiblePositionsArray));
        return possiblePositionsArray;
    }

    /**
     * Количество возможных значений позиции
     */
    private static int getPossiblePositionsCount(int position){
        if (position == 0 || position == 7){
            return 2;
        }
        return 3;
    }
}
