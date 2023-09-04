package Umsonto;

public enum CarPrice {
    Tazz(20000), Jetta, GTI(40000), Ranger(50000), Everest(60000);

    private final int price;
    CarPrice(int p) {
        price = p;
    }
    CarPrice() {
        price = -1;
    }
    int getPrice() {
    return price;
    }
}

class PriceDemo {
    public static void main(String... args) {
        /* Display iprice yeTazz. */
        System.out.println("A Tazz costs R" +
                CarPrice.Tazz.getPrice() +
                " rands.\n");

        /*Display iprice yazo zonke imoto. */
        System.out.println("All car prices:");
        for(CarPrice a : CarPrice.values())
            System.out.println(a + " costs R" + a.getPrice() + " rands.");
    }
}
