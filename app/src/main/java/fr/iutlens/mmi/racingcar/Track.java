package fr.iutlens.mmi.racingcar;

import android.graphics.Canvas;
import android.util.Log;

import fr.iutlens.mmi.racingcar.utils.SpriteSheet;

/**
 * Created by dubois on 27/12/2017.
 */

public class Track {

    private int[][] data;
    private final String DIGITS ="0123456789ABCDEF";
    // 0123
    // 4567
    // 89AB
    // CDEF
    private final String[] def = {
            "140008000051",
            "140000000051",
            "140008000051",
            "140000000051",
            "140008000051",
            "140000000051",
            "140008000051",
            "140000000051",
            "140008000051",
            "140000000051",
            "140008000051",
            "140000000051"};


    /*



    */

    /*
            "111111111111",
            "1111111866A1",
            "186666A49B51",
            "14097BFD5451",
            "14051E77C451",
            "140511111451",
            "122211111451",
            "140511186D51",
            "1405186D97C1",
            "140F6D97C111",
            "1E7777C11111",
            "111111111111"

    */




    private final int char2hex(char c){
        return DIGITS.indexOf(c);
    }

    private SpriteSheet sprite;

    public Track(String[] data, int sprite_id){
        sprite = SpriteSheet.get(sprite_id);
        if (data == null) data = def;
        this.data = new int[data.length][data[0].length()];
        for(int i = 0; i < data.length ; ++i){
            for(int j= 0; j< data[i].length();++j){
                this.data[i][j] =char2hex(data[i].charAt(j));
            }
        }
    }


    public int get(float x, float y){
        int i = (int) x;
        int j = (int) y;


        if(i < 0 ){
            return -1;
        }

        if(i >= getSizeX() ){
            return -1;
        }

        while (j<0) j += getSizeY();
        while (j>= getSizeY()) j -= getSizeY();

        return get(i,j);


    }

    public int get(int j, int i){
        return data[i][j];
    }

    public int getSizeY(){
        return data.length;
    }
    public int getSizeX(){
        return data[0].length;
    }

    public int getWidth(){
        return getSizeX()*sprite.w;
    }
    public int getHeight(){
        return getSizeY()*sprite.h;
    }

    public int getTileWidth(){
        return sprite.w;
    }
    public int getTileHeight(){
        return sprite.h;
    }

    public void paint(Canvas canvas, Car car){
        int dx = 0; ///((int) (car.x/getSizeX()-2f))*getSizeX();
        int dy = ((int) (car.y/getSizeY()-2f))*getSizeY();

        for(int i = 0; i < data.length ; ++i) {
            for (int j = 0; j < data[i].length; ++j) {
                sprite.paint(canvas, data[i][j], (j+dx) * sprite.w, (i+dy) * sprite.h);
            }
        }
        dy= dy+getSizeY();
        for(int i = 0; i < data.length ; ++i) {
            for (int j = 0; j < data[i].length; ++j) {
                sprite.paint(canvas, data[i][j], (j+dx) * sprite.w, (i+dy) * sprite.h);
            }
        }
        dy= dy+getSizeY();
        for(int i = 0; i < data.length ; ++i) {
            for (int j = 0; j < data[i].length; ++j) {
                sprite.paint(canvas, data[i][j], (j+dx) * sprite.w, (i+dy) * sprite.h);
            }
        }
    }

    public boolean valide(float x, float y) {

        if(get(x, y) == 1){
            return false;
        }

        return true;
    }
}
