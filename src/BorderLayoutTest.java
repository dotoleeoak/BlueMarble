import java.awt.BorderLayout;
 
import javax.swing.JButton;
import javax.swing.JFrame;
 
class BorderLay extends JFrame{
    
 
    public BorderLay() {
        super("Border Layout Test");
        this.init();//ȭ���� �����ϴ� �޼ҵ�
        
        this.setSize(BlueMarble.SCREEM_WIDTH, BlueMarble.SCREEN_HEIGHT);
        //ȭ���� ���� ���� ũ��
        setVisible(true);
        //ȭ�鿡 ǥ���ϴ� ��� �̰� �Ⱦ��� ǥ�þȵ�
    }
    public void init(){
        this.add(new JButton("Center"));
        this.add(new JButton("West"),BorderLayout.LINE_START);
        this.add(new JButton("East"),BorderLayout.LINE_END);
        this.add(new JButton("North"),BorderLayout.PAGE_START);
        this.add(new JButton("South"),BorderLayout.PAGE_END);
    }
}
public class BorderLayoutTest {
    public static void main(String[] args) {
        new BorderLay();
    }
}
