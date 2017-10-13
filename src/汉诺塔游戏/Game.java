package 汉诺塔游戏;

import java.util.Scanner;

public class Game {

	static Scanner sc = new Scanner(System.in);

	int c = 0;

	public static void main(String[] args) {
		int n = sc.nextInt();
		long startTime = System.currentTimeMillis();    //获取开始时间
		Game go = new Game();
		go.hanoi(n, 'x', 'y', 'z');
		long endTime = System.currentTimeMillis();    //获取结束时间
		System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
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
		System.out.println("第" + ++c + "次移动：" + n + "号圆盘" + x + "-->" + z);
	}
}
