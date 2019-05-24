package telran_20190523;

public abstract class Plant {
    private int height;
    private int age;
    private int growthRate;
    private String displayName;

    public Plant(int height, int age, String name) {
        this.height = height;
        this.age = age;
        this.displayName = name;
    }

    public void setGrowthRate(int growthRate) {
        this.growthRate = growthRate;
    }

    private void doSpring() {
        height += growthRate;
        System.out.println("In spring " + displayName + " grows by " + growthRate
                + " cm and is " + height + " cm height");
    }

    private void doWinter() {
        System.out.println(displayName + " doesn´t grow in winter. It is " + height + " cm");

    }

    public abstract void doSommer();

    public abstract void doFall();

    public void doYear() {
        doSpring();
        doSommer();
        doFall();
        doWinter();
        age++;
        System.out.println(this.toString());
    }


    public void doYear(int year) {

        for(int i = 0; i < year; i++) {
            doSpring();
            doSommer();
            doFall();
            doWinter();
            age++;
            System.out.println("**************** end of " + age + " year ****************");
            System.out.println(this.toString());

        }

    }

    public String getDisplayName() {
        return displayName;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }



    @Override
    public String toString() {
        return "[Plant: " + displayName +
                ", age: " + age +
                ", height: " + height +"]";
    }
}
