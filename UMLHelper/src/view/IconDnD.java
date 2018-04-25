import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.TransferHandler;
import javax.swing.border.EmptyBorder;
class DragMouseAdapter extends MouseAdapter {
  public void mousePressed(MouseEvent e) {
    JComponent c = (JComponent) e.getSource();
    TransferHandler handler = c.getTransferHandler();
    handler.exportAsDrag(c, e, TransferHandler.COPY);
  }
}
public class IconDnD {
  public static void main(String[] args) {
    JFrame f = new JFrame("Icon Drag & Drop");
    ImageIcon icon1 = new ImageIcon(".\\a.png");
    ImageIcon icon2 = new ImageIcon(".\\b.png");
    ImageIcon icon3 = new ImageIcon(".\\c.png");
        JPanel panel = new JPanel();
    JButton button = new JButton(icon2);

    JLabel label1 = new JLabel(icon1, JLabel.CENTER);
    JLabel label2 = new JLabel(icon3, JLabel.CENTER);
    f.setExtendedState(JFrame.MAXIMIZED_BOTH);
    MouseListener listener = new DragMouseAdapter();
    label1.addMouseListener(listener);
    label2.addMouseListener(listener);

    label1.setTransferHandler(new TransferHandler("icon"));
    button.setTransferHandler(new TransferHandler("icon"));
    label2.setTransferHandler(new TransferHandler("icon"));
    panel.setBorder(new EmptyBorder(5, 5, 5, 5));
    panel.setLayout(new FlowLayout());     
    panel.setBackground(Color.WHITE); 
    
    f.setLayout(new FlowLayout());
    panel.add(label1);
    panel.add(button);
    panel.add(label2);
    f.add(panel);
    f.pack();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    f.setVisible(true);
  }
}