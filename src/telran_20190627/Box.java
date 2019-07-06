package telran_20190627;

public class Box {
    int amount;

    public Box(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Box{" +
                "amount=" + amount +
                '}';
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
