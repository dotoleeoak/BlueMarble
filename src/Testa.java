import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Testa extends JPanel {
	public String name;
	public int id;
	public int have_money;

	public JLabel labelNameL;
	public JLabel labelMoneyL;
	public JLabel labelNameR;
	public JLabel labelMoneyR;

	public Testa(String _name, int id, int _x, int _y) {
		setLayout(null);
		setVisible(true);
		setSize(300, 100);
		setLocation(_x, _y);

		labelNameL = new JLabel("�̸�");
		labelMoneyL = new JLabel("������");
		labelNameR = new JLabel("�̸�R");
		labelMoneyR = new JLabel("������R");

		this.add(labelNameL);
		this.add(labelNameR);
		this.add(labelMoneyL);
		this.add(labelMoneyR);

	}
}
