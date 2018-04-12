package fr.iutlens.mmi.born2ride;

/**
 * Created by zakarya.mokhtari on 30/03/18.
 */

class Police extends Car{
    private final Car car;
    private float alpha;
    private float dist;
    private float vmax;

    public Police(int sprite_id, float x, float y, float direction, Car car) {
        super(sprite_id, x, y, direction);
        this.car = car;
        vmax = (float) (100*0.00005*1.7)*sprite.h;
        dist = 5f;
    }

    @Override
    public void update(Track track) {
        alpha = 1- vmax/dist;
        this.x = this.x*alpha + car.x*(1-alpha);
        this.y = this.y*alpha + car.y*(1-alpha);

        this.direction = (float) Math.toDegrees(Math.atan2(car.y-this.y,car.x-this.x))+90; // arc tengeante
    }

    public void setCommand(double pitch, double roll) {
        this.v = (float) (70*0.00005*1.7);


    this.dd = car.dd;
 //         this.dd = -(float) (0.1*(x-car.x));
/*
        if(x < car.x ){
            this.dd = (float) (0.06);
        }else {
            this.dd = -(float) (0.06);
        }
*/



    }
}
