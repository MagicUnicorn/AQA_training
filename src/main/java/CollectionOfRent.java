import java.util.*;

public class CollectionOfRent {

    public static void main(String[] args) {
        // initiate street
        CollectionOfRent.Cottage cottage = new Cottage().setLimit(1);
        cottage.addFlat(13, 143.6);
        CollectionOfRent.Townhouse townHouse = new Townhouse().setLimit(3);
        townHouse.addFlat(2, 100.6);
        townHouse.addFlat(3, 91.8);
        townHouse.addFlat(4, 230.5);
        int limitApartmentHouse = 200;
        CollectionOfRent.ApartmentHouse apartmentHouse = new ApartmentHouse().setLimit(limitApartmentHouse);
        for (int i = 0; i < limitApartmentHouse; ++i){
            apartmentHouse.addFlat(3, 65.3);
        }

        // calc rent payments
        List<HouseTemplate.Flat> cottageFlats = cottage.getFlats();
        System.out.println("cottage payments: " + cottageFlats.get(0).getSquare()*cottageFlats.get(0).getNumberOfResidents()*10);
        System.out.println("-----------------------------");
        double townHouseTotalRent = 0.0;
        List<HouseTemplate.Flat> townHouseFlats = townHouse.getFlats();
        for (int i = 0; i < townHouseFlats.size(); ++i) {
            double townHouseSquare = townHouseFlats.get(i).getSquare();
            int townHouseMembers = townHouseFlats.get(i).getNumberOfResidents();
            double townHouseRent = townHouseSquare*townHouseMembers*10;
            System.out.println("Townhouse flat number " + (i+1) + " have rent payment : " + townHouseRent);
            townHouseTotalRent += townHouseRent;
        }
        System.out.println("Total townhouse flat rent payment :" + townHouseTotalRent);
        System.out.println("-----------------------------");
        double apartmentTotalRent = 0.0;
        List<HouseTemplate.Flat> apartmentHouseFlats = apartmentHouse.getFlats();
        for (int i = 0; i < apartmentHouseFlats.size(); ++i) {
            double apartmentHouseSquare = apartmentHouseFlats.get(i).getSquare();
            int apartmentHouseMembers = apartmentHouseFlats.get(i).getNumberOfResidents();
            double apartmentHouseRent = apartmentHouseSquare*apartmentHouseMembers*10;
            System.out.println("ApartmentHouse flat number " + (i+1) + " have rent payment : " + apartmentHouseRent);
            apartmentTotalRent += apartmentHouseRent;
        }
        System.out.println("Total apartmentHouse flat rent payment :" + apartmentTotalRent);

    }

    public static class HouseTemplate {

        private static class Flat {
            double square;
            int numberOfResidents;

            public double getSquare() {
                return square;
            }

            public void setSquare(double s) {
                this.square = s;
            }

            public int getNumberOfResidents() {
                return numberOfResidents;
            }

            public void setNumberOfResidents(int number) {
                this.numberOfResidents = number;
            }
        }

        List<Flat> flats = new ArrayList<>();
        int limit = 0;

        public List<Flat> getFlats() {
            return flats;
        }

        public void addFlat(int numberOfResidents, double square) {
            if (this.limit <= flats.size()) {
                System.out.println("You can't add more living spaces");
                return;
            }
            Flat newFlat = new Flat();
            newFlat.setSquare(square);
            newFlat.setNumberOfResidents(numberOfResidents);
            flats.add(newFlat);
        }

    }

    public static class Cottage extends HouseTemplate {
        public Cottage setLimit(int l) {
            this.limit = l;
            return this;
        }
    }

    public static class Townhouse extends HouseTemplate {
        public Townhouse setLimit(int l) {
            this.limit = l;
            return this;
        }
    }

    public static class ApartmentHouse extends HouseTemplate {
        public ApartmentHouse setLimit(int l) {
            this.limit = l;
            return this;
        }
    }
}
