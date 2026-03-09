import java.util.*;

public class ParkingLot {

    static String[] table = new String[10];

    static int hash(String plate){
        return Math.abs(plate.hashCode()) % table.length;
    }

    static void park(String plate){

        int i = hash(plate);

        while(table[i]!=null)
            i = (i+1)%table.length;

        table[i] = plate;

        System.out.println("Parked at spot "+i);
    }

    public static void main(String[] args){

        park("ABC123");
        park("XYZ999");
    }
}