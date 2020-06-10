import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("serial")
public class Game extends JFrame {

	private Image rollDiceButtonImage = new ImageIcon(Main.class.getResource("images/rollDiceButton.png")).getImage();

	public int numPlayer;
	// private int currentPlayer;
	private int playerIdx;

	public static CityManager cityManager = new CityManager();
	public static CoordinateManager coordinateManager = new CoordinateManager();

	ArrayList<Coordinate> coordinateSet = new ArrayList<Coordinate>();
	ArrayList<Player> playerList = new ArrayList<Player>();

	Game(int _numPlayer) {
		this.numPlayer = _numPlayer;
		// setCoordinate();
		setPlayer();
		playerIdx = 1;
	}

	public void setPlayer() {
		switch (numPlayer) {
			case 2:
				playerList.add(new Player(0, "First"));
				playerList.add(new Player(1, "Second"));
			case 3:
				playerList.add(new Player(2, "Third"));
			case 4:
				playerList.add(new Player(3, "Fourth"));
		}
		for (int i = 0; i < playerList.size(); i++) {
			// TODO: Use coordinate manager (player)
			// playerList.get(i).setPosition(coordinateSet.get(0));
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

	int rollDice() {
		return new Random().nextInt() % 6 + 1;
	}

	public boolean turn() {
		Player player = playerList.get(playerIdx);
		int currPos = player.position;
		int dice = rollDice();
		int nextPos = player.nextPosition(dice);
		Coordinate playerCoord = coordinateManager.getPlayerCoordinate(playerIdx, nextPos);

		/* wait for dice roll button */

		/* (animation) rolling dice */

		/* print dice number */
		
		/* (animation) moving character */

		int owner = cityManager.owner(nextPos);

		if (currPos == 8) {
			player.lab();
		} else if (currPos == 4 || currPos == 12) {
			player.winChance();
		} else if (owner == -1) {
			int decision = JOptionPane.showConfirmDialog(this, "������ �����Ͻðھ��?");
			if (decision == 1) {
				cityManager.buyCity(nextPos, player.ID);
			}
		} else if (owner == player.ID) {
			int decision = JOptionPane.showConfirmDialog(this, "�ǹ��� �����ðھ��?");
			if (decision == 1) {
				cityManager.buyBuilding(nextPos, player.ID);
			}
		} else {
			/* use chance */
			if (player.hasChance()) {
				player.popChance();

				if (new Random().nextInt() % 2 == 0) {
					/* some notification (pop-up) here */
					// toll free chance
					JOptionPane.showMessageDialog(this, "���� ī�忡�� ����� ���� ȿ�� �ߵ�!");
				} else {
					// toll x2 chance
					JOptionPane.showMessageDialog(this, "���� ī�忡�� �ٰ��� ȿ�� �ߵ�!");
					if (!player.payToll(nextPos)) {
						/* some animation here */
						return false;
					} else if(!player.payToll(nextPos)){
						return false;
					}
				}
			} else if (!player.payToll(nextPos)) {
				/* some animation here */
				return false;
			}
			
			playerList.get(owner).earnMoney(cityManager.getToll(nextPos));
			
			// ���� �ǹ� �ŷ��� ���� (��ư ����)
			// int decision = JOptionPane.showConfirmDialog(this, "�ǹ��� �μ��Ͻðھ��?");
			// if (decision == 1) {
			// }
		}

		return true;
	}
	
	// @Override
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
		 *  2-1. ���� ��, �� ���� �� ���� �߰�s
		 *  2-2. ���� ���ϸ�, �׳� pass 
		 * 
		 *  if-3) ������ ��� Ÿ��
		 *  1. �� ����
		 *  2-1. �� ���� ��, ���� ���� �� �Ļ�
		 *  3. (�ð� ������) �μ� ��� �� ����
		 */

		// �Ļ��ϸ� while ����
		while (turn()) {
			playerIdx = (playerIdx + 1) % 4;
		}
		JOptionPane.showMessageDialog(this, ""+playerIdx+"�� �÷��̾� �Ļ�!");

		// int nextPos = playerList.get(currentPlayer).nextPosition(rollDice());
		// Coordinate coord = coordinateManager.getPlayerCoordinate(currentPlayer, nextPos);		
		
		
	}
	
	/* public void close() {
		this.interrupt();
	} */
}
