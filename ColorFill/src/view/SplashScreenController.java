package view;

import javax.swing.*;

// // スプラッシュスクリーン制御クラス
public class SplashScreenController {

    // 窓枠
    JFrame frame;

    // コンストラクタ
    public SplashScreenController(JFrame frame) {
        this.frame = frame;
    }

    // 表示される中身
    public void startSequence() {

        // パネルをもらう
        SplashScreen_001 sean001 = new SplashScreen_001();
        JPanel panel1 = sean001.createPanel();
        
        // 窓枠にパネルをはめ込んで、表示する
        frame.setContentPane(panel1);
        frame.setVisible(true);

        // 2秒後に次のパネルや次の段階に移動。
        Timer timer001 = new Timer(2000, e -> {
            System.out.println("2秒経過");
            
            // メニュー画面に移動
            TitleMenuController menuController = new TitleMenuController(frame);
            JPanel nextPanel = menuController.createPanel();

            frame.setContentPane(nextPanel);

            frame.revalidate();
            frame.repaint();

            // 画面転換の後、キーボード操作が聞くようにする。
            nextPanel.requestFocusInWindow();
        });
        timer001.setRepeats(false);
        timer001.start();
    }
}