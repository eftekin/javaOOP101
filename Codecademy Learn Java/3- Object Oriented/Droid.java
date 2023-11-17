public class Droid {
    String name;
    double batteryLevel;

    public Droid(String droidName) {

        name = droidName;
        batteryLevel = 100;
    }

    public String toString() {
        return "Hello, I'm the droid: " + name;
    }

    public void performTask(String task) {

        System.out.println(name + " is performing task: " + task);
        batteryLevel -= 10;

    }

    public static void main(String[] args) {

        Droid Codey = new Droid("Codey");
        System.out.println(Codey.name);
        Codey.performTask("dance");
        System.out.println(Codey.batteryLevel);

    }

}