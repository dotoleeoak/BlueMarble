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
		
		//this.setLayout(new GridLayout(2,2));
		this.setLayout(null);
		setVisible(true);
		this.setBounds(_x, _y, 0, 100);
		this.setBackground(Color.WHITE);
		
		labelNameL = new JLabel("�̸�");
		labelMoneyL = new JLabel("������");
		labelNameR = new JLabel("�̸�R");
		labelMoneyR = new JLabel("������R");
		
		labelNameL.setBounds(0,0,100,50);
		labelNameL.setVisible(true);
		
		this.add(labelNameL);
		this.add(labelNameR);
		this.add(labelMoneyL);
		this.add(labelMoneyR);
	}

}