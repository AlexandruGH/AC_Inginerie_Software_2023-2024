package liskov.good;

public class GoodGraphicsService {
    public void checkForArea(Shape shape) {


        if (shape instanceof GoodSquare){
            verify(shape, ((GoodSquare) shape).getSide());
        } else if (shape instanceof GoodRectangle) {
            verify(shape, ((GoodRectangle) shape).getWidth(), ((GoodRectangle) shape).getHeight());
        }
    }

    private void verify(Shape shape, int width, int height) {
        if (shape.getArea() == (width * height)) {
            System.out.println("Great Rectangle you got there!");
        } else {
            System.out.println("Well, not a Rectangle.");
        }
    }

    private void verify(Shape shape, int side){
        if (shape.getArea() == (side * side)){
            System.out.println("Great Square you got there!");
        }else{
            System.out.println("Well, not a Square.");
        }
    }
}
