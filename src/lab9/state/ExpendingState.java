package lab9.state;

public class ExpendingState implements State {
    VendingMachine vendingMachine;

    public ExpendingState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(int amount) {
        int curAmount = vendingMachine.getAmount() + amount;
        if (curAmount >= vendingMachine.getPrice()) {
            if (curAmount > vendingMachine.getPrice())
                System.out.println("Change " + (curAmount - vendingMachine.getPrice()));
            System.out.println("Complete Expending, Plz get your ticket");
            vendingMachine.setAmount(0);
            vendingMachine.setPrice(0);
            vendingMachine.setCurrentState(vendingMachine.getCompleteState());
        } else if (curAmount < vendingMachine.getPrice())
            System.out.println("Need more " + (vendingMachine.getPrice() - curAmount));
    }

    @Override
    public void chooseDestination(String station) {
        System.err.println("ERROR: Invalid State");
    }

    @Override
    public void getTicket() {
        System.err.println("ERROR: Invalid State");
    }
}
