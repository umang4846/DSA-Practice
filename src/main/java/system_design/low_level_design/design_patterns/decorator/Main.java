package system_design.low_level_design.design_patterns.decorator;

public class Main {

    public static void main(String[] args) {
        IceCream iceCream = new ButterScotchIceCream();
        iceCream = new ChocolateSyrupDecorator(new ChocoChipsDecorator(iceCream));
        print(iceCream);
    }

    public static void print(IceCream iceCream){
        System.out.println("Desc : "+iceCream.getDescription());
        System.out.println("Cost : "+iceCream.cost());
    }
}
