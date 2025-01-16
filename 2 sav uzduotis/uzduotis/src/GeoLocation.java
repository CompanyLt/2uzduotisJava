import java.util.ArrayList;
import java.util.Random;

public class GeoLocation {
private double lat;
private double lot;
private static int numLocation=0;



public GeoLocation(){
    Random random =new Random();
    lat = random.nextDouble(-90,90);
    lot = random.nextDouble(-90,90);
    numLocation = random.nextInt(0,10);

}



public GeoLocation(double lat,double lot){
    this.lat = lat;
    this.lot = lot;
    numLocation+=1;
}

public GeoLocation(GeoLocation copy){
    Random random = new Random();

    this.lot = Math.round((copy.lot + random.nextDouble(-0.1, 0.1)) * 1000000.0) / 1000000.0;
    this.lat = Math.round((copy.lat + random.nextDouble(-0.1, 0.1)) * 1000000.0) / 1000000.0;
}


public void print(){
    System.out.println("Lat:"+ lat+" Lot:"+lot);
}

public static double distance(GeoLocation location1, GeoLocation location2){
    final double EARTH_RADIUS = 6371.0;


    double lat1 = Math.toRadians(location1.lat);
    double lon1 = Math.toRadians(location1.lot);
    double lat2 = Math.toRadians(location2.lat);
    double lon2 = Math.toRadians(location2.lot);


    double dLat = lat2 - lat1;
    double dLon = lon2 - lon1;

    double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
            Math.cos(lat1) * Math.cos(lat2) *
                    Math.sin(dLon / 2) * Math.sin(dLon / 2);

    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));


    double distance = EARTH_RADIUS * c;


    return Math.floor(distance * 10.0) / 10.0;
}

    public static int GetLocationNum(){
        return numLocation;
    }

}
