import java.awt.*;
import javax.swing.*;


public class PlayerGUI extends JPanel {

	public String name;
	public int id;
	public int have_money;
	
	public JLabel labelNameL;
	public JLabel labelMoneyL;
	public JLabel labelNameR;
	public JLabel labelMoneyR;
	
	public PlayerGUI(String _name, int id, int _x, int _y) {
		
		setLayout(new GridLayout(2,2));
		setVisible(true);
		setSize(300,100);
		setLocation(_x, _y);
		this.setBackground(Color.WHITE);
		
		labelNameL = new JLabel("이름");
		labelMoneyL = new JLabel("소지금");
		labelNameR = new JLabel("이름R");
		labelMoneyR = new JLabel("소지금R");
		
		this.add(labelNameL);
		this.add(labelNameR);
		this.add(labelMoneyL);
		this.add(labelMoneyR);
	}

}
