package games;

/**
 * Created by lchan39 on 7/31/14.
 */
public class AnalogClockAngle {
    public static void main(String[] args) {
        int h=6;
        int m=50;

        //The hour hand moves at the rate of 0.5 degrees per minute
        //The minute hand moves at the rate of of 6 degrees per minute

        double hAngle = 0.5D * ((h*60)+m);
        double mAngle = 6 * m;

        double angle = Math.abs(hAngle - mAngle)%360;
        System.out.println(angle);
    }

}
