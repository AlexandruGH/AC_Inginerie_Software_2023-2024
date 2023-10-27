package liskov;

import liskov.bad.BadGraphicsService;
import liskov.bad.BadRectangle;
import liskov.bad.BadSquare;
import liskov.good.GoodGraphicsService;
import liskov.good.GoodRectangle;
import liskov.good.GoodSquare;
import liskov.good.Shape;

public class Main {
    public static void main(String[] args) {
        //testBadL();
        testGoodL();
    }

    private static void testBadL() {
        BadRectangle actuallySquare = new BadSquare(20, 30);
        BadGraphicsService badGraphicsService = new BadGraphicsService();

        badGraphicsService.checkForArea(actuallySquare);
    }

    private static void testGoodL() {
        Shape rectangle = new GoodRectangle(29, 40);
        Shape square = new GoodSquare(20);
        GoodGraphicsService goodGraphicsService = new GoodGraphicsService();

        goodGraphicsService.checkForArea(rectangle);
        goodGraphicsService.checkForArea(square);

    }
}
