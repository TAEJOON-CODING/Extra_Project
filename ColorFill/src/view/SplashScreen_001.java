package view;

import javax.swing.*;
import java.awt.*;

public class SplashScreen_001 {
    public JPanel createPanel() {
        // 1. パネルの宣言
        JPanel panel = new JPanel(new BorderLayout());

        // ２．テキストツールの宣言
        JLabel titleLabel = new JLabel();

        // ３．背景色を指定
        panel.setBackground(Color.BLACK);

        // ４．テキスト内容
        titleLabel.setText("COLORFILLGAME");

        // ５．揃え方
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // ６．フォント、サイズ
        titleLabel.setFont(new Font("Bowlby One SC", Font.BOLD, 48));
        
        // ７．文字色
        titleLabel.setForeground(Color.decode("#AAFFF0"));

        // ８．中央に配置
        panel.add(titleLabel, BorderLayout.CENTER);

        // ９．パネルの返却
        return panel;
    }
}
