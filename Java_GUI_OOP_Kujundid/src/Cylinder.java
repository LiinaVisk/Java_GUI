// Cylinder.java
public class Cylinder {
    private double radius; // Raadius
    private double height; // Kõrgus

    // Konstruktor
    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    // Getter raadiuse saamiseks
    public double getRadius() {
        return radius;
    }

    // Getter kõrguse saamiseks
    public double getHeight() {
        return height;
    }

    // Meetod kogu pindala arvutamiseks
    public double getTotalSurfaceArea() {
        return 2 * Math.PI * radius * (radius + height);
    }

    // Meetod külgpindala arvutamiseks
    public double getLateralSurfaceArea() {
        return 2 * Math.PI * radius * height;
    }

    // Meetod ruumala arvutamiseks
    public double getVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }
}
