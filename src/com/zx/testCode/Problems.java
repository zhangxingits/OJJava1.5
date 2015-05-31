package com.zx.testCode;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Problems {

	/**
	 * DecimalFormat���÷� Java ������ Float Double С�� ��ʽ�� ����С��λ��λ��
	 */
	public static void testDecimalFormat() {
		DecimalFormat df = new DecimalFormat();
		double data = 1234.56789;
		System.out.println("��ʽ��֮ǰ������: " + data);
		String style = "0.0";// ����Ҫ��ʾ�����ֵĸ�ʽ
		df.applyPattern(style);// ����ʽӦ���ڸ�ʽ����
		System.out.println("����style: " + style + "��ʽ��֮��: " + df.format(data));
		style = "00000.000 kg";// �ڸ�ʽ��������絥λ���ַ�
		df.applyPattern(style);
		System.out.println("����style: " + style + "��ʽ��֮��: " + df.format(data));
		// ģʽ�е�"#"��ʾ�����λ�����ַ�������ʾ�ַ�����������ڣ�����ʾ��
		style = "##000.000 kg";
		df.applyPattern(style);
		System.out.println("����style: " + style + "��ʽ��֮��: " + df.format(data));
		// ģʽ�е�"-"��ʾ���Ϊ������Ҫ������ǰ��
		style = "-000.000";
		df.applyPattern(style);
		System.out.println("����style: " + style + "��ʽ��֮��: " + df.format(data));
		// ģʽ�е�","����������Ӷ��ţ����������
		style = "-0,000.0#";
		df.applyPattern(style);
		System.out.println("����style: " + style + "��ʽ��֮��: " + df.format(data));
		// ģʽ�е�"E"��ʾ���Ϊָ����"E"֮ǰ���ַ����ǵ����ĸ�ʽ��
		// "E"֮������ַ�����ָ���ĸ�ʽ
		style = "0.00E000";
		df.applyPattern(style);
		System.out.println("����style: " + style + "��ʽ��֮��: " + df.format(data));
		// ģʽ�е�"%"��ʾ����100����ʾΪ�ٷ�����Ҫ�������
		style = "0.00%";
		df.applyPattern(style);
		System.out.println("����style: " + style + "��ʽ��֮��: " + df.format(data));
		// ģʽ�е�"\u2030"��ʾ����1000����ʾΪǧ������Ҫ�������
		style = "0.00\u2030";
		// �ڹ��캯�����������ָ�ʽ
		DecimalFormat df1 = new DecimalFormat(style);
		// df.applyPattern(style);
		System.out.println("����style: " + style + "��ʽ��֮��: " + df1.format(data));

		double a = 3.123456789, b;
		a = (int) (a * 1000000);
		int t=(int) (a/1000000);
		if ( t >= 5)
			a = a + 1;
		b = a * 0.000001;
		System.out.println("���ȿ��ƣ�" + b); // �����   ���ȿ��ƣ�3.123456
		
		long x=(long)(3.1314926*1000);
    	System.out.println(x/1000d);
	}

	/**
	 * һ����������100����һ����ȫƽ�������ټ���168����һ����ȫƽ�����������
	 */
	public static void sqrtNum() {
		for (int i = 1; i < 100000; i++) {
			if (Math.sqrt(i + 100) % 1 == 0) {
				if (Math.sqrt(i + 268) % 1 == 0) {
					System.out
							.printf("%1$5d ����100����һ����ȫƽ�������ټ���168����һ����ȫƽ����", i);
					System.out.print("\n");
				}
			}
		}
	}

	/**
	 * ���� switch-case
	 */
	public static void swiCase() {
		int m, d, y = 2004;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("�������·ݣ�");
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
				System.out.printf("���� d=%3d", d);
			} else {
				System.out.printf("%1$s", "�����·ݲ��ԣ�");
			}
			System.out.println();
		}
	}

	/**
	 * ��M��M�еĶ�ά�����е�����, �������Խ����뷴�����ߵ�Ԫ�����ηŵ�һά������
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
	 * �����������磺12321
	 */
	public static void huiwen1() {
		Scanner sc = new Scanner(System.in);
		int n;
		do {
			System.out.println("������һ����λ����");
			n = sc.nextInt();
		} while (n < 10000 || n > 99999);
		String str = String.valueOf(n);
		char[] ch = str.toCharArray();
		if (ch[0] == ch[4] && ch[1] == ch[3]) {
			System.out.println(n + "��һ����������");
		} else {
			System.out.println(n + "����һ����������");
		}
	}

	/**
	 * ������(����λ��)�����磺12321
	 */
	public static void huiwen2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ������");
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
			System.out.println(n + "��һ����������");
		} else {
			System.out.println(n + "����һ����������");
		}
	}

	/**
	 * ��S=a+aa+aaa+aaaa+aa...a��ֵ������a��һ����
	 */
	public static void aaa() {
		long b = 0, s = 0;
		int a, n;
		Scanner sc = new Scanner(System.in);
		System.out.println("����������a:");
		a = sc.nextInt();
		System.out.println("��������ӵ�������");
		n = sc.nextInt();
		while (n > 0) {
			b += a;
			s += b;
			a *= 10;
			n--;
		}
		System.out.println("������ǣ�" + s);
	}

	/**
	 * ͳ��һ���ַ��������֣���ĸ���ո�������ַ��ĸ���
	 */
	public static void tongji() {
		int digital = 0;
		int character = 0;
		int blank = 0;
		int other = 0;
		char[] ch = null;
		System.out.print("������һ���ַ�����");
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
		System.out.println("���ָ����ǣ�" + digital + "  ��ĸ�����ǣ�" + character
				+ "  �ո�����ǣ�" + blank + "  �����ַ���" + other);
	}

	/**
	 * ��������������m��n���������Լ������С������
	 */
	public static void zuidaxiao() {
		int a, b, m;
		Scanner sc = new Scanner(System.in);
		System.out.print("�������һ������");
		a = sc.nextInt();
		System.out.print("������ڶ�������");
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
		System.out.println("���Լ���ǣ�" + a + "  ��С�������ǣ�" + (m / a));

	}

	/**
	 * ��һ�������ֽ�������
	 */
	public static void fenjie() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�����һ����������");
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
	 * �ж�101-200֮������� �ж������ķ�������һ�����ֱ�ȥ��2�� sqrt(�����)������ܱ����������������������������֮������
	 */
	public static void sushu() {
		for (int n = 101; n < 200; n++) {
			boolean flag = true;// Ĭ�ϼ���������
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
	 * ���ӣ�쳲������������⣩
	 */
	public static void Fib() {
		int n;
		System.out.println("��������Ҫ��ѯ���·ݣ�");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		if (n == 1) {
			System.out.println("��1�������Ӷ���Ϊ��1");
		} else if (n == 2) {
			System.out.println("��2�������Ӷ���Ϊ��1");
		} else {
			int m = 3, m1 = 1, m2 = 1, f = m1 + m2;
			while (m <= n) {
				f = m1 + m2;
				m1 = m2;
				m2 = f;
				m++;
			}
			System.out.println("��" + n + "���µ���������Ϊ��" + f);
		}

	}

}
