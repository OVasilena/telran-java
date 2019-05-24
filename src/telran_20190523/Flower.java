package telran_20190523;

public class Flower extends Plant {

    private final int FLOWER_GROWRATE = 10;

    public Flower(int height, int age, String name) {
        super(height,age,name);
        super.setGrowthRate(FLOWER_GROWRATE);

    }

    @Override
    public void doSommer() {
        System.out.println(getDisplayName() + " does´t grow in sommer. It is " + getHeight() + " cm" );
    }

    @Override
    public void doFall() {
        setHeight(0);
        System.out.println("In the autumn, " + getDisplayName() + " is cut off.");

    }


}
