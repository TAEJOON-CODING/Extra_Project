package game;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TriangleManager {

    private List<Point> points = new ArrayList<>();
    private List<Triangle> triangles = new ArrayList<>();

    public void update() {

        // 後で追加

    }

    // 点を画く
    public void addPoint(int x, int y) {

    points.add(new Point(x, y));

        if (points.size() == 3) {

            Triangle t = new Triangle(
                points.get(0),
                points.get(1),
                points.get(2)
            );

            triangles.add(t);

            points.clear();
        }
    }

    public void draw(Graphics2D g) {

        // 三角形を塗る
        g.setColor(Color.CYAN); // 後で色の指定規則を修正。

        for (Triangle t : triangles) {
            t.draw(g);
        }

        // 点描画
        g.setColor(Color.YELLOW);

        for (Point p : points) {
            g.fillOval(p.x - 4, p.y - 4, 8, 8);
        }

    }

}

