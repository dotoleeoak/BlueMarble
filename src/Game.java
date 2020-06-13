import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("serial")
public class Game extends JPanel {

	private Image screenImage;
	private Image background = new ImageIcon(Main.class.getResource("images/Board/board.png")).getImage();
	private ImageIcon[] imagePlayer;
	// private Image rollDiceButtonImage = new ImageIcon(Main.class.getResource("images/rollDiceButton.png")).getImage();

	private JButton rollDiceButton;
	private JLabel rollingDice;
	private JLabel[] labelPlayer;
	private JLabel[] diceNumber;

	private Coordinate[] coordinatePlayer;

	int numPlayer;
	int playerIdx;
	int dice;

	public static CityManager cityManager = new CityManager();
	public static CoordinateManager coordinateManager = new CoordinateManager();

	// ArrayList<Coordinate> coordinateSet = new ArrayList<Coordinate>();
	ArrayList<Player> playerList;

	Main controller;

	Game(Main c) {
		setLayout(null);
		setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setBackground(Color.CYAN);

		imagePlayer = new ImageIcon[4];
		for (int i = 0; i < 4; i++) {
			imagePlayer[i] = new ImageIcon(Main.class.getResource("images/Board/player" + i + ".png"));
		}

		diceNumber = new JLabel[6];
		for (int i = 0; i < 6; i++) {
			diceNumber[i] = new JLabel(new ImageIcon(Main.class.getResource("images/Board/dice" + (i + 1) + ".png")));
			diceNumber[i].setBounds(540, 240, 200, 220);
			diceNumber[i].setVisible(false);
			add(diceNumber[i]);
		}

		controller = c;
	}

	@Override
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenDraw((Graphics2D) screenImage.getGraphics());
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		paintComponents(g);
		repaint();
	}

	public void init(int numPlayer) {
		this.numPlayer = numPlayer;
		playerIdx = 0;
		playerList = new ArrayList<Player>();
		labelPlayer = new JLabel[numPlayer];
		coordinatePlayer = new Coordinate[numPlayer];
		
		switch (numPlayer) {
			case 4:
			playerList.add(new Player(3, "Fourth"));
			case 3:
			playerList.add(new Player(2, "Third"));
			case 2:
			playerList.add(new Player(1, "Second"));
			playerList.add(new Player(0, "First"));
		}

		/********* SHOW PLAYER ICONS *********/
		for (Player player : playerList) {
			JLabel label = labelPlayer[player.ID];
			coordinatePlayer[player.ID] = coordinateManager.getPlayerCoordinate(player.ID, player.position);
			coordinatePlayer[player.ID].x -= 5;
			coordinatePlayer[player.ID].y -= 15;
			label = new JLabel(imagePlayer[player.ID]);
			label.setBounds(coordinatePlayer[player.ID].x, coordinatePlayer[player.ID].y, 30, 30);
			add(label);
		}

		rollDiceButton = new JButton();
		rollDiceButton.setBounds(540, 240, 200, 176);
		rollDiceButton.setBorderPainted(false);
		rollDiceButton.setContentAreaFilled(false);
		rollDiceButton.setFocusPainted(false);
		rollDiceButton.setIcon(new ImageIcon(Main.class.getResource("images/Board/rollDiceButton.png")));
		rollDiceButton.setRolloverIcon(new ImageIcon(Main.class.getResource("images/Board/rollDiceButtonEntered.png")));
		rollDiceButton.setPressedIcon(new ImageIcon(Main.class.getResource("images/Board/rollDiceButtonPressed.png")));
		rollDiceButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				turn();
			}
		});
		add(rollDiceButton);

		rollingDice = new JLabel();
		rollingDice.setBounds(540, 220, 200, 200);
		rollingDice.setIcon(new ImageIcon(Main.class.getResource("images/rollingDice_3.gif")));
		rollingDice.setVisible(false);
		add(rollingDice);
	}
	
	int rollDice() {
		return new Random().nextInt() % 6 + 1;
	}
	
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
	public boolean turn() {
		System.out.println("turn() called.");
		System.out.println("playerIdx = " + playerIdx);
		rollDiceButton.setVisible(false);
		rollingDice.setVisible(true);

		Timer timer = new Timer(2000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dice = rollDice();
				rollingDice.setVisible(false);
				rollDiceButton.setVisible(true);
				diceNumber[dice - 1].setVisible(true);
			}
		});

		timer.start();

		// try {
		// 	Thread.sleep(2000);
		// } catch(InterruptedException e) {
		// 	e.printStackTrace();
		// }

		// rollingDice.setVisible(false);
		// rollDiceButton.setVisible(true);

		// labelPlayer[0].setBounds(40, 40, 30, 30);
		// for (int i = 0; i < 50; i++) {
		// 	coordinatePlayer[playerIdx].x += 1;
		// 	labelPlayer[playerIdx].setBounds(coordinatePlayer[playerIdx].x, coordinatePlayer[playerIdx].y, 30, 30);
		// }

		// Player player = playerList.get(playerIdx);
		// int currPos = player.position;
		// int dice = rollDice();
		// int nextPos = player.nextPosition(dice);
		// Coordinate playerCoord = coordinateManager.getPlayerCoordinate(playerIdx, nextPos);
		
		// /* wait for dice roll button */
		
		// /* (animation) rolling dice */
		
		// /* print dice number */
		
		// /* (animation) moving character */
		
		// int owner = cityManager.owner(nextPos);
		
		// if (currPos == 8) {
		// 	player.lab();
		// } else if (currPos == 4 || currPos == 12) {
		// 	player.winChance();
		// } else if (owner == -1) {
		// 	int decision = JOptionPane.showConfirmDialog(this, "������ �����Ͻðھ��?");
		// 	if (decision == 1) {
		// 		cityManager.buyCity(nextPos, player.ID);
		// 	}
		// } else if (owner == player.ID) {
		// 	int decision = JOptionPane.showConfirmDialog(this, "�ǹ��� �����ðھ��?");
		// 	if (decision == 1) {
		// 		cityManager.buyBuilding(nextPos, player.ID);
		// 	}
		// } else {
		// 	/* use chance */
		// 	if (player.hasChance()) {
		// 		player.popChance();
		
		// 		if (new Random().nextInt() % 2 == 0) {
		// 			/* some notification (pop-up) here */
		// 			// toll free chance
		// 			JOptionPane.showMessageDialog(this, "���� ī�忡�� ����� ���� ȿ�� �ߵ�!");
		// 		} else {
		// 			// toll x2 chance
		// 			JOptionPane.showMessageDialog(this, "���� ī�忡�� �ٰ��� ȿ�� �ߵ�!");
		// 			if (!player.payToll(nextPos)) {
		// 				/* some animation here */
		// 				return false;
		// 			} else if(!player.payToll(nextPos)){
		// 				return false;
		// 			}
		// 		}
		// 	} else if (!player.payToll(nextPos)) {
		// 		/* some animation here */
		// 		return false;
		// 	}
		
		// 	playerList.get(owner).earnMoney(cityManager.getToll(nextPos));
															
		// 	// ���� �ǹ� �ŷ��� ���� (��ư ����)
		// 	// int decision = JOptionPane.showConfirmDialog(this, "�ǹ��� �μ��Ͻðھ��?");
		// 	// if (decision == 1) {
		// 		// }
		// }
			
		playerIdx = (playerIdx + 1) % numPlayer;
		return true;
	}
	
	public void startGame() {
		// �Ļ��ϸ� while ����
		// while (turn()) {
		// 	playerIdx = (playerIdx + 1) % numPlayer;
		// }
		// try {
		// 	Thread.sleep(3000);
		// } catch(InterruptedException e) {
		// 	e.printStackTrace();
		// }
		// JOptionPane.showMessageDialog(this, ""+playerIdx+"�� �÷��̾� �Ļ�!");

		// int nextPos = playerList.get(currentPlayer).nextPosition(rollDice());
		// Coordinate coord = coordinateManager.getPlayerCoordinate(currentPlayer, nextPos);		
		
		
	}
}
