package education.firsthead.sinksite.simple;

import java.util.Scanner;

public class Game {

    AnySite anySite;

    public Game(){

    }
    public Game(int locationLength){
        System.out.println("Game is started ...");
        System.out.println("Generating sites location ...");
        this.anySite = new AnySite(locationLength);
        gameProcess(locationLength);
    }

    private int move(Scanner in){
        System.out.println("Print your move: ");
        int number = Integer.parseInt(in.next());
        return number;
    }

    private void gameProcess(int locationLength){
        int hitsCounter = 0;
        Scanner in  = new Scanner(System.in);
        while (hitsCounter != locationLength){
            int playerMove = this.move(in);
            if (this.anySite.checkMove(this.anySite, playerMove, locationLength)){
                hitsCounter++;
                System.out.println("You are hurt the site!");
            } else {
                System.out.println("Please move again:");
            }
        }
        in.close();
        System.out.println("Site is wrecked!");
    }
}
