package view;

import java.awt.*;
import javax.swing.*;

public class MenuButton extends JLabel {
    private Color bgColor;
    private boolean isSelected = false; // 選択機能の具現のため、基本値はFalse

    public MenuButton(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
        setOpaque(false);
    }

    public void setBackgroundColor(Color color) {
        this.bgColor = color;
    }

    // 選択された状態に切り替える
    public void setSelected(boolean selected) {
        this.isSelected = selected; // 選択されたことを感知。
        repaint();  // 変化を感知して自動的に書き直す。
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 自分が持っているフォントを絵筆(g2)にセットする
        g2.setFont(getFont());
        
        // １．角丸の背景を描く
        if (bgColor != null) {
            g2.setColor(bgColor);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); 
        }

        // ２．選択された場合の枠線を描く
        if (isSelected) {
            g2.setColor(Color.decode("#AAFFCC"));
            g2.setStroke(new BasicStroke(3.0f));
            g2.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, 20, 20);
        }

        // ３．TextRendererに文字関連の設定作業を転嫁
        TextRenderer.drawCenterShadowText(g2, getText(), getWidth(), getHeight(), getForeground());

        g2.dispose();
    }
}
