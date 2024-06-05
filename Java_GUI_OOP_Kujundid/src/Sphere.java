// Sphere.java
public class Sphere {
    private double radius; // Raadius

    // Konstruktor
    public Sphere(double radius) {
        this.radius = radius;
    }

    // Getter raadiuse saamiseks
    public double getRadius() {
        return radius;
    }

    // Meetod pindala arvutamiseks
    public double getSurfaceArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    // Meetod ümbermõõdu arvutamiseks
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    // Meetod ruumala arvutamiseks
    public double getVolume() {
        return (4.0 / 3) * Math.PI * Math.pow(radius, 3);
    }
}
