package game;

import java.awt.*;

public class Player {

    // 初期スポーン座標
    private int x = 100;
    private int y = 100;

    // 移動速度の制御
    private int speed = 3;

    // プレイヤーの移動機能
    public void update(boolean up, boolean down, boolean left, boolean right) {

        if (up) y -= speed;
        if (down) y += speed;
        if (left) x -= speed;
        if (right) x += speed;

    }

    public void draw(Graphics2D g) {

        g.setColor(Color.RED);
        g.fillRect(x - 5, y - 5, 10, 10);

    }

    public int getX() { return x; }
    public int getY() { return y; }
}
