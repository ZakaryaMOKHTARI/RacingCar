package fr.iutlens.mmi.racingcar;

/**
 * Created by zakarya.mokhtari on 30/03/18.
 */

class Police extends Car{
    private final Car car;

    public Police(int sprite_id, float x, float y, float direction, Car car) {
        super(sprite_id, x, y, direction);
        this.car = car;
    }

    public void setCommand(double pitch, double roll) {
        this.v = (float) (70*0.00005*1.7);



        // this.dd = -(float) (0.1*(x-car.x));

/*        if(x < car.x ){
            this.dd = (float) (0.006);
        }else {
            this.dd = -(float) (0.006);
        }*/




    }
}
