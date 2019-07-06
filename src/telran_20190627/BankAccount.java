package telran_20190627;

public class BankAccount {
    String iban;
    Person owner;

    public BankAccount(String iban) {
        this.iban = iban;
    }

    public BankAccount(String iban, Person owner) {
        this.iban = iban;
        this.owner = owner;
    }

    public String getIban() {
        return iban;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "iban='" + iban + '\'' +
                ", owner=" + owner +
                '}';
    }

    public Person getOwner() {
        return owner;
    }
}
