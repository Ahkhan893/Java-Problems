package SolidPrinciple;


 interface Shape {
    int getArea();
}

 class Rectangle implements Shape {
    protected int width;
    protected int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getArea() {
        return width * height;
    }
}

 class Square implements Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public int getArea() {
        return side * side;
    }
}
//Rectangle and Square implement the Shape interface independently.
//
//No unexpected behavior—each class handles its own logic.
//
//The code respects LSP, promoting clean and predictable behavio

//In simpler terms, a subclass should be able to stand in for its
//superclass without causing unexpected behavior.
//If a subclass cannot replace its superclass reliably, it violates LSP.
public class LiskovSubstitutionPrinciple {

    public static void main(String[] args) {

    }
}
