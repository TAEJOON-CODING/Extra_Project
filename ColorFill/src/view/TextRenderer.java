package view;

import java.awt.*;

public class TextRenderer {
    public static void drawCenterShadowText(Graphics2D g2, String text, int panelWidth, int panelHeight, Color textColor) {
        
        // １．文字の配置関連
        FontMetrics fm = g2.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getHeight();
        int x = (panelWidth - textWidth) / 2;
        int y = (panelHeight - textHeight) / 2 + fm.getAscent();

        // ２．文字に影を入れる。
        g2.setColor(new Color(0, 0, 0, 75));
        g2.drawString(text, x + 1, y + 1);

        // ３．本来の文字を描画する
        g2.setColor(textColor);
        g2.drawString(text, x, y);
    }
}
