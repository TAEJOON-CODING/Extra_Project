package main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import view.SplashScreenController;

public class ColorFill {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            
            // １．ウィンドウ
            JFrame frame = new JFrame("COLORFILL");  // ゲームタイトル
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            SplashScreenController director = new SplashScreenController(frame);
            director.startSequence();
        });
        
    }
}