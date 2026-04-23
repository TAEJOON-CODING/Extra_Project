package view;

public class MenuSelect {
    private MenuButton[] buttons;
    private int currentIndex = 0;   // 選択されたボタンの番号、基本値は0

    public MenuSelect(MenuButton[] buttons) {
        this.buttons = buttons;
        updateSelection();
    }

    // メニュー選択操作、マウス操作（ホバー）
    public void setHoverIndex(int index) {
        currentIndex = index;
        updateSelection();
    }

    // メニュー選択操作、キーボードの「↓」キー
    public void moveDown() {
        currentIndex++;
        if (currentIndex >= buttons.length) {
            currentIndex = 0;   // 選択操作がループするようにする。
        }
        updateSelection();
    }

    // メニュー選択操作、キーボードの「↑」キー
    public void moveUp() {
        currentIndex--;
        if (currentIndex < 0) {
            currentIndex = buttons.length - 1;  // 選択操作がループするようにする。
        }
        updateSelection();
    }

    // 選択されているボタンを視覚的に表示する。
    private void updateSelection() {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setSelected((i == currentIndex));
        }
    }

    // 今選ばれている番号を教える機能
    public int getCurrentIndex() {
        return currentIndex;
    }
}
