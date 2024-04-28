public class MP3 extends Gadget {
    private int availableMemory;

    public MP3(String model, double price, int weight, String size, int availableMemory) {
        super(model, price, weight, size);
        this.availableMemory = availableMemory;
    }

    public int getAvailableMemory() {
        return availableMemory;
    }

    public void downloadMusic(int memoryNeeded) {
        if (availableMemory >= memoryNeeded) {
            availableMemory -= memoryNeeded;
        } else {
            System.out.println("Insufficient memory to download music.");
        }
    }

    public void deleteMusic(int memoryFreed) {
        availableMemory += memoryFreed;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Available Memory: " + availableMemory + " MB");
    }
}
