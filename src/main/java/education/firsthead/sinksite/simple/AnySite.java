package education.firsthead.sinksite.simple;

public class AnySite {
    private int[] coordinates;
    private boolean isALife;

    public AnySite(){

    }

    public AnySite(int locationLength){
        this.coordinates = generateLocation(locationLength);
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public boolean isALife() {
        return isALife;
    }

    public void setALife(boolean ALife) {
        isALife = ALife;
    }

    private int[] generateLocation(int locationLength){
        double biggestRandom = (10 - (double)locationLength)/10;
        int[] location = new int[locationLength];
        double r = Math.random();
        while (r >= biggestRandom){
            r = Math.random();
        }
        for (int i = 0; i < locationLength; i++) {
            location[i] = (int)(r*10) + i;
        }
        return location;
    }

    public boolean checkMove(AnySite site, int move, int locationLength){
        boolean isHit = false;
        for (int coordinate : site.getCoordinates()) {
            if (coordinate == move){
                isHit = true;
                System.out.println("You are hurt the site!");
                int[] newCoordinates = new int[locationLength - 1];
                for (int i = move; i < newCoordinates.length - 1; i++) {
                    newCoordinates[i] = site.getCoordinates()[i+1];
                }
                site.setCoordinates(newCoordinates);
            }
        }
        return isHit;
    }
}
