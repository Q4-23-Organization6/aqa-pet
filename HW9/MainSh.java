public class MainSh {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle("Pink", 10.0);
        shapes[1] = new Rectangle("Green", 6.0, 10.0);
        shapes[2] = new Triangle("Red", 3.0, 3.0, 6.0);

        for (Shape shape : shapes) {
            shape.paint();
            System.out.println("Area: " + shape.calculateArea());
            System.out.println("Perimeter: " + shape.calculatePerimeter());
        }

        Shape shape1 = new Circle("Pink", 10.0);
        Shape shape2 = new Circle("Pink", 10.0);
        System.out.println("shape1.equals(shape2): " + shape1.equals(shape2));
        System.out.println("shape1.hashCode(): " + shape1.hashCode());
        System.out.println("shape2.hashCode(): " + shape2.hashCode());
        System.out.println("shape1.toString(): " + shape1);
    }
}
