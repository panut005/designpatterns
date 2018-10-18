package lab9.state;

import java.util.Map;
import java.util.TreeMap;

public class ReadyState implements State {
    VendingMachine vendingMachine;
    Map<String, Integer> destinationPriceMap = new TreeMap<>();

    public ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        destinationPriceMap.put("Ladprao", 10);
        destinationPriceMap.put("Kasetsart", 30);
        destinationPriceMap.put("Silom", 20);
    }

    @Override
    public void insertCoin(int amount) {
        System.err.println("ERROR: Invalid State");
    }

    @Override
    public void chooseDestination(String station) {
        if (destinationPriceMap.containsKey(station)) {
            System.err.println("ERROR: Invalid destination station");
            return;
        }
        int price = destinationPriceMap.get(station);
        System.out.println("Selecting " + station + ", " + price + " $");
        vendingMachine.setCurrentState(vendingMachine.getExpendingState());
    }

    @Override
    public void getTicket() {
        System.err.println("ERROR: Invalid State");
    }
}
