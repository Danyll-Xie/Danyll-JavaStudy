package ������;

import java.util.Scanner;

public class Game_go {
	static Scanner input = new Scanner(System.in);
	private char[][] qipan = new char[3][3];// �����ά���ף���С3x3
	private byte time = 0;
	private static int cwin = 0;
	private static int pwin = 0;

	public static void main(String[] args) {
		System.out.println("--------��Ϸ��ʼ--------");
		String choose = "1";
		while ("1".equals(choose)|"0".equals(choose)) {
			if ("1".equals(choose)) {
				new Game_go().chushihua();
			}
			System.out.println("��ѡ��\t1��������Ϸ\t0���˳���Ϸ");
			choose = input.next();
			if ("0".equals(choose)) {
				return;
			} else if ("1".equals(choose)) {
				continue;
			} else {
				System.out.println("��������!");
				choose = "0";
			}
		}
	}

	/*--��ʼ������--*/
	public void chushihua() {
		for (int i = 0; i < qipan.length; i++) {
			for (int j = 0; j < qipan.length; j++) {
				qipan[i][j] = ' ';
			}
		}
		while (run()) {
		}
		System.out.println("��Ӯ��" + pwin + "�֣�\t�����Ӯ��" + cwin + "��");
	}

	/*--��ʼ���--*/
	public boolean run() {
		while (people())// ��ֹ������
		{
		}
		print();
		if (!win())// Ӯ�˷���false
		{
			System.out.println("��Ϸ����");
			return false;
		}
		while (computer())// ��ֹ������
		{
		}
		print();
		if (!win())// Ӯ�˷���false
		{
			System.out.println("��Ϸ����");
			return false;
		}
		if (time == 8) {
			System.out.println("ƽ��");
			System.out.println("��Ϸ����");
			return false;
		}
		return true;
	}

	/*--�������--*/
	public boolean people() {// ������ȷ����false
		System.out.print("��������Ҫ�ŵ�λ��(x,y):");
		int y1 = aInt();
		int x1 = aInt();
		y1--;
		x1--;
		if (0 <= x1 && 0 <= y1 && x1 < qipan.length && y1 < qipan.length && qipan[x1][y1] == ' ') {
			qipan[x1][y1] = 'X';
			return false;
		}
		System.out.println("�������");
		return true;
	}

	/*--��������--*/
	public boolean computer() {// ������ȷ����false
		/*--�����㷨--*/
		int x2 = -1;
		int y2 = -1;
		if (time == 1)// ��һ������
		{
			if (qipan[0][0] == 'X') {
				x2 = 2;
				y2 = 2;
			}
			if (qipan[2][2] == 'X') {
				x2 = 0;
				y2 = 0;
			}
			if (qipan[0][2] == 'X') {
				x2 = 2;
				y2 = 0;
			}
			if (qipan[2][0] == 'X') {
				x2 = 0;
				y2 = 2;
			}
			if (qipan[1][1] == 'X') {
				int jiaoluo = (int) Math.round(Math.random() * 4);
				if (jiaoluo == 4) {
					jiaoluo = 0;
				}
				if (jiaoluo == 1) {
					x2 = 2;
					y2 = 0;
				} else if (jiaoluo == 2) {
					x2 = 2;
					y2 = 2;
				} else if (jiaoluo == 3) {
					x2 = 0;
					y2 = 2;
				} else {
					x2 = 0;
					y2 = 0;
				}
			}
		}
		if (time == 3) {// �ڶ�������
			for (int i = 0; i < qipan.length; i++) {
				if (qipan[i][0] == ' ' & qipan[i][1] == ' ' & qipan[i][2] == 'O') {
					x2 = i;
					y2 = 0;
				} else if (qipan[i][0] == ' ' & qipan[i][2] == ' ' & qipan[i][1] == 'O') {
					int jiaoluo = (int) Math.round(Math.random() * 2);
					if (jiaoluo == 2) {
						jiaoluo = 0;
					}
					if (jiaoluo == 0) {
						x2 = i;
						y2 = 0;
					} else {
						x2 = i;
						y2 = 2;
					}
				} else if (qipan[i][1] == ' ' & qipan[i][2] == ' ' & qipan[i][0] == 'O') {
					x2 = i;
					y2 = 2;
				} else if (qipan[1][i] == ' ' & qipan[2][i] == ' ' & qipan[0][i] == 'O') {
					x2 = 2;
					y2 = i;
				} else if (qipan[0][i] == ' ' & qipan[2][i] == ' ' & qipan[1][i] == 'O') {
					int jiaoluo = (int) Math.round(Math.random() * 2);
					if (jiaoluo == 2) {
						jiaoluo = 0;
					}
					if (jiaoluo == 0) {
						x2 = 2;
						y2 = i;
					} else {
						x2 = 0;
						y2 = i;
					}
				} else if (qipan[0][i] == ' ' & qipan[1][i] == ' ' & qipan[2][i] == 'O') {
					x2 = 0;
					y2 = i;
				}
			}
			if (qipan[1][1] == ' ' & qipan[2][2] == ' ' & qipan[0][0] == 'O') {
				x2 = 0;
				y2 = 0;
			} else if (qipan[0][0] == ' ' & qipan[2][2] == ' ' & qipan[1][1] == 'O') {
				int jiaoluo = (int) Math.round(Math.random() * 2);
				if (jiaoluo == 2) {
					jiaoluo = 0;
				}
				if (jiaoluo == 0) {
					x2 = 2;
					y2 = 2;
				} else {
					x2 = 0;
					y2 = 0;
				}
			} else if (qipan[0][2] == ' ' & qipan[2][0] == ' ' & qipan[1][1] == 'O') {
				int jiaoluo = (int) Math.round(Math.random() * 2);
				if (jiaoluo == 2) {
					jiaoluo = 0;
				}
				if (jiaoluo == 0) {
					x2 = 0;
					y2 = 2;
				} else {
					x2 = 2;
					y2 = 0;
				}
			} else if (qipan[0][0] == ' ' & qipan[1][1] == ' ' & qipan[2][2] == 'O') {
				x2 = 0;
				y2 = 0;
			} else if (qipan[0][2] == ' ' & qipan[1][1] == ' ' & qipan[2][0] == 'O') {
				x2 = 0;
				y2 = 2;
			}
		} else if (qipan[1][1] == ' ' & qipan[2][0] == ' ' & qipan[0][2] == 'O') {
			x2 = 2;
			y2 = 0;
		}

		if (time == 5) {
			if (qipan[0][0] == 'O' & qipan[0][2] == 'O' & qipan[1][1] == ' ')// ��·
			{
				if (qipan[1][2] == ' ' & qipan[2][2] == ' ') {
					x2 = 2;
					y2 = 2;
				}
				if (qipan[1][0] == ' ' & qipan[2][0] == ' ') {
					x2 = 2;
					y2 = 0;
				}
			}
			if (qipan[0][0] == 'O' & qipan[2][0] == 'O' & qipan[1][1] == ' ')// ��·
			{
				if (qipan[0][1] == ' ' & qipan[0][2] == ' ') {
					x2 = 0;
					y2 = 2;
				}
				if (qipan[2][1] == ' ' & qipan[2][2] == ' ') {
					x2 = 2;
					y2 = 2;
				}
			}
			if (qipan[2][0] == 'O' & qipan[2][2] == 'O' & qipan[1][1] == ' ')// ��·
			{
				if (qipan[1][0] == ' ' & qipan[0][0] == ' ') {
					x2 = 0;
					y2 = 0;
				}
				if (qipan[1][2] == ' ' & qipan[0][2] == ' ') {
					x2 = 0;
					y2 = 2;
				}
			}
			if (qipan[2][2] == 'O' & qipan[0][2] == 'O' & qipan[1][1] == ' ')// ��·
			{
				if (qipan[0][1] == ' ' & qipan[0][0] == ' ') {
					x2 = 2;
					y2 = 2;
				}
				if (qipan[2][1] == ' ' & qipan[2][0] == ' ') {
					x2 = 2;
					y2 = 0;
				}
			}
		}

		/*--�ж϶Է��Ƿ��Ӯ--*/
		for (int i = 0; i < qipan.length; i++) {
			if (qipan[i][0] == 'X' & qipan[i][1] == 'X' & qipan[i][2] == ' ') {
				x2 = i;
				y2 = 2;
			} else if (qipan[i][0] == 'X' & qipan[i][2] == 'X' & qipan[i][1] == ' ') {
				x2 = i;
				y2 = 1;
			} else if (qipan[i][1] == 'X' & qipan[i][2] == 'X' & qipan[i][0] == ' ') {
				x2 = i;
				y2 = 0;
			} else if (qipan[1][i] == 'X' & qipan[2][i] == 'X' & qipan[0][i] == ' ') {
				x2 = 0;
				y2 = i;
			} else if (qipan[0][i] == 'X' & qipan[2][i] == 'X' & qipan[1][i] == ' ') {
				x2 = 1;
				y2 = i;
			} else if (qipan[0][i] == 'X' & qipan[1][i] == 'X' & qipan[2][i] == ' ') {
				x2 = 2;
				y2 = i;
			}
		}
		if (qipan[1][1] == 'X' & qipan[2][2] == 'X' & qipan[0][0] == ' ') {
			x2 = 0;
			y2 = 0;
		} else if (qipan[0][0] == 'X' & qipan[2][2] == 'X' & qipan[1][1] == ' ') {
			x2 = 1;
			y2 = 1;
		} else if (qipan[0][0] == 'X' & qipan[1][1] == 'X' & qipan[2][2] == ' ') {
			x2 = 2;
			y2 = 2;
		} else if (qipan[1][1] == 'X' & qipan[2][0] == 'X' & qipan[0][2] == ' ') {
			x2 = 0;
			y2 = 2;
		} else if (qipan[0][2] == 'X' & qipan[2][0] == 'X' & qipan[1][1] == ' ') {
			x2 = 1;
			y2 = 1;
		} else if (qipan[0][2] == 'X' & qipan[1][1] == 'X' & qipan[2][0] == ' ') {
			x2 = 2;
			y2 = 0;
		}
		/*--�ж��Լ��Ƿ��Ӯ--*/
		for (int i = 0; i < qipan.length; i++) {
			if (qipan[i][0] == 'O' & qipan[i][1] == 'O' & qipan[i][2] == ' ') {
				x2 = i;
				y2 = 2;
			} else if (qipan[i][0] == 'O' & qipan[i][2] == 'O' & qipan[i][1] == ' ') {
				x2 = i;
				y2 = 1;
			} else if (qipan[i][1] == 'O' & qipan[i][2] == 'O' & qipan[i][0] == ' ') {
				x2 = i;
				y2 = 0;
			} else if (qipan[1][i] == 'O' & qipan[2][i] == 'O' & qipan[0][i] == ' ') {
				x2 = 0;
				y2 = i;
			} else if (qipan[0][i] == 'O' & qipan[2][i] == 'O' & qipan[1][i] == ' ') {
				x2 = 1;
				y2 = i;
			} else if (qipan[0][i] == 'O' & qipan[1][i] == 'O' & qipan[2][i] == ' ') {
				x2 = 2;
				y2 = i;
			}
		}
		if (qipan[1][1] == 'O' & qipan[2][2] == 'O' & qipan[0][0] == ' ') {
			x2 = 0;
			y2 = 0;
		} else if (qipan[0][0] == 'O' & qipan[2][2] == 'O' & qipan[1][1] == ' ') {
			x2 = 1;
			y2 = 1;
		} else if (qipan[0][0] == 'O' & qipan[1][1] == 'O' & qipan[2][2] == ' ') {
			x2 = 2;
			y2 = 2;
		} else if (qipan[1][1] == 'O' & qipan[2][0] == 'O' & qipan[0][2] == ' ') {
			x2 = 0;
			y2 = 2;
		} else if (qipan[0][2] == 'O' & qipan[2][0] == 'O' & qipan[1][1] == ' ') {
			x2 = 1;
			y2 = 1;
		} else if (qipan[0][2] == 'O' & qipan[1][1] == 'O' & qipan[2][0] == ' ') {
			x2 = 2;
			y2 = 0;
		}
		// x2,y2û�и�ֵʱ�����ֵ
		if (x2 == -1 & y2 == -1) {
			x2 = (int) Math.round(Math.random() * 3);
			y2 = (int) Math.round(Math.random() * 3);
			if (x2 == 3) {
				x2 = 0;
			}
			if (y2 == 3) {
				y2 = 0;
			}
		}
		if (time == 9) {
			return false;
		}
		if (x2 <= qipan.length && y2 <= qipan.length && qipan[x2][y2] == ' ') {
			qipan[x2][y2] = 'O';
			System.out.println("������ŵ�λ���ǣ���" + (y2 + 1) + "��" + (x2 + 1) + "��");
			return false;// ������ȷ
		}
		return true;
	}

	/*--�ж���Ϸ�Ƿ����--*/
	public boolean win() {
		for (int i = 0; i < qipan.length; i++) {
			byte hengX = 0;
			byte hengO = 0;
			byte shuX = 0;
			byte shuO = 0;
			for (int j = 0; j < qipan.length; j++) {
				if (qipan[i][j] == 'X') {
					hengX++;
				}
				if (qipan[i][j] == 'O') {
					hengO++;
				}
				if (qipan[j][i] == 'X') {
					shuX++;
				}
				if (qipan[j][i] == 'O') {
					shuO++;
				}
			}
			if (hengX == 3 || shuX == 3) {
				System.out.println("���ʤ��");
				pwin++;
				return false;
			}
			if (hengO == 3 || shuO == 3) {
				System.out.println("�����ʤ��");
				cwin++;
				return false;
			}
		}
		byte zuoxieO = 0;
		byte zuoxieX = 0;
		byte youxieO = 0;
		byte youxieX = 0;
		for (int i = 0; i < qipan.length; i++) {
			if (qipan[i][2 - i] == 'X') {
				zuoxieX++;
			}
			if (qipan[i][2 - i] == 'O') {
				zuoxieO++;
			}
			if (qipan[i][i] == 'X') {
				youxieX++;
			}
			if (qipan[i][i] == 'O') {
				youxieO++;
			}
		}
		if (zuoxieX == 3 || youxieX == 3) {
			System.out.println("���ʤ��");
			return false;
		}
		if (zuoxieO == 3 || youxieO == 3) {
			System.out.println("�����ʤ��");
			return false;
		}

		time = 0;
		for (int i = 0; i < qipan.length; i++) {
			for (int j = 0; j < qipan.length; j++) {
				if (qipan[i][j] != ' ') {
					time++;
				}
			}
		}
		if (time == 9) {
			return false;
		}
		return true;
	}

	/*--��ӡս��--*/
	public void print() {
		for (int i = 2; i >= 0; i--) {
			System.out.print((i + 1) + "|");
			for (int j = 0; j < qipan.length; j++) {
				System.out.print(qipan[i][j] + "|");
			}
			System.out.println();
		}
		System.out.println("  1 2 3");

	}

	public static int aInt() {
		int aInt = 0;
		while (true) {
			try {
				String aString = input.next();
				aInt = Integer.parseInt(aString);
				return aInt;
			} catch (Exception e) {
				System.out.println("���������������룺");
			}
		}
	}
}