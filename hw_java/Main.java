package hw_java;
public class Main {
        public static void main(String[] args) {
        Toy truck = new Toy(1, "truck");
        Toy teddy_bear = new Toy(2, "teddy_bear");
        Toy cubes = new Toy(3, "Cubes");
        Toy Car = new Toy(4, "Car");
        Toy Lego = new Toy(5, "Lego");
        Toy ball = new Toy(6, "Ball");
        Toy bicycle = new Toy(7, "bicycle");
        Toy chess = new Toy(8, "chess");
        Toy gun = new Toy(9, "gun");
        Toy doll = new Toy(10, "doll");


        Lot lottery = new Lot();
        lottery.add_toy_in_listToy(truck);
        lottery.add_toy_in_listToy(teddy_bear);
        lottery.add_toy_in_listToy(cubes);
        lottery.add_toy_in_listToy(Car);
        lottery.add_toy_in_listToy(Lego);
        lottery.add_toy_in_listToy(ball);
        lottery.add_toy_in_listToy(bicycle);
        lottery.add_toy_in_listToy(chess);        
        lottery.add_toy_in_listToy(gun);
        lottery.add_toy_in_listToy(doll);

        lottery.lottteryToy();
        lottery.readFile();
        lottery.lottteryToy();
        lottery.readFile();
        System.out.println();
        lottery.getToys();
        lottery.getToy_count();
    }

}
