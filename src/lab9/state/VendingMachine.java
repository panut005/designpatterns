package lab9.state;

public class VendingMachine {
    private State expendingState = new ExpendingState(this);
    private State readyState = new ReadyState(this);
    private State CompleteState = new CompleteState(this);
    private State currentState = readyState;

    private int amount = 0;
    private int price = 0;

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public State getExpendingState() {
        return expendingState;
    }

    public State getReadyState() {
        return readyState;
    }

    public State getCompleteState() {
        return CompleteState;
    }
}
