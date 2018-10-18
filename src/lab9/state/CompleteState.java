package lab9.state;

public class CompleteState implements State {
    VendingMachine vendingMachine;

    public CompleteState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(int amount) {
        System.err.println("ERROR: Invalid State");
    }

    @Override
    public void chooseDestination(String station) {
        System.err.println("ERROR: Invalid State");
    }

    @Override
    public void getTicket() {
        System.out.println("This is your ticket");
        vendingMachine.setCurrentState(vendingMachine.getReadyState());
    }
}
