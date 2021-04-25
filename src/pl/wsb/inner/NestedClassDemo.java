package pl.wsb.inner;

public class NestedClassDemo {
    public static void main(String[] args) {
        //InnerPanel.Builder builder = new InnerPanel.Builder();
        new InnerPanel(12,8,1200);
        final InnerPanel panel = InnerPanel.builder().width(12).height(8).unitPrice(1200).build();
        InnerPanel emptyPanel = InnerPanel.builder().width(5).height(7).unitPrice(12500).build();
    }
}
