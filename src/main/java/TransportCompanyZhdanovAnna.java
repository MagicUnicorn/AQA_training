import java.util.ArrayList;
import java.util.List;

public class TransportCompanyZhdanovAnna {

    public static void main(String[] args) {
        calcProfit();
    }

    public static void calcProfit() {
        List<TransportTemplate> transports = initTransport();
        double totalProfit = 0.0;
        for (int i = 0; i < transports.size(); i++) {
            totalProfit += transports.get(i).getBuyoutSum();
        }
        System.out.println("Total profit from all sells: " + totalProfit);
    }

    public static List<TransportTemplate> initTransport() {
        List<TransportTemplate> transports = new ArrayList<>();
        List<TransportTemplate> buses = initBuses();
        List<TransportTemplate> airplanes = initAirplanes();
        List<TransportTemplate> ferryBoats = initFerryBoat();
        transports.addAll(buses);
        transports.addAll(airplanes);
        transports.addAll(ferryBoats);
        return transports;
    }


    public static List<TransportCompanyZhdanovAnna.TransportTemplate> initBuses() {
        TransportCompanyZhdanovAnna.TransportTemplate bus = new TransportCompanyZhdanovAnna.Bus(23, 56, 13, 34.0, 56.0, 17.0);
        bus.buyoutLuggageSpace(1, 13, 14, 15, 20);
        bus.buyoutPlace(2);
        bus.buyoutVipPlace(1);
        List<TransportTemplate> buses = new ArrayList<>();
        buses.add(bus);
        // add another buses if need
        return buses;
    }

    public static List<TransportCompanyZhdanovAnna.TransportTemplate> initAirplanes() {
        TransportCompanyZhdanovAnna.TransportTemplate airplane = new TransportCompanyZhdanovAnna.Airplane(23, 400, 30, 134.0, 500.0, 17.0);
        airplane.setLuggageLimit(55.0, 20.0, 30.5, 20.0);
        airplane.buyoutLuggageSpace(1, 13, 14, 15, 20);
        airplane.buyoutPlace(200);
        airplane.buyoutVipPlace(23);
        List<TransportTemplate> airplanes = new ArrayList<>();
        airplanes.add(airplane);
        // add another airplanes if need
        return airplanes;
    }

    public static List<TransportCompanyZhdanovAnna.TransportTemplate> initFerryBoat() {
        TransportCompanyZhdanovAnna.TransportTemplate ferryBoat = new TransportCompanyZhdanovAnna.FerryBoat(23, 56, 13, 34.0, 56.0, 17.0);
        ferryBoat.buyoutLuggageSpace(1, 13, 14, 15, 20);
        ferryBoat.buyoutPlace(50);
        ferryBoat.buyoutVipPlace(10);
        List<TransportTemplate> ferryBoats = new ArrayList<>();
        ferryBoats.add(ferryBoat);
        // add another ferry boats if need
        return ferryBoats;
    }

    public static class TransportTemplate {

        int limitPlaces;
        int limitVipPlaces;
        int limitLuggageSpaces;
        double costPlace;
        double costVipPlace;
        double costLuggage;
        List<Place> places = new ArrayList<>();
        List<Place> vipPlaces = new ArrayList<>();
        List<Luggage> luggageSpaces = new ArrayList<>();
        double limitHeight = 53.0;
        double limitDepth = 23.0;
        double limitWidth = 40.0;
        double limitWeight = 25.0;
        TransportTemplate(int numberLuggageSpaces, int numberPlaces, int numberVipPlaces, double costPlace, double costVipPlace, double costLuggage) {
            this.limitLuggageSpaces = numberLuggageSpaces;
            this.limitPlaces = numberPlaces;
            this.limitVipPlaces = numberVipPlaces;
            this.costPlace = costPlace;
            this.costVipPlace = costVipPlace;
            this.costLuggage = costLuggage;
        }

        public void setLuggageLimit(double height, double depth, double width, double weight) {
            this.limitHeight = height;
            this.limitDepth = depth;
            this.limitWidth = width;
            this.limitWeight = weight;
        }

        public boolean checkLuggageLimit(double height, double depth, double width, double weight) {

            if (height > limitHeight) {
                System.out.println("Wrong height");
                return false;
            }
            if (depth > limitDepth) {
                System.out.println("Wrong depth");
                return false;
            }
            if (width > limitWidth) {
                System.out.println("Wrong width");
                return false;
            }
            if (weight > limitWeight) {
                System.out.println("Wrong weight");
                return false;
            }
            return true;
        }

        public void buyoutLuggageSpace(int count, double height, double depth, double width, double weight) {
            if (limitLuggageSpaces - luggageSpaces.size() >= count) {
                for (int i = 0; i < count; i++) {
                    if (!checkLuggageLimit(height, depth, width, weight)) {
                        continue;
                    }
                    TransportCompanyZhdanovAnna.TransportTemplate.Luggage newLuggage = new Luggage(costLuggage, height, depth, width, weight);
                    luggageSpaces.add(newLuggage);
                }
            } else {
                System.out.println("You can't buy more luggage spaces");
            }
        }

        public void buyoutPlace(int count) {
            if (limitPlaces - places.size() >= count) {
                for (int i = 0; i < count; i++) {
                    TransportCompanyZhdanovAnna.TransportTemplate.Place newPlace = new Place(costPlace);
                    places.add(newPlace);
                }
            } else {
                System.out.println("You can't buy more places");
            }
        }

        public void buyoutVipPlace(int count) {
            if (limitVipPlaces - vipPlaces.size() >= count) {
                for (int i = 0; i < count; i++) {
                    TransportCompanyZhdanovAnna.TransportTemplate.Place newVipPlace = new Place(costVipPlace);
                    vipPlaces.add(newVipPlace);
                }
            } else {
                System.out.println("You can't buy more vip places");
            }
        }

        public double getBuyoutSum() {
            int commonWight = 0;
            double sum = 0.0;
            for (int i = 0; i < luggageSpaces.size(); i++) {
                commonWight += luggageSpaces.get(i).weight;
                sum += commonWight * costLuggage;
            }
            sum += places.size() * costPlace + vipPlaces.size() * costVipPlace;
            return sum;
        }

        private static class Luggage {
            double cost;
            double height;
            double depth;
            double width;
            double weight;

            Luggage(double cost, double height, double depth, double width, double weight) {
                this.cost = cost;
                this.height = height;
                this.weight = weight;
                this.depth = depth;
                this.width = width;
            }

            public double getWeight() {
                return this.weight;
            }
        }

        private static class Place {
            double cost;

            Place(double defaultCost) {
                this.cost = defaultCost;
            }

        }
    }

    public static class Bus extends TransportTemplate {

        Bus(int numberLuggageSpaces, int numberPlaces, int numberVipPlaces, double costPlace, double costVipPlace, double costLuggage) {
            super(numberLuggageSpaces, numberPlaces, numberVipPlaces, costPlace, costVipPlace, costLuggage);
        }
    }

    public static class Airplane extends TransportTemplate {

        Airplane(int numberLuggageSpaces, int numberPlaces, int numberVipPlaces, double costPlace, double costVipPlace, double costLuggage) {
            super(numberLuggageSpaces, numberPlaces, numberVipPlaces, costPlace, costVipPlace, costLuggage);
        }
    }

    public static class FerryBoat extends TransportTemplate {

        FerryBoat(int numberLuggageSpaces, int numberPlaces, int numberVipPlaces, double costPlace, double costVipPlace, double costLuggage) {
            super(numberLuggageSpaces, numberPlaces, numberVipPlaces, costPlace, costVipPlace, costLuggage);
        }
    }
}
