package education.firsthead.sinksite;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class SinkSiteTester {

    public static void main(String[] args) {
        int[][] newArray = new int[8][8];
        for (int i = 0; i < newArray.length; i++) {
            for (int i1 = 0; i1 < newArray.length; i1++) {
                newArray[i][i1] = 0;
            }
        }

        System.out.println("Starting game ...");

        List<Coordinate> busyCoordinates = new ArrayList<>();
        List<Coordinate> coordinatesOfSites = new ArrayList<>();

        AnySite chessCom = new AnySite("chessCom", busyCoordinates);
        AnySite leetCodeNet = new AnySite("leetCodeNet", busyCoordinates);
        AnySite liChessCom = new AnySite("liChessCom", busyCoordinates);

        coordinatesOfSites.addAll(chessCom.getCoordinates());
        coordinatesOfSites.addAll(leetCodeNet.getCoordinates());
        coordinatesOfSites.addAll(liChessCom.getCoordinates());

        int counter = 0;
        int siteNumber = 1;
        for (Coordinate coordinatesOfSite : coordinatesOfSites) {
            counter++;
            newArray[coordinatesOfSite.getVertical()][coordinatesOfSite.getHorizontal()] = siteNumber;
            if (counter == 3){
                siteNumber = siteNumber + 1;
                counter = 0;
            }
        }

        for (int[] ints : newArray) {
            for (int i1 = 0; i1 < newArray.length; i1++) {
                System.out.print(ints[i1] + " ");
            }
            System.out.println();
        }

            /*
            1. generateRandomCoordinate()
                //1.1 add him to busyCoordinates

            2. findCloseCoordinates(Coordinate coordinate)
                //2.1 add them to busyCoordinates
            3. findNotDiagonalCoordinates(List<Coordinate> coordinates) //closeCoordinates
            4. randomlyChooseFromCoordinates(List<Coordinate> coordinates)
                //4.1 add him to busyCoordinates

            5. findCloseCoordinates(Coordinate coordinate)
                //5.1 add them to busyCoordinates
            6. findNotDiagonalCoordinates(List<Coordinate> coordinates) //closeCoordinates
            7. randomlyChooseFromCoordinates(List<Coordinate> coordinates)
                //7.1 add him to busyCoordinates
         */


    }
}
