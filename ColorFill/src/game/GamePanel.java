package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel {

    // コントローラーから相続
    private MainGameController controller;
    private Timer gameLoop;

    private boolean up, down, left, right;

    public GamePanel(MainGameController controller) {

        this.controller = controller;

        setFocusable(true);
        setBackground(Color.decode("#A0A0A0"));

        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_UP) up = true;
                if (e.getKeyCode() == KeyEvent.VK_DOWN) down = true;
                if (e.getKeyCode() == KeyEvent.VK_LEFT) left = true;
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) right = true;

                if (e.getKeyCode() == KeyEvent.VK_Z) {
                    controller.placePoint();
                }
            }

            public void keyReleased(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_UP) up = false;
                if (e.getKeyCode() == KeyEvent.VK_DOWN) down = false;
                if (e.getKeyCode() == KeyEvent.VK_LEFT) left = false;
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) right = false;

            }

        });

        // ゲームのフレームレート
        gameLoop = new Timer(16, e -> {
            controller.update(up, down, left, right);
            repaint();
        });

        gameLoop.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        // 三角形描画
        controller.getTriangleManager().draw(g2);

        // プレイヤー描画
        controller.getPlayer().draw(g2);
    }

}