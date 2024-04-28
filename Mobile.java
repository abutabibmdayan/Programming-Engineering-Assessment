public class Mobile extends Gadget {
    private int callingCredit;

    public Mobile(String model, double price, int weight, String size, int callingCredit) {
        super(model, price, weight, size);
        this.callingCredit = callingCredit;
    }

    public int getCallingCredit() {
        return callingCredit;
    }

    public void addCallingCredit(int amount) {
        if (amount > 0) {
            callingCredit += amount;
        } else {
            System.out.println("Please enter a positive amount to add calling credit.");
        }
    }

    public void makeCall(String phoneNumber, int duration) {
        if (callingCredit >= duration) {
            System.out.println("Calling " + phoneNumber + " for " + duration + " minutes");
            callingCredit -= duration;
        } else {
            System.out.println("Insufficient calling credit to make the call.");
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Calling Credit: " + callingCredit + " minutes");
    }
}
