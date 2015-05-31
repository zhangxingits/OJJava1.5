package com.zx.testCode;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Problems {

	/**
	 * DecimalFormat的用法 Java 浮点数 Float Double 小数 格式化 保留小数位后几位等
	 */
	public static void testDecimalFormat() {
		DecimalFormat df = new DecimalFormat();
		double data = 1234.56789;
		System.out.println("格式化之前的数字: " + data);
		String style = "0.0";// 定义要显示的数字的格式
		df.applyPattern(style);// 将格式应用于格式化器
		System.out.println("采用style: " + style + "格式化之后: " + df.format(data));
		style = "00000.000 kg";// 在格式后添加诸如单位等字符
		df.applyPattern(style);
		System.out.println("采用style: " + style + "格式化之后: " + df.format(data));
		// 模式中的"#"表示如果该位存在字符，则显示字符，如果不存在，则不显示。
		style = "##000.000 kg";
		df.applyPattern(style);
		System.out.println("采用style: " + style + "格式化之后: " + df.format(data));
		// 模式中的"-"表示输出为负数，要放在最前面
		style = "-000.000";
		df.applyPattern(style);
		System.out.println("采用style: " + style + "格式化之后: " + df.format(data));
		// 模式中的","在数字中添加逗号，方便读数字
		style = "-0,000.0#";
		df.applyPattern(style);
		System.out.println("采用style: " + style + "格式化之后: " + df.format(data));
		// 模式中的"E"表示输出为指数，"E"之前的字符串是底数的格式，
		// "E"之后的是字符串是指数的格式
		style = "0.00E000";
		df.applyPattern(style);
		System.out.println("采用style: " + style + "格式化之后: " + df.format(data));
		// 模式中的"%"表示乘以100并显示为百分数，要放在最后。
		style = "0.00%";
		df.applyPattern(style);
		System.out.println("采用style: " + style + "格式化之后: " + df.format(data));
		// 模式中的"\u2030"表示乘以1000并显示为千分数，要放在最后。
		style = "0.00\u2030";
		// 在构造函数中设置数字格式
		DecimalFormat df1 = new DecimalFormat(style);
		// df.applyPattern(style);
		System.out.println("采用style: " + style + "格式化之后: " + df1.format(data));

		double a = 3.123456789, b;
		a = (int) (a * 1000000);
		int t=(int) (a/1000000);
		if ( t >= 5)
			a = a + 1;
		b = a * 0.000001;
		System.out.println("精度控制：" + b); // 输出：   精度控制：3.123456
		
		long x=(long)(3.1314926*1000);
    	System.out.println(x/1000d);
	}

	/**
	 * 一个整数加上100后是一个完全平方数，再加上168又是一个完全平方数，求该数
	 */
	public static void sqrtNum() {
		for (int i = 1; i < 100000; i++) {
			if (Math.sqrt(i + 100) % 1 == 0) {
				if (Math.sqrt(i + 268) % 1 == 0) {
					System.out
							.printf("%1$5d 加上100后是一个完全平方数，再加上168又是一个完全平方数", i);
					System.out.print("\n");
				}
			}
		}
	}

	/**
	 * 测试 switch-case
	 */
	public static void swiCase() {
		int m, d, y = 2004;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("请输入月份：");
			m = sc.nextInt();
			switch (m) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				d = 31;
				break;
			case 2:
				d = 29;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				d = 30;
				break;
			default:
				d = -1;
			}
			if (d != -1) {
				System.out.printf("天数 d=%3d", d);
			} else {
				System.out.printf("%1$s", "输入月份不对！");
			}
			System.out.println();
		}
	}

	/**
	 * 将M行M列的二维数组中的数据, 将其主对角线与反对象线的元素依次放到一维数组中
	 */
	public static void changeMatrix() {
		int[][] w = { { 90, 78, 10 }, { 43, 78, 19 }, { 12, 34, 56 } };
		int[] a = new int[100];
		int i, j;
		for (i = 0; i < a.length; i++) {
			a[i] = 0;
		}
		int n = 0;
		System.out.print("The matrix:\n");
		for (i = 0; i < w.length; i++) {
			for (j = 0; j < w.length; j++) {
				System.out.print(String.format("%1$3d", w[i][j]));
			}
			System.out.print("\n");
		}
		n = fun(w, a, w.length, w.length);
		System.out.print("The A array:\n");
		for (i = 0; i < n; i++) {
			System.out.print(String.format("%3d", a[i]));
		}
		System.out.print("\n\n");
	}

	public static int fun(int[][] w, int[] a, int m, int n) {
		int num = m + n, l = 0;
		for (int i = 0; i < m; i++) {
			a[l] = w[i][i];
			l++;
		}
		for (int i = 0; i < m; i++) {
			a[l] = w[i][m - 1 - i];
			l++;
		}
		return num;
	}

	/**
	 * 回文数，比如：12321
	 */
	public static void huiwen1() {
		Scanner sc = new Scanner(System.in);
		int n;
		do {
			System.out.println("请输入一个五位数：");
			n = sc.nextInt();
		} while (n < 10000 || n > 99999);
		String str = String.valueOf(n);
		char[] ch = str.toCharArray();
		if (ch[0] == ch[4] && ch[1] == ch[3]) {
			System.out.println(n + "是一个回文数！");
		} else {
			System.out.println(n + "不是一个回文数！");
		}
	}

	/**
	 * 回文数(不限位数)，比如：12321
	 */
	public static void huiwen2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个数：");
		long n = sc.nextLong();
		String str = String.valueOf(n);
		// String str=Long.toString(a);
		char[] ch = str.toCharArray();
		int j = ch.length;
		boolean f = true;
		for (int i = 0; i < j / 2; i++) {
			if (ch[i] != ch[j - 1 - i]) {
				f = false;
				break;
			}
		}
		if (f) {
			System.out.println(n + "是一个回文数！");
		} else {
			System.out.println(n + "不是一个回文数！");
		}
	}

	/**
	 * 求S=a+aa+aaa+aaaa+aa...a的值，其中a是一个数
	 */
	public static void aaa() {
		long b = 0, s = 0;
		int a, n;
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入数字a:");
		a = sc.nextInt();
		System.out.println("请输入相加的项数：");
		n = sc.nextInt();
		while (n > 0) {
			b += a;
			s += b;
			a *= 10;
			n--;
		}
		System.out.println("结果和是：" + s);
	}

	/**
	 * 统计一段字符串的数字，字母，空格和其他字符的个数
	 */
	public static void tongji() {
		int digital = 0;
		int character = 0;
		int blank = 0;
		int other = 0;
		char[] ch = null;
		System.out.print("请输入一行字符串：");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		ch = str.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] >= '0' && ch[i] <= '9') {
				digital++;
			} else if (ch[i] == ' ') {
				blank++;
			} else if ((ch[i] >= 'a' && ch[i] <= 'z')
					|| (ch[i] >= 'A' && ch[i] <= 'Z')) {
				character++;
			} else {
				other++;
			}
		}
		System.out.println("数字个数是：" + digital + "  字母个数是：" + character
				+ "  空格个数是：" + blank + "  其他字符：" + other);
	}

	/**
	 * 输入两个正整数m和n，求其最大公约数和最小公倍数
	 */
	public static void zuidaxiao() {
		int a, b, m;
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入第一个数：");
		a = sc.nextInt();
		System.out.print("请输入第二个数：");
		b = sc.nextInt();
		m = a * b;
		if (a < b) {
			int t = b;
			b = a;
			a = t;
		}

		while (b != 0) {
			int t = b;
			b = a % b;
			a = t;
		}
		System.out.println("最大公约数是：" + a + "  最小公倍数是：" + (m / a));

	}

	/**
	 * 将一个正数分解质因数
	 */
	public static void fenjie() {
		Scanner sc = new Scanner(System.in);
		System.out.print("请键入一个正整数：");
		int n = sc.nextInt();
		int k = 2;
		System.out.print(n + "=");
		while (k <= n) {
			if (k == n) {
				System.out.println(n);
				break;
			} else if (n % k == 0) {
				System.out.print(k + "*");
				n = n / k;
			} else {
				k++;
			}
		}
	}

	/**
	 * 判断101-200之间的素数 判断素数的方法：用一个数分别去除2到 sqrt(这个数)，如果能被整除，则表明此树不是素数，反之是素数
	 */
	public static void sushu() {
		for (int n = 101; n < 200; n++) {
			boolean flag = true;// 默认假设是素数
			for (int k = 2; k <= Math.sqrt(n); k++) {
				if (n % k == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.print(n + ",");
			}
		}
	}

	/**
	 * 兔子（斐波那契数列问题）
	 */
	public static void Fib() {
		int n;
		System.out.println("请输入你要查询的月份：");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		if (n == 1) {
			System.out.println("第1个月兔子对数为：1");
		} else if (n == 2) {
			System.out.println("第2个月兔子对数为：1");
		} else {
			int m = 3, m1 = 1, m2 = 1, f = m1 + m2;
			while (m <= n) {
				f = m1 + m2;
				m1 = m2;
				m2 = f;
				m++;
			}
			System.out.println("第" + n + "个月的兔子总数为：" + f);
		}

	}

}
