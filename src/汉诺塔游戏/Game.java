package ��ŵ����Ϸ;

import java.util.Scanner;

public class Game {

	static Scanner sc = new Scanner(System.in);

	int c = 0;

	public static void main(String[] args) {
		int n = sc.nextInt();
		long startTime = System.currentTimeMillis();    //��ȡ��ʼʱ��
		Game go = new Game();
		go.hanoi(n, 'x', 'y', 'z');
		long endTime = System.currentTimeMillis();    //��ȡ����ʱ��
		System.out.println("��������ʱ�䣺" + (endTime - startTime) + "ms");    //�����������ʱ��
	}

	public void hanoi(int n, char x, char y, char z) {
		if (n == 1) {
			move(x, 1, z);
		} else {
			hanoi(n - 1, x, z, y);
			move(x, n, z);
			hanoi(n - 1, y, x, z);
		}
	}

	public void move(char x, int n, char z) {
		System.out.println("��" + ++c + "���ƶ���" + n + "��Բ��" + x + "-->" + z);
	}
}
