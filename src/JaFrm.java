import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JaFrm extends JFrame {
    public JaFrm(String title) {
        setTitle(title); // Ÿ��Ʋ
        setSize(300, 200); // ũ��
        setDefaultCloseOperation(EXIT_ON_CLOSE); // �����ư Ŭ���� ��������
        JPanel pn = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setFont(new Font("�������", Font.ITALIC, 24)); // ��Ʈ
                g.drawString("�ȳ��ϼ���", 10, 30); // ���ڿ� ǥ��
                g.drawOval(10, 50, 200, 40); // Ÿ��ǥ��
                g.drawRect(10, 100, 200, 40); // �簢��ǥ��
            }
        }; // �г� �߰�
        add(pn);
        setVisible(true); // ����� ���̰�
    }

    public static void main(String[] args) {
        JaFrm frm = new JaFrm("����Ŭ�ڹ�");
    }
}

// class MyPanel extends JPanel {

// // �׸��� �׸��� ��

// @Override

// protected void paintComponent(Graphics g) {

// super.paintComponent(g);

// g.setFont(new Font("�������", Font.ITALIC, 24)); // ��Ʈ

// g.drawString("�ȳ��ϼ���", 10, 30); // ���ڿ� ǥ��

// g.drawOval(10, 50, 200, 40); // Ÿ��ǥ��

// g.drawRect(10, 100, 200, 40); // �簢��ǥ��

// }

// }
