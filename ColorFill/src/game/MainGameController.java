package game;

import javax.swing.*;

// ゲーム本編
public class MainGameController {

    private GamePanel panel;
    private TriangleManager triangleManager;
    private Player player;

    public void placePoint() {
        triangleManager.addPoint(player.getX(), player.getY());
    }

    public JPanel createPanel() {
        // 三角形色塗り
        triangleManager = new TriangleManager();
        player = new Player();
        panel = new GamePanel(this);
        return panel;
    }

    public void update(boolean up, boolean down, boolean left, boolean right) {
        player.update(up, down, left, right);
        // 三角形の更新
        triangleManager.update();

    }

    // TriangleManagerを読み込むため
    public TriangleManager getTriangleManager() {
        return triangleManager;
    }

    public Player getPlayer() {
        return player;
    }
}
