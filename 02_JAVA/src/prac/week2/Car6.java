package prac.week2;

public class Car6 {
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if(speed<0){
            this.speed =0;
        } else{
            this.speed = speed;
        }
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        if(stop){
            setSpeed(0);
        }
        this.stop = stop;
    }

    private int speed;
    private boolean stop;


}
