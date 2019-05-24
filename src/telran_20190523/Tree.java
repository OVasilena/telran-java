package telran_20190523;

public class Tree extends Plant {

    final private int TREE_GROWTHRATE = 2;

    public Tree(int height, int age, String name) {
        super(height, age, name);
        super.setGrowthRate(TREE_GROWTHRATE);
    }

    @Override
    public void doSommer() {

        super.setHeight(getHeight() + TREE_GROWTHRATE);
        System.out.println("In sommer " + getDisplayName() + " grows by "
                + TREE_GROWTHRATE + " and is " + getHeight() + " cm height");
    }

    @Override
    public void doFall() {
        System.out.println(getDisplayName() + " does´t grow in autumn. It is " + getHeight() + " cm");
    }
}
