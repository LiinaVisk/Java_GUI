// View.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class View extends JFrame {
    private JTextField sphereRadiusField; // Tekstiväli kera raadiuse jaoks
    private JTextField cylinderRadiusField; // Tekstiväli silindri raadiuse jaoks
    private JTextField cylinderHeightField; // Tekstiväli silindri kõrguse jaoks
    private JTextArea resultArea; // Tekstiala tulemuste kuvamiseks
    private JLabel fileLabel; // Silt failinime kuvamiseks
    private Controller controller; // Kontrollija objekt

    // Konstruktor, mis loob kasutajaliidese
    public View() {
        controller = new Controller();
        setTitle("Geomeetrilised Kujundid");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Paneel sisendväljade ja nuppude jaoks
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 3, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Lisa kera raadiuse silt ja tekstiväli
        inputPanel.add(new JLabel("Kera raadius:"));
        sphereRadiusField = new JTextField();
        inputPanel.add(sphereRadiusField);

        // Lisa nupp kera arvutamiseks
        JButton sphereButton = new JButton("Arvuta Kera");
        inputPanel.add(sphereButton);

        // Lisa tühi ruum, et hoida paneelid võrdsed
        inputPanel.add(new JLabel("")); // Tühi ruum

        // Lisa silindri raadiuse silt ja tekstiväli
        inputPanel.add(new JLabel("Silinder raadius:"));
        cylinderRadiusField = new JTextField();
        inputPanel.add(cylinderRadiusField);

        // Lisa silindri kõrguse silt ja tekstiväli
        inputPanel.add(new JLabel("Silinder kõrgus:"));
        cylinderHeightField = new JTextField();
        inputPanel.add(cylinderHeightField);

        // Lisa nupp silindri arvutamiseks
        JButton cylinderButton = new JButton("Arvuta Silinder");
        inputPanel.add(cylinderButton);

        // Lisa tühi ruum, et hoida paneelid võrdsed
        inputPanel.add(new JLabel("")); // Tühi ruum

        // Lisa tulemuste kuvamise tekstiala
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Lisa failinime kuvamise silt
        fileLabel = new JLabel("Faili asukoht: " + new File("JavaKujundid.txt").getAbsolutePath());
        JPanel filePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        filePanel.add(fileLabel);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(filePanel, BorderLayout.SOUTH);

        // Kera arvutamise nupu tegevuse kuulaja
        sphereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateSphere();
            }
        });

        // Silindri arvutamise nupu tegevuse kuulaja
        cylinderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateCylinder();
            }
        });

        // Aknapaigutus ekraani keskele
        setLocationRelativeTo(null);
    }

    // Meetod kera arvutamiseks
    private void calculateSphere() {
        try {
            double radius = Double.parseDouble(sphereRadiusField.getText());
            controller.createSphere(radius);
            Sphere sphere = controller.getSphere();
            double surfaceArea = sphere.getSurfaceArea();
            double circumference = sphere.getCircumference();
            double volume = sphere.getVolume();

            String result = String.format("Kera: Raadius = %.2f, Pindala = %.2f, Ümbermõõt = %.2f, Ruumala = %.2f",
                    radius, surfaceArea, circumference, volume);
            resultArea.append(result.replace(";", ",") + "\n");

            controller.saveResultsToFile("Kera", radius, surfaceArea, circumference, volume);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Palun sisesta korrektne number!", "Viga", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Meetod silindri arvutamiseks
    private void calculateCylinder() {
        try {
            double radius = Double.parseDouble(cylinderRadiusField.getText());
            double height = Double.parseDouble(cylinderHeightField.getText());
            controller.createCylinder(radius, height);
            Cylinder cylinder = controller.getCylinder();
            double totalSurfaceArea = cylinder.getTotalSurfaceArea();
            double lateralSurfaceArea = cylinder.getLateralSurfaceArea();
            double volume = cylinder.getVolume();

            String result = String.format("Silinder: Raadius = %.2f, Kõrgus = %.2f, Kogu pindala = %.2f, Külgpindala = %.2f, Ruumala = %.2f",
                    radius, height, totalSurfaceArea, lateralSurfaceArea, volume);
            resultArea.append(result.replace(";", ",") + "\n");

            controller.saveResultsToFile("Silinder", radius, height, totalSurfaceArea, lateralSurfaceArea, volume);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Palun sisesta korrektne number!", "Viga", JOptionPane.ERROR_MESSAGE);
        }
    }
}
