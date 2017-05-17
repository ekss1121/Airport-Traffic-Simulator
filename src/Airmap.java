/**
 * Created by Zliu on 2/12/17.
 */
public class Airmap {
    /*
    Atlanta ATL:  (33.641211, -84.427769)
    New York JFK: (40.641033, -73.778245)
    Boston BOS: (42.365621, -71.009517)
    Chicago ORD: (41.974402, -87.907321)
    Los Angeles LAX: (33.941410, -118.410485)
     */
    private static double lat[] = {33.64, 40.64, 42.37, 41.97, 33.94};
    private static double lon[] = {-84.43, -73.78, -71.01, -87.91, -118.41};
    private static final double R_EARTH = 6373;

    private double o_longitude;
    private double o_latitude;
    private double d_longitude;
    private double d_latitude;

    public Airmap (int origin, int desti){
        o_latitude = Math.toRadians(lat[origin-1]);
        o_longitude = Math.toRadians(lon[origin-1]);
        d_latitude = Math.toRadians(lat[desti-1]);
        d_longitude = Math.toRadians(lon[desti-1]);

    }

    public double getDistance(){
        double dlon = d_longitude - o_longitude;
        double dlat = d_latitude - o_latitude;

        double a = Math.pow(Math.sin(dlat/2.0),2.0) + Math.cos(o_latitude)
                * Math.cos(d_latitude)* Math.pow(Math.sin(dlon/2.0),2.0);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1.0-a));

        return R_EARTH * c;

    }
}
