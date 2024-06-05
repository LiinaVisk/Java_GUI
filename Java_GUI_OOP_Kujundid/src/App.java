import javax.swing.*;

// App.java
public class App {
    public static void main(String[] args) {
        // Käivita kasutajaliides
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new View().setVisible(true); // Loo ja kuva kasutajaliides
            }
        });
    }
}
