package lab9.tour;

public class Main {
    public static void main(String[] args) {
        Tour tour1 = new PackageTour("tour1",
                new SingleTour("hello", 10, 10),
                new SingleTour("world", 20, 26),
                new SingleTour("thailand", 5, 5));
        System.out.println(tour1.getName() + " " + tour1.getAvailableSeats() + " " + tour1.getPrice());
        Tour tour2 = new SingleTour("tour2", 10, 20);
        System.out.println(tour2.getName() + " " + tour2.getAvailableSeats() + " " + tour2.getPrice());
    }
}
