package Exercise3;
import java.util.Objects;

abstract class Shape {
        private String color;

        public Shape(String color) {
            this.color = color;
        }

        public abstract double calculateArea();

        public abstract double calculatePerimeter();

        public abstract void paint();

        public String getColor() {
            return color;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Shape shape = (Shape) o;
            return Objects.equals(color, shape.color);
        }

        @Override
        public int hashCode() {
            return Objects.hash(color);
        }

        @Override
        public String toString() {
            return "Shape{" +
                    "color='" + color + '\'' +
                    '}';
        }
    }

