// Controller.java
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Controller {
    private Sphere sphere;
    private Cylinder cylinder;

    public void createSphere(double radius) {
        sphere = new Sphere(radius);
    }

    public Sphere getSphere() {
        return sphere;
    }

    public void createCylinder(double radius, double height) {
        cylinder = new Cylinder(radius, height);
    }

    public Cylinder getCylinder() {
        return cylinder;
    }

    // Meetod tulemuste salvestamiseks faili
    public void saveResultsToFile(String shapeType, double... values) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("JavaKujundid.txt", true))) {
            StringBuilder sb = new StringBuilder();
            sb.append(shapeType).append(";");

            for (double value : values) {
                sb.append(value).append(";");
            }

            // Eemalda viimane semikoolon ja asenda koma
            writer.println(sb.toString().replace(";", ", ").trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
