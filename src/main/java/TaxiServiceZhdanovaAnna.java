import java.util.*;

public class TaxiServiceZhdanovaAnna {

    public static class Car {

        int quantityFuel = 5;
        //when performing the task, we used the business logic that at the start we always
        // have the same specified amount of fuel (otherwise,
        // we can reuse the result of the 'refill' method)

        public void drive (String[] destination) {
            for (int i = 0; i<destination.length; i++){
                int needFuel = destination[i].length();
                if (quantityFuel - needFuel >= 0) {
                    System.out.println("Я еду в город " + destination[i]);
                    quantityFuel = quantityFuel - needFuel;
                } else {
                    int lackOfFuel = (needFuel - quantityFuel);
                    System.out.println("У меня не хватает " + lackOfFuel + " литров топлива до города " + destination[i]);
                    break;
                }
            }
        }

        public void refill(int refillFuel){
            quantityFuel+=refillFuel;
            System.out.println("Заправлено "+refillFuel + ". " + "В баке " + quantityFuel + ". ");
        }
    }



    public static void main(String[] args) {
        TaxiServiceZhdanovaAnna.Car car = new TaxiServiceZhdanovaAnna.Car();
        TaxiServiceZhdanovaAnna.DestinationCities destinationCities = new TaxiServiceZhdanovaAnna.DestinationCities();
        String[] selectedCity = destinationCities.getRandomCity();
        car.drive(selectedCity);
        car.refill(50);
    }

    public static class DestinationCities {
        public String[] getRandomCity(){
            String[] Cities = {"Brest", "Gomel", "Grodno", "Minsk", "Mogilev", "Vitebsk"};
            List<String> transformCities = Arrays.asList(Cities);
            Collections.shuffle(transformCities);
            transformCities.toArray(Cities);
            int rnd = new Random().nextInt((Cities.length-1)+1)+1; //the solution is taken with https://mkyong.com/java/java-generate-random-integers-in-a-range/ in order to avoid an empty array
            String[] setCities = new String[rnd];
            for (int i=0; i<rnd; i++) {
                setCities[i]=Cities[i];
                }
            //the task was initially performed based on the business logic that cities can be repeated
            //for (int i=0; i<rnd; i++) {
                //int rndCity = new Random().nextInt(Cities.length);
                //setCities[i]=Cities[rndCity];
            //}
            return setCities;
        }

    }

}
