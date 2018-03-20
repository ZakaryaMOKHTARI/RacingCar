package fr.iutlens.mmi.racingcar;

import android.graphics.Canvas;

import fr.iutlens.mmi.racingcar.utils.SpriteSheet;

/**
 *
 *
 * Created by dubois on 27/12/2017.
 */

public class Car {

    private SpriteSheet sprite;

    float x,y,direction;
    float v,dd;

    public Car(int sprite_id, float x, float y, float direction){
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.sprite = SpriteSheet.get(sprite_id);
        this.v = 0;
        this.dd = 0;
    }

    public void paint(Canvas canvas, int unit_x, int unit_y){
        canvas.save();
        canvas.translate(x*unit_x,y*unit_y);
        canvas.scale(2,2);
        canvas.rotate(direction);
        int model = 0;
        if (dd < -5) model = 1;
        if (dd > 5) model = 2;
        sprite.paint(canvas,model,-sprite.w/2 , -sprite.h/2);
        canvas.restore();
    }


    public void update(Track track) {

        if(!track.valide(x, y)){ // je peux le remplacer par if get == 1

            v = v/2;



        }


        direction += dd*v*sprite.h;
       // acceleration =

        float oldx =x;
        x += (float) ( v*sprite.h*Math.cos(Math.toRadians(direction-90)));
        if (x<0.5 || x >= track.getSizeX()-0.5) {
            x = oldx;
        }
        y += (float) ( v*sprite.h*Math.sin(Math.toRadians(direction-90)));
    }

    public double bound(double value, double max){
        if (value >= max) value = max;
        if (value <= -max) value = -max;
        return value;
    }

    public double rescale(double value, double max, double bound){
        value = bound(value, bound);
        value = value * max/ bound;
        return value;
    }

    public void setCommand(double pitch, double roll) {


        pitch = rescale(pitch,100,5); // le pitch max représente la vitesse de la voiture au départ (150 de base)
        roll = rescale(roll,40,50);

        this.v = (float) (pitch*0.00005*1.7);

        this.dd = (float) (roll*0.6);

    }



//    System.currentTimeMillis();

}
