public class TestRefactor {
    public static void main(String[] args) {
        Crop turnip = CropFactory.create("Turnip");
        Crop strawberry = CropFactory.create("Strawberry");
        Crop potato = CropFactory.create("Potato");

        System.out.println("Turnip Base Price: " + turnip.getSellPrice());
        System.out.println("Turnip Base Price: " + strawberry.getSellPrice());
        System.out.println("Turnip Base Price: " + potato.getSellPrice());

    }
}