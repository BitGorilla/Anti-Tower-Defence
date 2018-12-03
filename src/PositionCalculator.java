import javafx.geometry.Pos;

import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.Collections;

public class PositionCalculator {
    private int windowDimension;
    private int tileDemension;
    private int tilePosWidth;
    private ArrayList<Position> pathPositionList;
    private int i = 0;
    private ArrayList<String> tiles;

    public PositionCalculator(int windowDimension, int tileDemension,
                              ArrayList<String> tiles){
        this.tiles = tiles;
        this.windowDimension = windowDimension;
        this.tileDemension = tileDemension;
        tilePosWidth = (int)Math.ceil(windowDimension/tileDemension);
    }

    public boolean hasNext(){
        if (i<tiles.size()){
            i++;
            return true;
        }
        return false;
    }

    public void next(){
        if(tiles.get(i).equals("empty")){
            //if turret, create turret tile
            //else create empty tile
        }
        else{
            calcPos(tiles.get(i));
        }
        //create empty tile
    }

    private void calcPos(String path) {

        if (path.equals("north-east") || path.equals("east-north")) {
            for (int j = 0; j < tilePosWidth/2; j++) {
                pathPositionList.add(new Position(tilePosWidth / 2, j));
            }
            for (int j = 1; j < tilePosWidth/2; j++) {
                pathPositionList.add(new Position((tilePosWidth / 2)+j,
                        tilePosWidth / 2));
            }

            if (path.equals("east-north")){
                Collections.reverse(pathPositionList);
            }
        }
        else if(path.equals("north-west") || path.equals("west-north")){
            for (int j = 0; j < tilePosWidth/2; j++) {
                pathPositionList.add(new Position(tilePosWidth/2,
                        j));
            }
            for (int j = 1; j < tilePosWidth/2; j++) {
                pathPositionList.add(new Position((tilePosWidth/2)-j,
                        tilePosWidth/2));
            }

            if (path.equals("west-north")){
                Collections.reverse(pathPositionList);
            }
        }
        else if(path.equals("west-south") || path.equals("south-west")){
            for (int j = 0; j < tilePosWidth/2; j++) {
                pathPositionList.add(new Position(j, tilePosWidth/2));
            }
            for (int j = 1; j < tilePosWidth/2; j++) {
                pathPositionList.add(new Position(tilePosWidth / 2,
                        (tilePosWidth / 2) + j));
            }

            if (path.equals("south-west")){
                Collections.reverse(pathPositionList);
            }
        }
        else if(path.equals("east-south") || path.equals("south-east")){
            for (int j = 0; j < tilePosWidth/2; j++) {
                pathPositionList.add(new Position(tilePosWidth-j,
                        tilePosWidth/2));
            }
            for (int j = 1; j < tilePosWidth/2; j++) {
                pathPositionList.add(new Position(tilePosWidth / 2,
                        (tilePosWidth / 2) + j));
            }

            if (path.equals("south-east")){
                Collections.reverse(pathPositionList);
            }
        }
        else if(path.equals("north-south") || path.equals("south-north")){
            for (int j = 0; j < tilePosWidth; j++) {
                pathPositionList.add(new Position(tilePosWidth/2, j));
            }

            if (path.equals("south-north")) {
                Collections.reverse(pathPositionList);
            }
        }
        else if(path.equals("west-east") || path.equals("east-west")){
            for (int j = 0; j < tilePosWidth; j++) {
                pathPositionList.add(new Position(j,tilePosWidth/2));
            }

            if (path.equals("east-west")){
                Collections.reverse(pathPositionList);
            }
        }

        finalizeCalc();
    }

    private void finalizeCalc(){

        int temp = 0;
        for (int j = 0; j<tileDemension; j++){
            for (int k = 0; k<tileDemension; j++){
                int x = pathPositionList.get(temp).getX();
                int y = pathPositionList.get(temp).getY();

                x = x + j*tilePosWidth;
                y = y + k*tilePosWidth;

                pathPositionList.get(temp).setX(x);
                pathPositionList.get(temp).setY(y);

                temp++;
            }
        }
    }

}
