import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Game extends Thread {

	private Image rollDiceButtonImage = new ImageIcon(Main.class.getResource("images/rollDiceButton.png")).getImage();

	public int numPlayer;

	ArrayList<Coordinate> coordinateSet = new ArrayList<Coordinate>();
	ArrayList<Player> playerList = new ArrayList<Player>();

	Game(int _numPlayer) {
		this.numPlayer = _numPlayer;
		// setCoordinate();
		setPlayer();
	}

	public void setPlayer() {
		switch (numPlayer) {
			case 2:
				playerList.add(new Player(0));
				playerList.add(new Player(1));
			case 3:
				playerList.add(new Player(2));
			case 4:
				playerList.add(new Player(3));
		}
		for (int i = 0; i < playerList.size(); i++) {
			// TODO: Use coordinate manager (player)
			playerList.get(i).setPosition(coordinateSet.get(0));
		}
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(rollDiceButtonImage, 612, 350, null);
		for (int i = 0; i < playerList.size(); i++) {
			// TODO: Use coordinate manager (player)
			// g.drawImage(playerList.get(i).getPiece(), playerList.get(i).getPositionX(),
			// 		playerList.get(i).getPositionY(), null);
		}
	}
	
	@Override
	public void run() {
		/*  �� ���ʿ� �� ��
		 *  1. �ֻ��� ��ư ���
		 *  2. �ֻ��� ������
		 *  3. �ֻ��� ���� ����
		 *  4. �÷��̾� �̵� (�� ĭ��)
		 *     4-1. �� ĭ�� �̵��ϸ� ���ϸ��̼�(?)
		 *  5. �ǹ� ���� ���� Ȯ��
		 *  
		 *  if-1) ������ ��� ����
		 *  1. �ǹ� ���� ���� ����
		 *  2-1. ���� ��, �� ���� �� ������ ����
		 *  2-2. ���� ���ϸ�, �׳� pass
		 * 
		 *  if-2) ������ ��� ����
		 *  1. ���� ���� ���� ����
		 *  2-1. ���� ��, �� ���� �� ���� �߰�
		 *  2-2. ���� ���ϸ�, �׳� pass 
		 * 
		 *  if-3) ������ ��� Ÿ��
		 *  1. �� ����
		 *  2-1. �� ���� ��, ���� ���� �� �Ļ�
		 */
	}
	
	public void close() {
		this.interrupt();
	}
}
