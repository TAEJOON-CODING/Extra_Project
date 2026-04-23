package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import game.MainGameController;

// タイトルメニュー
public class TitleMenuController {
    
    // まだテスト用
    private JFrame frame;
    public TitleMenuController(JFrame frame) {
        this.frame = frame;
    }

    public JPanel createPanel() {
        // パネルの作成、背景色の設定。
        JPanel menupanel = new JPanel(null);
        menupanel.setBackground(Color.DARK_GRAY);

        // キーボード操作を認知
        menupanel.setFocusable(true);

        // メニューの項目を作成。
        // GridLayoutの順番は行数、列数、行間隔、列間隔
        JPanel menuContainer = new JPanel(new GridLayout(5, 1, 0, 5));
        menuContainer.setBackground(Color.DARK_GRAY);

        // 3. 各メニューボタンのラベル
        MenuButton newGameLabel = new MenuButton("ニューゲーム", SwingConstants.CENTER);
        MenuButton continueLabel = new MenuButton("コンティニュー", SwingConstants.CENTER);
        MenuButton scorLabel = new MenuButton("スコア", SwingConstants.CENTER);
        MenuButton optionLabel = new MenuButton("オプション", SwingConstants.CENTER);
        MenuButton exitLabel = new MenuButton("終了", SwingConstants.CENTER);

        // ４．文字に関する設定
        // A案
        // Font menuFont = new Font("MS Gothic", Font.BOLD, 28);
        // newGameLabel.setFont(menuFont);
        // newGameLabel.setForeground(Color.CYAN);
        // continueLabel.setFont(menuFont);
        // continueLabel.setForeground(Color.CYAN);
        // scorLabel.setFont(menuFont);
        // scorLabel.setForeground(Color.CYAN);
        // optionLabel.setFont(menuFont);
        // optionLabel.setForeground(Color.CYAN);
        // exitLabel.setFont(menuFont);
        // exitLabel.setForeground(Color.CYAN);

        // B案
        Font menuFont = new Font("UD デジタル 教科書体 NP-R", Font.BOLD, 28);

        // 一括適用対象を包む、これでメニューの項目が増えてもA案の2行追でなく、変数名を追加するだけで済む。
        MenuButton[] labels = {newGameLabel, continueLabel, scorLabel, optionLabel, exitLabel};

        MenuSelect menuSelect = new MenuSelect(labels);

        // for文で一括適用＋メニュー選択（マウス操作）
        for (int i = 0; i < labels.length; i++) {
            MenuButton label = labels[i];

            // 一括適用部分
            label.setFont(menuFont);
            label.setForeground(Color.decode("#1640A0"));
            label.setBackgroundColor(Color.decode("#FA8010"));

            // マウス操作（ホバー）
            final int buttonIndex = i; 
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    menuSelect.setHoverIndex(buttonIndex);
                }
            });

            menuContainer.add(label);
        }
        
        // キーボード操作
        menupanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    menuSelect.moveDown();
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    menuSelect.moveUp();
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_Z) {
                    int selected = menuSelect.getCurrentIndex();

                    if (selected == 0) {

                        MainGameController mainGame = new MainGameController();
                        JPanel gamePanel = mainGame.createPanel();

                        frame.setContentPane(gamePanel);
                        frame.revalidate();
                        frame.repaint();
                        gamePanel.requestFocusInWindow();

                    } else if (selected == 4) { // 4番（終了）

                        System.exit(0); 
                    }
                } 

            }
        });
        
        // ５．パネルにメニュー表を張る
        menuContainer.setBounds(50, 215, 250, 300);
        menupanel.add(menuContainer);

        return menupanel;
    }
}
