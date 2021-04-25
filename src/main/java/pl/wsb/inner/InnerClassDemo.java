package pl.wsb.inner;

public class InnerClassDemo {
    public static void main(String[] args) {
        InnerPanel panel = new InnerPanel(12, 13, 1000);
        InnerPanel.Border border = panel.new Border(100, 1000);

    }
}
