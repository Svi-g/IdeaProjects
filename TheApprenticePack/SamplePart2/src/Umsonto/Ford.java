package Umsonto;

public enum Ford {
    Ranger, Focus, Bantam, Mustang, Everest
}

class CarDemo {
    public static void main(String... args) {
        Ford car;
        System.out.println("Here are all Ford constants:");

            for(Ford a : Ford.values())
                System.out.println(a);
        System.out.println();

        car = Ford.valueOf("Mustang");
        System.out.println("car contains " + car);
    }
}