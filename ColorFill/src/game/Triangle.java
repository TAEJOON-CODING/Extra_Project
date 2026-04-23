package game;

import java.awt.*;

public class Triangle {

    private Point a;
    private Point b;
    private Point c;

    // 三角形の頂点を指定して生成
    public Triangle(Point a, Point b, Point c) {

        this.a = a;
        this.b = b;
        this.c = c;

    }

    // 三角形を描画
    public void draw(Graphics2D g) {

        int[] x = {a.x, b.x, c.x};
        int[] y = {a.y, b.y, c.y};

        g.fillPolygon(x, y, 3);

    }
}