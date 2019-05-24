package telran_20190523;

public class IncreaseApp {

    public static void main(String[] args) {
        Plant flower = new Flower(0,0, "Tulpe");
        Plant tree = new Tree(100, 1, "Apfel");

        flower.doYear(3);
        System.out.println("*****************");
        tree.doYear(7);
    }

}
