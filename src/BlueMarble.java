import java.io.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BlueMarble {

	public static final int SCREEM_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 600;
	
	public static void main(String[] args) {
		BoardGUI a = new BoardGUI();

		
		
		
		
		//�÷��̾� ���� �Է� �޴� �ܰ�
		int num_player = 0;	//�÷��̾� ��
		Player[] player_list = new Player[4]; //�÷��̾� ����Ʈ ����
		try {
			Scanner scan = new Scanner(System.in);
			do{
				num_player = scan.nextInt();
				//���� numPlayer�� ��ȿ���� ���� �ƴϸ� ���â ���� ���� �߰��ϱ�
			}while( !(num_player >=1 && num_player <=4) );
			for(int i = 0; i < num_player; i++) {
				
				
			}
			
			
		}catch(Exception e) {
			
		}
		
		
		//�÷��̾���� �̸��� �Է� �޴� �ܰ�

	}

}
