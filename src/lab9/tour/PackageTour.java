package lab9.tour;

import java.util.Arrays;
import java.util.List;

public class PackageTour implements Tour {
    private List<Tour> tours;
    private String name;

    public PackageTour(String name, Tour... tours) {
        this.tours = Arrays.asList(tours);
        this.name = name;
    }

    public void addTour(Tour... tours) {
        this.tours.addAll(Arrays.asList(tours));
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return tours.stream().mapToDouble(Tour::getPrice).sum();
    }

    @Override
    public int getAvailableSeats() {
        return tours.isEmpty() ? 0 : tours.stream().mapToInt(Tour::getAvailableSeats).min().getAsInt();
    }
}
