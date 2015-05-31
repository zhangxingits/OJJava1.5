package com.zx.testCode;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String willDo=scanner.nextLine();
		String done=scanner.nextLine();
		StringBuffer sbBuffer=new StringBuffer();
		for (int i = 0; i < willDo.length(); i++) {
			Character character=willDo.charAt(i);
			if (Character.isDigit(character)) {
				int n=Integer.parseInt(character+"");
				n++;
				if (n==10) {
					n=0;
				}
				sbBuffer.append(n);
			}else {
				if (character=='z') {
					character='A';
				}else if (character=='Z') {
					character='a';
				}else {
					character++;
					if (Character.isUpperCase(character)) {
						character = Character.toLowerCase(character);
					}else {
						character = Character.toUpperCase(character);
					}
				}
				sbBuffer.append(character);
			}
		}
		System.out.println(sbBuffer.toString());
		sbBuffer.delete(0, willDo.length());
		for (int i = 0; i < done.length(); i++) {
			Character character=done.charAt(i);
			if (Character.isDigit(character)) {
				int n=Integer.parseInt(character+"");
				n--;
				if (n==-1) {
					n=9;
				}
				sbBuffer.append(n+"");
			}else {
				if (character=='a') {
					character='Z';
				}else if (character=='A') {
					character='z';
				}else {
					character--;
					if (Character.isUpperCase(character)) {
						character=Character.toLowerCase(character);
					}else {
						character=Character.toUpperCase(character);
					}
				}
				sbBuffer.append(character);
			}
		}
		System.out.println(sbBuffer.toString());
	}
}

class Test {
	//�ַ�������
	public static void zifuchuanjiami() {
		Scanner scanner=new Scanner(System.in);
		String willDo=scanner.nextLine();
		String done=scanner.nextLine();
		StringBuffer sbBuffer=new StringBuffer();
		for (int i = 0; i < willDo.length(); i++) {
			Character character=willDo.charAt(i);
			if (Character.isDigit(character)) {
				int n=Integer.parseInt(character+"");
				n++;
				if (n==10) {
					n=0;
				}
				sbBuffer.append(n);
			}else {
				if (character=='z') {
					character='A';
				}else if (character=='Z') {
					character='a';
				}else {
					character++;
					if (Character.isUpperCase(character)) {
						character = Character.toLowerCase(character);
					}else {
						character = Character.toUpperCase(character);
					}
				}
				sbBuffer.append(character);
			}
		}
		System.out.println(sbBuffer.toString());
		sbBuffer.delete(0, willDo.length());
		for (int i = 0; i < done.length(); i++) {
			Character character=done.charAt(i);
			if (Character.isDigit(character)) {
				int n=Integer.parseInt(character+"");
				n--;
				if (n==-1) {
					n=9;
				}
				sbBuffer.append(n+"");
			}else {
				if (character=='a') {
					character='Z';
				}else if (character=='A') {
					character='z';
				}else {
					character--;
					if (Character.isUpperCase(character)) {
						character=Character.toLowerCase(character);
					}else {
						character=Character.toUpperCase(character);
					}
				}
				sbBuffer.append(character);
			}
		}
		System.out.println(sbBuffer.toString());
	}

	public static int count = 0;

	// �鲢����
	public static void mergeSort(int[] a) {
		if (a.length > 1) {
			int left = a.length / 2;
			int right = a.length - left;
			int[] leArr = new int[left];
			int[] reArr = new int[right];
			for (int i = 0; i < a.length; i++) {
				if (i < left) {
					leArr[i] = a[i];
				} else {
					reArr[i - left] = a[i];
				}
			}
			mergeSort(leArr);
			mergeSort(reArr);
			Merge(leArr, reArr, a);
			// System.out.print("sum="+sum+"  ");
		}
	}

	// �ϲ�
	public static void Merge(int[] a, int[] b, int[] c) {
		int i = 0, j = 0, k = 0;
		while (i < a.length && j < b.length) {
			if (a[i] <= b[j]) {
				c[k] = a[i];
				Test.count += j;
				i++;
			} else {
				c[k] = b[j];
				j++;
			}
			k++;
		}
		if (i == a.length) {
			for (int k2 = j; k2 < b.length; k2++) {
				c[k] = b[k2];
				k++;
			}
		} else {
			for (int k2 = i; k2 < a.length; k2++) {
				c[k] = a[k2];
				k++;
				Test.count += b.length;
			}
		}
	}

	// ������ת16����
	public static String binaryString2hexString(String bString) {
		if (bString == null || bString.equals("") || bString.length() % 8 != 0)
			return null;
		StringBuffer tmp = new StringBuffer();
		int iTmp = 0;
		for (int i = 0; i < bString.length(); i += 4) {
			iTmp = 0;
			for (int j = 0; j < 4; j++) {
				iTmp += Integer.parseInt(bString.substring(i + j, i + j + 1)) << (4 - j - 1);
			}
			tmp.append(Integer.toHexString(iTmp));
		}
		return tmp.toString();
	}

	// 16����ת������
	public static String hexString2binaryString(String hexString) {
		if (hexString == null || hexString.length() % 2 != 0)
			return null;
		String bString = "", tmp;
		for (int i = 0; i < hexString.length(); i++) {
			tmp = "0000"
					+ Integer.toBinaryString(Integer.parseInt(
							hexString.substring(i, i + 1), 16));
			bString += tmp.substring(tmp.length() - 4);
		}
		return bString;
	}

	/* �ַ����ϲ����� */
	public static void zifuchuanHebin() {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		if (!string.isEmpty()) {
			char[] charStr = string.toCharArray();
			int jiLen = (int) Math.floor(string.length() / 2);
			char[] jiInd = new char[jiLen];
			char[] ouInd = new char[string.length() - jiLen];
			int ou = 0, ji = 0;
			for (int i = 0; i < charStr.length; i++) {
				if (i % 2 == 0) {
					ouInd[ou++] = charStr[i];
				} else {
					jiInd[ji++] = charStr[i];
				}
			}
			QuickCharSort(ouInd, 0, ouInd.length - 1);
			QuickCharSort(jiInd, 0, jiLen - 1);

			ou = 0;
			ji = 0;
			for (int i = 0; i < charStr.length; i++) {
				if (i % 2 == 0) {
					charStr[i] = ouInd[ou++];
				} else {
					charStr[i] = jiInd[ji++];
				}
			}
			string = String.valueOf(charStr);

			Map<String, String> map = new HashMap<String, String>();
			for (int i = 0; i < 10; i++) {
				map.put(i + "", hexString(i + ""));
			}
			for (char i = 'A'; i < 'G'; i++) {
				map.put(i + "", hexString(i + ""));
			}
			StringBuffer sBuffer = new StringBuffer("");
			for (int i = 0; i < string.length(); i++) {
				String key = (string.charAt(i) + "").toUpperCase();
				if (map.containsKey(key)) {
					String value = reverse(map.get(key));
					Set<Entry<String, String>> set = map.entrySet();
					for (Entry<String, String> entry : set) {
						if (entry.getValue().equals(value)) {
							sBuffer.append(entry.getKey());
						}
					}
				} else {
					sBuffer.append(string.charAt(i));
				}
			}
			System.out.print(sBuffer);

		}
	}

	public static String reverse(String str) {
		char[] strs = str.toCharArray();
		str = "";
		for (int i = strs.length - 1; i >= 0; i--) {
			str += (strs[i] + "");
		}
		return str;
	}

	public static String hexString(String str) {
		String string = "0000"
				+ Integer.toBinaryString(Integer.parseInt(str, 16));
		string = string.substring(string.length() - 4);
		return string;
	}

	/* �ַ����������� */
	public static void QuickCharSort(char[] R, int l, int r) {
		if (l < r) {
			char temp;
			int i = l, j = r;
			temp = R[i]; // ͨ��tem�ڳ�һ����ȱR[i],temp��ʱ�����ֵ

			while (i < j) { // �ҵ��ұߵ�һ����tempС������j�������±�
				while (i < j && R[j] >= temp) {
					j--;
				}
				if (i < j) {
					R[i++] = R[j];// ����ֵ�Ƶ�R[i]��ȱλ�ã�i����
				}
				while (i < j && R[i] <= temp) {
					i++;
				}
				if (i < j) {
					R[j--] = R[i];// ����ֵ�Ƶ�R[j]��ȱλ�ã�jǰ�ƣ��ֲ���һ����ȱλ
				}
			}
			R[i] = temp;
			QuickCharSort(R, l, i - 1);// �ݹ��������н�������
			QuickCharSort(R, i + 1, r);// �ݹ���Ҷ����н�������
		}
	}

	// ȫ����(�ݹ�ʵ��)
	public static void diguiFull(int array[], int k, int n) {
		int temp;
		if (k == n - 1) {
			print(array);// k��n-1��ȣ���һ�˵ݹ�����
		} else {
			for (int i = k; i < array.length; i++) {// �ѵ�ǰ�ڵ�Ԫ��������ڵ�Ԫ�ؽ���
				// ����
				temp = array[k];
				array[k] = array[i];
				array[i] = temp;
				// ����һ���ڵ�Ԫ��������ڵ�Ԫ�ؽ���
				diguiFull(array, k + 1, n);
				// �ָ�ԭ״
				temp = array[i];
				array[i] = array[k];
				array[k] = temp;
			}
		}
	}

	// ��ӡ�𳵽�վ����
	private static void print(int out[]) {
		int m;
		boolean flag = true;
		int[] b = new int[2];
		for (int i = 0; i < out.length; i++) {/* ��ÿ��out[i] �ж�������С�����Ƿ�Ϊ�������� */
			m = 0;
			for (int j = i + 1; j < out.length && flag; j++) {
				if (out[i] > out[j]) {
					if (m == 0) {
						b[m++] = out[j];// ��¼str[i]�����С����
					} else {
						// ���֮����ֵ����ȼ�¼�������󣬸ı��Ǳ���
						if (b[0] < out[j]) {
							flag = false;
						} else {
							// �����¼�����С����
							b[0] = out[j];
						}
					}
				}
			}
		}
		if (flag) {/* �����ջ��������� str[] �е����� */
			for (int i = 0; i < out.length - 1; i++) {
				System.out.print(out[i] + " ");
			}
			System.out.println(out[out.length - 1]);
		}
	}

	// ��ӡȫ���У�ȫ����
	// private static void print(int out[]) {
	// for (int i = 0; i < out.length-1; i++) {
	// System.out.print(out[i]+" ");
	// }
	// System.out.println(out[out.length-1]);
	// }

	private static void outprint(Stack<Integer> q) {
		for (int i = q.size() - 1; i >= 0; i--) {
			System.out.print(q.get(i) + " ");
		}
		System.out.println();// ����
		return;
	}

	/**
	 * q:�����ջ���� t:����ģ����ջ���� o:���ڴ�ſ��ܵĳ�ջ����
	 * 
	 * @param q
	 * @param t
	 * @param o
	 */
	private static void allPopSeq(Stack<Integer> q, Stack<Integer> t,
			Stack<Integer> o, final int n) {
		if ((q.size() == 0) && (t.size() == 0) && (o.size() == n)) {
			outprint(o);
			return;
		}
		if (q.size() != 0) {// ��ջ
			int v = q.peek();
			t.push(v);
			q.pop();
			allPopSeq(q, t, o, n);
			t.pop();
			q.push(v);// ���ݻָ�
		}
		if (t.size() != 0) {// ��ջ
			int v = t.peek();
			t.pop();
			o.push(v);
			allPopSeq(q, t, o, n);
			o.pop();
			t.push(v);// ���ݻָ�
		}
		return;
	}

	public static void huocheJinzhan() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		if (n > 0 && n < 10) {
			// ջ
			Stack<Integer> qStack = new Stack<Integer>();// �����ջ����
			Stack<Integer> tStack = new Stack<Integer>();// ����ģ����ջ����
			Stack<Integer> output = new Stack<Integer>();// ���ڴ�ſ��ܵĳ�ջ����
			for (int i = 0; i < n; i++) {
				int temp = scanner.nextInt();
				if (temp > 0 && temp < 10) {
					qStack.push(temp);
				}
			}
			// System.out.println(qStack.get(2));
			allPopSeq(qStack, tStack, output, n);
		}
	}

	/* �������� */
	public static void QuickSort(int[] R, int l, int r) {
		if (l < r) {
			int temp;
			int i = l, j = r;
			temp = R[i]; // ͨ��tem�ڳ�һ����ȱR[i],temp��ʱ�����ֵ

			while (i < j) { // �ҵ��ұߵ�һ����tempС������j�������±�
				while (i < j && R[j] >= temp) {
					j--;
				}
				if (i < j) {
					R[i++] = R[j];// ����ֵ�Ƶ�R[i]��ȱλ�ã�i����
				}
				while (i < j && R[i] <= temp) {
					i++;
				}
				if (i < j) {
					R[j--] = R[i];// ����ֵ�Ƶ�R[j]��ȱλ�ã�jǰ�ƣ��ֲ���һ����ȱλ
				}
			}
			R[i] = temp;
			QuickSort(R, l, i - 1);// �ݹ��������н�������
			QuickSort(R, i + 1, r);// �ݹ���Ҷ����н�������
		}
	}

	/* �Ǹ����� */
	public static void jifujunzheng() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> num = new ArrayList<Integer>();
		int f = 0, z = 0, zn = 0;

		String strNum = br.readLine();
		while (!strNum.trim().isEmpty()) {
			num.add(Integer.parseInt(strNum));
			strNum = br.readLine();
		}

		if (num.size() != 0) {
			for (int i = 0; i < num.size(); i++) {
				if (num.get(i) < 0) {
					f++;
				} else {
					z += num.get(i);
					zn++;
				}
			}

			if (zn != 0) {
				BigDecimal bigDecimal = new BigDecimal(z);
				BigDecimal b = new BigDecimal(zn);
				System.out.println(f);
				System.out.println((bigDecimal.divide(b, 1,
						BigDecimal.ROUND_HALF_UP)));
			} else {
				System.out.println(f);
				System.out.println(0.0);
			}
		} else {
			System.out.println(f);
			System.out.println(0.0);
		}
	}

	/* ������������������ʶ������Ԫ�ذ����������������� */
	public static void sortByFlag() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] numArr = br.readLine().split(" ");
		final int f = Integer.parseInt(br.readLine());
		// /////// Arrays.sort(des);
		List<Integer> nums = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			nums.add(Integer.parseInt(numArr[i]));
		}
		Collections.sort(nums, new Comparator<Integer>() {
			public int compare(Integer n1, Integer n2) {
				if (f == 0) {// ����
					if (n1 > n2) {
						return 1;
					} else {
						return -1;
					}
				} else {
					if (n1 > n2) {
						return -1;
					} else {
						return 1;
					}
				}
			}
		});
		for (int i = 0; i < (n - 1); i++) {
			System.out.print(nums.get(i) + " ");
		}
		System.out.print(nums.get(n - 1));

	}

	/* �������һ��ż����ӽ����������� */
	public static void findShushu() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		br.close();
		int n = Integer.parseInt(num);
		if (n % 2 == 0 && n > 2) {
			List<Integer> shushu = new ArrayList<Integer>();
			for (int i = 2; i < n; i++) {
				boolean f = false;
				for (int j = 2; j <= Math.sqrt(i); j++) {
					if (i % j == 0) {
						f = true;
						break;
					}
				}
				if (!f) {
					shushu.add(i);
				}
			}
			int s1 = 2, s2 = 2, min = n, f = 0;

			for (int i = 0; i < shushu.size(); i++) {

				int cha = n - shushu.get(i);
				if (shushu.contains(cha)) {
					f++;
					if (f > 1) {
						if (min > Math.abs((cha - shushu.get(i)))) {
							s1 = shushu.get(i);
							s2 = cha;
							min = Math.abs((s1 - s2));
						}
					} else {
						s1 = shushu.get(i);
						s2 = cha;
						min = Math.abs((s1 - s2));
					}
				}
			}
			System.out.println(s1 + " " + s2);
		}
	}

	/* �˿��ƴ�С */
	public static void pukepai() throws IOException {
		final String[] pk = { "3", "4", "5", "6", "7", "8", "9", "10", "J",
				"Q", "K", "A", "2", "joker", "JOKER" };
		List list = new ArrayList<String>();
		for (int i = 0; i < pk.length; i++) {
			list.add(pk[i]);
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String twoPuke = br.readLine();
		String[] tPukes = twoPuke.split("-");
		if (tPukes.length == 2 && tPukes[0] != tPukes[1]) {
			boolean flag = true;
			String[] puke1 = tPukes[0].split(" ");// ÿ����
			String[] puke2 = tPukes[1].split(" ");
			int i1 = 0, i2 = 0;
			if (puke1.length == puke2.length && puke1.length <= 5) {//
				i1 = list.indexOf(puke1[0]);
				i2 = list.indexOf(puke2[0]);
				flag = (i1 > i2 ? true : false);
			} else if (puke1.length != puke2.length) {
				if (puke1.length == 2
						&& (puke1[0].equals("joker") || puke1[0]
								.equals("JOKER"))) {
					flag = true;
				} else if (puke2.length == 2
						&& (puke2[0].equals("joker") || puke2[0]
								.equals("JOKER"))) {
					flag = false;
				} else if (puke1.length == 4) {
					flag = true;
				} else if (puke2.length == 4) {
					flag = false;
				} else {
					System.out.println("ERROR");
					return;
				}
			}
			if (flag) {
				System.out.println(tPukes[0]);
			} else {
				System.out.println(tPukes[1]);
			}
		}

	}

	/* ����˷� */
	public static void juzhenCheng() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int mh1 = Integer.parseInt(br.readLine());// ��һ�����������
		int mhl = Integer.parseInt(br.readLine()); // ��һ������������͵ڶ������������
		int ml2 = Integer.parseInt(br.readLine());// �ڶ������������
		int m1[][] = new int[mh1][mhl], m2[][] = new int[mhl][ml2];
		for (int i = 0; i < mh1; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < line.length; j++) {
				m1[i][j] = Integer.parseInt(line[j]);
			}
		}
		for (int i = 0; i < mhl; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < line.length; j++) {
				m2[i][j] = Integer.parseInt(line[j]);
			}
		}
		int sum[][] = new int[mh1][ml2];
		for (int i = 0; i < mh1; i++) {
			for (int j = 0; j < ml2; j++) {
				for (int k = 0; k < mhl; k++) {
					sum[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		for (int i = 0; i < mh1; i++) {
			for (int j = 0; j < ml2; j++) {
				System.out.print(sum[i][j] + " ");
			}
			System.out.println();
		}
	}

	/* ����һ���ַ����ֱ�ͳ�Ƴ�����Ӣ����ĸ���ո����ֺ������ַ��ĸ��� */
	public static void tongjiZifu() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = br.readLine();
		int ch = 0, num = 0, space = 0, other = 0;
		for (int i = 0; i < string.length(); i++) {
			if (Character.isLetter(string.charAt(i))) {
				ch++;
			} else if (Character.isDigit(string.charAt(i))) {
				num++;
			} else if (Character.isSpaceChar(string.charAt(i))) {
				space++;
			} else {
				other++;
			}
		}
		System.out.println(ch + "\n" + space + "\n" + num + "\n" + other);

	}

	/* �ɼ����� */
	public static void sortName() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		final int f = Integer.parseInt(br.readLine());
		ArrayList<Student> students = new ArrayList<Student>();
		for (int i = 0; i < n; i++) {
			Student student = new Student();
			String[] stu = br.readLine().split(" ");
			if (stu[0] != null && stu[0].length() > 0) {
				student.setName(stu[0]);
				if (Integer.parseInt(stu[1]) >= 0
						&& Integer.parseInt(stu[1]) <= 100) {
					student.setScore(Integer.parseInt(stu[1]));
				} else {
					i--;
				}
			} else {
				i--;
			}
			students.add(student);
		}
		Collections.sort(students, new Comparator<Student>() {

			public int compare(Student s1, Student s2) {
				Student stu1 = (Student) s1, stu2 = (Student) s2;
				if (f == 1) {// ����
					if (stu1.getScore() >= stu2.getScore()) {
						return 1;
					} else {
						return -1;
					}
				} else {// ����
					if (stu1.getScore() > stu2.getScore()) {
						return -1;
					} else {
						return 1;
					}
				}
			}
		});
		for (Student student : students) {
			System.out
					.printf("%s  %d\n", student.getName(), student.getScore());
		}
	}

	/* ������ */
	public static void zishoushu() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strNumString = br.readLine();
		int num = Integer.parseInt(strNumString);
		int sum = 0;
		for (int i = 0; i <= num; i++) {
			int tem = i * i;
			int l = String.valueOf(i).length();
			int le = String.valueOf(tem).length();
			String string = String.valueOf(tem).substring(le - l, le);
			if (string.equals(String.valueOf(i))) {
				sum++;
			}
		}
		System.out.println(sum);
	}

	/* iNOC��Ʒ��--��ȫ������ */
	public static void perNum() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		long n = Long.parseLong(num);
		int sum = 0;
		if (n > 0 && n <= 500000) {
			for (long i = 1; i <= n; i++) {
				int j = 1, r = 0;
				while (j <= i) {
					if (i % j == 0 && j != i) {
						r += j;
					}
					j++;
				}
				if (r == i) {
					sum++;
				}
			}
		}
		System.out.println(sum);
	}

	/* ���ַ������ҳ�����������ִ� */
	public static void findLongNum() throws IOException {
		/*
		 * //ʹ��ƥ���� String input,tmp,maxDigitStr = ""; Scanner sc = new
		 * Scanner(System.in); input = sc.next();
		 * 
		 * Pattern pattern = Pattern.compile("[0-9]+"); Matcher matcher =
		 * pattern.matcher(input); while(matcher.find()){ tmp = matcher.group();
		 * if(tmp.length() > maxDigitStr.length()) maxDigitStr = tmp ; }
		 * 
		 * if(maxDigitStr.length() == 0) System.out.println(""); else{
		 * System.out.println(maxDigitStr + "," + maxDigitStr.length()); }
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = br.readLine();
		StringBuffer sb = new StringBuffer("");
		List<Character> list = new ArrayList<Character>();
		int max = 0;
		if (string.length() != 0) {
			int num = 0;
			for (int i = 0; i < string.length(); i++) {
				if (Character.isDigit(string.charAt(i))) {
					num++;
					sb.append(string.charAt(i));
					continue;
				} else {
					if (num > max) {
						max = num;
						list.clear();
						for (int j = 0; j < sb.length(); j++) {
							list.add(sb.charAt(j));
						}
						sb.delete(0, sb.length());
						num = 0;
					} else {
						sb.delete(0, sb.length());
						num = 0;
						continue;
					}
				}
			}
			if (list.size() < sb.length()) {
				max = num;
				list.clear();
				for (int j = 0; j < sb.length(); j++) {
					list.add(sb.charAt(j));
				}
			}
		}
		if (list.size() != 0) {
			System.out.println(list.toString()
					.substring(1, list.toString().length() - 1)
					.replaceAll(", ", "")
					+ "," + max);
		} else {
			System.out.println(0);
		}
	}

	/* ȡ����ֵ */
	public static void round() {
		Scanner scanner = new Scanner(System.in);
		double f = scanner.nextDouble();
		BigDecimal bd = new BigDecimal(Double.toString(f));
		BigDecimal d = new BigDecimal("1");
		System.out.println(bd.divide(d, 0, BigDecimal.ROUND_HALF_UP));

	}

	/* ͳ��ÿ�������ӵ����� */
	public static int sumNumRabbie(int n) {

		if (n > 0 && n <= 2) {
			return 1;
		} else {
			return sumNumRabbie(n - 1) + sumNumRabbie(n - 2);
		}
	}

	/* ��������ϲ� ��������ϲ� */
	public static void mergeIntArr() {
		Scanner scanner = new Scanner(System.in);
		Set<Integer> set = new HashSet<Integer>();
		int n = scanner.nextInt();
		int[] num1 = new int[n];
		for (int i = 0; i < n; i++) {
			num1[i] = scanner.nextInt();
			set.add(num1[i]);
		}
		int m = scanner.nextInt();
		int[] num2 = new int[m];
		for (int i = 0; i < m; i++) {
			num2[i] = scanner.nextInt();
			set.add(num2[i]);
		}
		// Collections.sort(set);
		Integer[] ints = set.toArray(new Integer[0]);
		Arrays.sort(ints);
		for (int i = 0; i < ints.length; i++) {
			System.out.print(ints[i]);
		}
	}

	/*
	 * ���������ַ���a,b�е�������Ӵ� abcdefghijklmnop abcsafjklmnopqrstuvw
	 */
	public static void comStrLen() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine(), str2 = br.readLine();
		String sbBuffer = "";
		int sum = 0;
		List<Character> list = new ArrayList<Character>();
		for (int i = 0; i < str1.length(); i++) {
			int tsum = 0;
			int t = i;
			for (int j = 0; j < str2.length(); j++) {
				int tj = j;
				while (i < str1.length() && j < str2.length()) {
					if (str1.charAt(i) == str2.charAt(j)) {
						list.add(str1.charAt(i));
						i++;
						j++;
						continue;
					} else {
						j = tj;
						i = t;
						if (list.size() > 0) {
							tsum = list.size();
							if (tsum > sum) {
								sum = tsum;
								sbBuffer = list.toString();
							}
						}
						list.clear();
						break;
					}
				}
				if (i == str1.length() || j == str2.length()) {
					// i=t;
					// j=tj;
					// i=t;
					if (list.size() > 0) {
						tsum = list.size();
						if (tsum > sum) {
							sum = tsum;
							sbBuffer = list.toString();
						}
					}
					list.clear();
				}
			}
		}
		System.out.println(sbBuffer.substring(1, sbBuffer.length() - 1)
				.replaceAll(", ", ""));
	}

	/* ���ʵ��� */
	public static void resWords() throws IOException {
		BufferedReader brBufferedReader = new BufferedReader(
				new InputStreamReader(System.in));
		String lStr = brBufferedReader.readLine();
		String strs[] = lStr.split("[^a-zA-Z]+");
		for (int i = strs.length - 1; i >= 0; i--) {
			System.out.print(strs[i] + " ");
		}
	}

	/* ������������е�����k����� */
	public static void lastKth() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		int[] inp = new int[n];
		for (int i = 0; i < inp.length; i++) {
			inp[i] = scanner.nextInt();
			list.add(inp[i]);
		}
		int k = scanner.nextInt();
		scanner.close();
		int num = list.get(n - k - 1);
		System.out.printf("%d", num);
	}

	/* ��ˮƿ */
	/*
	 * public static void main(String[] args) { Scanner scanner=new
	 * Scanner(System.in); int temp; while((temp=scanner.nextInt())!=0){
	 * System.out.println(qsp(temp)); } scanner.close(); } public static int
	 * qsp(int n){ if(n<=1)return 0; if(n==2)return 1; int z=n/3; int y=n%3;
	 * return z+qsp(z+y); }
	 */
	public static void iceBubble() {
		Scanner sc = new Scanner(System.in);
		int[] num = new int[10];
		int i = 0;
		while (true) {
			num[i] = sc.nextInt();
			if (num[i] != 0 && num[i] > 0 && num[i] <= 100 && i < 10) {
				i++;
			} else {
				break;
			}
		}
		int[] sum = new int[9];
		for (int j = 0; j < num.length - 1; j++) {
			sum[j] = sum(num[j]);
		}
		for (int j = 0; sum[j] != 0; j++) {
			System.out.println(sum[j]);
		}
	}

	public static int sum(int n) {
		int sum = 0;
		if (n == 2 || n == 3) {
			sum += 1;
		} else if (n > 3) {
			int m = n % 3, s = n / 3;
			sum += s;
			n = m + s;
			sum += sum(n);
		}
		return sum;
	}

	/*
	 * �ж϶��ַ����е������ַ��Ƿ��ڳ��ַ�����ȫ������:���������ַ�������һ��Ϊ���ַ����ڶ���Ϊ���ַ��� true -
	 * ��ʾ���ַ����������ַ����ڳ��ַ����г��� false- ��ʾ���ַ��������ַ��ڳ��ַ�����û�г���
	 */
	/* ���� */
	/*
	 * private static Map<Character,Integer> map = new
	 * HashMap<Character,Integer>();
	 * 
	 * public static void comfort(String s,String ss){ char[] sArr =
	 * s.toCharArray(); char[] lArr = ss.toCharArray(); for(int i =
	 * 0;i<lArr.length;i++){ if(map.containsKey(lArr[i])){ int value =
	 * map.get(lArr[i]) + 1; map.put(lArr[i],value); }else{ map.put(lArr[i],1);
	 * } }
	 * 
	 * int count = 0; for(int i = 0;i<sArr.length;i++){
	 * if(map.containsKey(sArr[i])){ count++; } }
	 * 
	 * if(count == sArr.length) {System.out.print("true");} else
	 * {System.out.print("false");}
	 * 
	 * }
	 */

	/*
	 * import java.util.Scanner;
	 * 
	 * public class Main{
	 * 
	 * public static void main(String[] args) { Scanner scanner = new
	 * Scanner(System.in); String sshort = scanner.nextLine(); String slong =
	 * scanner.nextLine(); System.out.println(haschar(sshort, slong)); }
	 * 
	 * public static boolean haschar(String sshort, String slong) { int
	 * longlength = slong.length(); int shortlength = sshort.length(); if
	 * (longlength < shortlength) { return false; } int[] wordcount = new
	 * int[256]; for (int i = 0; i < 256; i++) { wordcount[i] = 0; }
	 * 
	 * for (int i = 0; i < longlength; i++) { wordcount[slong.charAt(i)]++; }
	 * 
	 * for (int i = 0; i < shortlength; i++) { if (wordcount[sshort.charAt(i)]
	 * == 0) { return false; } } return true; }
	 * 
	 * } *
	 */

	public static boolean matchStr() throws IOException {
		boolean f = false;
		BufferedReader bReader = new BufferedReader(new InputStreamReader(
				System.in));
		String shortStr = bReader.readLine();
		String longStr = bReader.readLine();
		if (shortStr.length() > longStr.length()) {
			return false;
		} else {
			int len = 0;
			for (int i = 0; i < shortStr.length(); i++) {
				char c = shortStr.charAt(i);
				for (int j = 0; j < longStr.length(); j++) {
					if (c == longStr.charAt(j)) {
						len++;
						break;
					}
				}
			}
			if (len == shortStr.length()) {
				f = true;
			}
		}
		return f;
	}

	/* ͳ�� */
	public static void tojiCh() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String string = br.readLine();
			if (string != null && string.length() != 0) {
				Set<Character> set = new HashSet<Character>();
				for (int i = 0; i < string.length(); i++) {
					char c = string.charAt(i);
					if (c == ' ' || Character.isLetterOrDigit(c)) {
						set.add(c);
					}
				}
				if (set.size() != 0) {
					int n = set.size();
					Count count[] = new Count[n];
					Character[] cs = set.toArray(new Character[0]);
					for (int i = 0; i < n; i++) {
						count[i] = new Count();
						count[i].setC(cs[i]);
					}
					/*
					 * Iterator<Character> it=set.iterator(); while
					 * (it.hasNext()) { Character t=it.next();
					 * count[Count.index].setC(t);
					 * count[Count.index++].setNum(0); }
					 */
					for (int j = 0; j < string.length(); j++) {
						char c = string.charAt(j);
						if (c == ' ' || Character.isLetterOrDigit(c)) {
							for (int k = 0; k < count.length; k++) {
								if (c == count[k].getC()) {
									count[k].setNum(count[k].getNum() + 1);
									break;
								}
							}
						}
					}
					Arrays.sort(count, new Comparator<Count>() {
						public int compare(Count o1, Count o2) {
							Count c1 = (Count) o1, c2 = (Count) o2;
							if (c1.getNum() > c2.getNum()) {
								return -1;// ��������
							} else if (c1.getNum() == c2.getNum()) {
								if ((int) c1.getC() <= (int) c2.getC()) {
									return -1;// ASCIIС�ķ���ǰ
								} else {
									return 1;
								}
							} else {
								return 1;
							}
						}

					});
					StringBuffer sBuffer = new StringBuffer();
					for (int j = 0; j < count.length; j++) {
						sBuffer.append(count[j].getC());
					}
					System.out.printf("%s", sBuffer);
				}
				set.clear();
				System.out.println();
			} else {
				break;
			}
		}

	}

	/* �������ƽ� */
	public static void delSercet() throws IOException {
		BufferedReader brBufferedReader = new BufferedReader(
				new InputStreamReader(System.in));
		String string = brBufferedReader.readLine();
		StringBuffer sbBuffer = new StringBuffer();
		for (int i = 0; i < string.length(); i++) {
			if (Character.isUpperCase(string.charAt(i))) {
				String s = ((char) (((int) string.charAt(i)) + 1) + "")
						.toLowerCase();
				sbBuffer.append(s);
			} else if (Character.isLowerCase(string.charAt(i))) {
				switch (string.charAt(i)) {
				case 'a':
				case 'b':
				case 'c':
					sbBuffer.append(2);
					break;
				case 'd':
				case 'e':
				case 'f':
					sbBuffer.append(3);
					break;
				case 'g':
				case 'h':
				case 'i':
					sbBuffer.append(4);
					break;
				case 'j':
				case 'k':
				case 'l':
					sbBuffer.append(5);
					break;
				case 'm':
				case 'n':
				case 'o':
					sbBuffer.append(6);
					break;
				case 'p':
				case 'q':
				case 'r':
				case 's':
					sbBuffer.append(7);
					break;
				case 't':
				case 'u':
				case 'v':
					sbBuffer.append(8);
					break;
				case 'w':
				case 'x':
				case 'y':
				case 'z':
					sbBuffer.append(9);
					break;
				}
			} else {
				sbBuffer.append(string.charAt(i));
			}
		}
		System.out.println(sbBuffer);
	}

	/*
	 * ͼƬ����:Lily�Ͽ�ʱʹ����ĸ����ͼƬ��С������ѧϰӢ�ﵥ�ʣ�ÿ�ζ���Ҫ����ЩͼƬ���մ�С��ASCII��ֵ��С���������պá����Ҹ�Lily��æ
	 * ��ͨ��C���Խ����
	 */
	public static void dealPhotho() {

	}

	/* ��Ǯ��ټ�����:���ټ����⡱������һֵǮ�壬��ĸһֵǮ����������ֵǮһ����Ǯ��ټ����ʼ��̡���ĸ�����������Σ� */
	/*
	 * static void getResult(List<Integer> list){ for (int i = 0; i < 20; i++) {
	 * for (int j = 0; j < 34; j++) { for (int j2 = 0; j2 < 300; j2++) { int n
	 * =(int) (5*i+3*j+j2/3); if (n==100&&(i+j+j2==100)&&(j2%3==0)) {
	 * list.add(i); list.add(j); list.add(j2); } } } } for (int i = 0; i <
	 * list.size(); i++) { if (i%3!=2) { System.out.print(list.get(i)+" ");
	 * }else { System.out.println(list.get(i)); } } }
	 */
	public static List<String> GetResult(int n) {
		// ���� a*5 + b*3+ c/3=n���˴�n=100
		// a+b+c=100
		List<String> list = new LinkedList<String>();
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				if (i + j > 100)
					continue;
				for (int k = 0; k <= 100; k++) {
					if (i + j + k < 100)
						continue;
					if (i + j + k > 100)
						continue;
					if (k % 3 != 0)
						continue;
					if ((i + j + k == 100) && (i * 5 + j * 3 + k / 3 == n)) {
						list.add(i + " " + j + " " + k);
					}
				}
			}
		}
		return list;
	}

	/*
	 * �ַ����ָ� :���������ַ���(�������ΪN,�ַ�������С��100)���밴����Ϊ8���ÿ���ַ�����������µ��ַ������飬
	 * ���Ȳ���8���������ַ������ں��油����0�����ַ��������� ��������һ��������ΪҪ������ַ�������
	 */
	public static void sunStr() {
		// ����
		/**
		 * { Scanner reader=new Scanner(System.in); int N =reader.nextInt();
		 * reader.nextLine(); String[] strings=new String[N]; for(int
		 * i=0;i<N;i++) { strings[i]=reader.nextLine(); devide(strings[i]); }
		 * 
		 * } public static void devide(String str) { int leng=str.length()/8+1;
		 * String[] results=new String[leng]; str=str+"0000000"; for(int
		 * i=0;i<leng;i++) { results[i]=str.substring(8*i, 8*(i+1));
		 * System.out.println(results[i]); } }
		 * 
		 * //����2 public static void main(String[] args) { Scanner sc = new
		 * Scanner(System.in); int num = Integer.parseInt(sc.nextLine());
		 * ArrayList<String> list = new ArrayList<String>(); for (int i = 0; i <
		 * num; i++) { list.add(sc.nextLine()); } for (int i = 0; i <
		 * list.size(); i++) { print(list.get(i)); } } public static void
		 * print(String s){ int len = 8-(s.length()%8); StringBuffer sb = new
		 * StringBuffer(); for (int i = 0; i < len; i++) { sb.append('0'); } s =
		 * s+sb.toString(); for (int i = 0; i < s.length()/8; i++) {
		 * System.out.println(s.substring(i*8, (i+1)*8)); } }
		 */

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n > 0) {
			String strs[] = new String[n];
			String sub[][] = new String[100][];
			for (int i = 0; i < n; i++) {
				strs[i] = sc.next();
				if (strs[i] != null && strs[i].length() > 0) {
					int s = strs[i].length() / 8, m = strs[i].length() % 8;
					if (s > 0 && m == 0 && strs[i].length() < 100) {
						sub[i] = new String[s];
						for (int j = 0; j < s; j++) {
							sub[i][j] = strs[i].substring(j * 8, (j + 1) * 8);
						}
					} else if (s > 0 && m != 0) {
						sub[i] = new String[s + 1];
						int j;
						for (j = 0; j < s; j++) {
							sub[i][j] = strs[i].substring(j * 8, (j + 1) * 8);
						}
						sub[i][s] = strs[i].substring(j * 8, strs[i].length());
						char[] ch = new char[8];
						for (int k = 0; k < m; k++) {
							ch[k] = sub[i][s].charAt(k);
						}
						Arrays.fill(ch, sub[i][s].toCharArray().length, 8, '0');
						sub[i][s] = String.copyValueOf(ch);
					} else {
						sub[i] = new String[1];
						sub[i][0] = strs[i];
						char[] ch = new char[8];
						for (int j = 0; j < strs[i].length(); j++) {
							ch[j] = strs[i].charAt(j);
						}
						Arrays.fill(ch, sub[i][s].toCharArray().length, 8, '0');
						sub[i][0] = String.copyValueOf(ch);
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < sub[i].length; j++) {
					System.out.printf("%s\n", sub[i][j]);
				}
			}
		}
		sc.close();
	}

	/*
	 * �Ȳ�����:����:�Ȳ����� 2��5��8��11��14�������� ����:������N >0 ���:��Ȳ�����ǰN��� ����:ת���ɹ����� 0
	 * ,�Ƿ��������쳣����-1
	 */
	public static void equNum() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if (N > 0) {
			int sum = (3 * N + 1) * N / 2;
			System.out.printf("%s", sum);
		}
	}

	/**
	 * ���ֵ�Ư����
	 */
	public static void beauName() {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		String strs[] = new String[m];
		int[] b = new int[26];
		int[] sum = new int[m];
		for (int i = 0; i < m; i++) {
			strs[i] = sc.next().toLowerCase();
			for (int j = 0; j < strs[i].length(); j++) {
				b[strs[i].charAt(j) - 97]++;
			}
			Arrays.sort(b);// ����
			for (int j = 25; j >= 0; j--) {
				sum[i] += b[j] * (j + 1);
			}
			Arrays.fill(b, 0);// ������0
		}
		for (int i = 0; i < sum.length; i++) {
			System.out.printf("%d\n", sum[i]);
		}
	}

	/**
	 * ɾ���ַ����г��ִ������ٵ��ַ�
	 * 
	 * @param num
	 * @return
	 * @throws IOException
	 */
	public static void deleMin() throws IOException {
		// //����1
		// Scanner in=new Scanner(System.in);
		// String string=in.nextLine();
		// char[] s=string.toCharArray();
		// int[] count=new int[26];
		// for(int i=0;i<26;i++)
		// count[i]=0;
		// for(int i=0;i<s.length;i++)
		// count[(int)(s[i]-'a')]++;
		// int min=21;
		// for(int i=0;i<26;i++)
		// if(count[i]!=0&&count[i]<min) min=count[i];
		// for(int i=0;i<s.length;i++)
		// if(count[(int)(s[i]-'a')]!=min) System.out.print(s[i]);
		// ����2
		// BufferedReader in=new BufferedReader(new
		// InputStreamReader(System.in));
		// String aLine=in.readLine();
		// StringBuffer sb=new StringBuffer(aLine);
		// StringBuffer result=new StringBuffer("");
		// int []times=new int[26];
		// for(int i=0;i<sb.length();i++)
		// {
		// times[sb.codePointAt(i)-'a']+=1;
		// }
		// int min=sb.length();
		// for(int i=0;i<26;i++)
		// {
		// if(times[i]>0 && times[i]<min)
		// min=times[i];
		// }
		// for(int i=0;i<sb.length();i++)
		// {
		// if(times[sb.codePointAt(i)-'a']!=min)
		// result.append((char)sb.codePointAt(i));
		// }
		// System.out.println(result);
		// ����3
		/*
		 * public static void main(String[] args) { Scanner sc = new
		 * Scanner(System.in); String inputStr = sc.nextLine(); sc.close();
		 * System.out.println(getRest(inputStr)); }
		 * 
		 * public static String getRest(String str){ int charnums[] = new
		 * int[256]; int len = str.length(); for(int i = 0;i<len; i++){
		 * charnums[str.charAt(i)]++; } int temp[] = charnums.clone();
		 * Arrays.sort(temp); int index=0; while(temp[index]==0){ index++; } int
		 * le = temp[index];
		 * 
		 * 
		 * StringBuilder rest = new StringBuilder(); for(int i = 0;i<len; i++){
		 * if(charnums[str.charAt(i)] > le) rest.append(str.charAt(i)); } return
		 * rest.toString();
		 * 
		 * }
		 */

		/*
		 * BufferedReader br=new BufferedReader(new
		 * InputStreamReader(System.in)); String str=br.readLine();
		 * Set<Character> set=new LinkedHashSet<Character>();
		 * char[]ch=str.toCharArray(); for (char c : ch) { set.add(c); } int
		 * min=0,t=0; Object[]se=(Object[])set.toArray(); Character
		 * de=(Character) se[0],td; int[]la=new int[se.length]; for (int
		 * j=0;j<se.length;j++) { t=0; td=(Character) se[j]; for (int i = 0; i <
		 * ch.length; i++) { if(ch[i]==td){ t++; } } la[j]=t; if(j==0){ min=t; }
		 * if(t<min){ min=t; de=td; } } String r=str; for (int i = 0; i <
		 * la.length; i++) { if(la[i]==min){ //String r=str.replaceAll("\\"+de,
		 * ""); Character d=(Character) se[i]; //r=r.replace((char)d, '\0');
		 * if(d!='.'){ r=r.replaceAll(""+d, ""); }else{ r=r.replaceAll("\\"+d,
		 * ""); } } } System.out.printf("%s",r);
		 */
	}

	// ��������������������1�ĸ���
	public static int findNumberOf(int num) {
		// ���� 1
		System.out.println(Integer.bitCount(num));// ţ��
		// ���� 2
		String str = Integer.toBinaryString(num);
		// System.out.println(str);
		String substr = str.replaceAll("1", "");
		int n = str.length() - substr.length();
		System.out.println(n);

		// �ҵ�
		int sum = 0;
		while (num != 0) {
			num &= (num - 1);
			sum++;
		}
		return sum;
	}

	/**
	 * �Ϸ�IP
	 * 
	 * @throws IOException
	 */
	public static void okIP() throws IOException {
		// ����
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		scanner.close();
		Pattern pattern = Pattern
				.compile("^((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]"
						+ "|[*])\\.){3}(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]|[*])$");
		if (pattern.matcher(string).matches())
			System.out.println("YES");
		else
			System.out.println("NO");
		/*
		 * BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); String ip = br.readLine(); String rex
		 * =
		 * "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)){3}"
		 * ; boolean b = ip.matches(rex); if (b) { System.out.print("YES");
		 * }else { System.out.print("NO"); }
		 */

	}

	/**
	 * �ַ�������:��дһ�����򣬽������ַ����е��ַ������¹������� ����1��Ӣ����ĸ��A��Z���У������ִ�Сд�� �磬���룺Type �����epTy
	 * ����2��ͬһ��Ӣ����ĸ�Ĵ�Сдͬʱ����ʱ����������˳�����С� �磬���룺BabA �����aABb ����3����Ӣ����ĸ�������ַ�����ԭ����λ�á�
	 * �磬���룺By?e �����Be?y
	 * 
	 * @throws IOException
	 */
	public static void strSort() throws IOException {

		// ����
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String inputString = reader.readLine();
		char[] array = inputString.toCharArray();
		List<Character> list = new ArrayList<Character>();
		// ����ĸ�ŵ�list���棬�����Ϊa
		for (int i = 0; i < array.length; i++) {
			if ((array[i] >= 'a' && array[i] <= 'z')
					|| (array[i] >= 'A' && array[i] <= 'Z')) {
				list.add(array[i]);
				array[i] = 'a';
			}
		}
		Collections.sort(list, new Comparator<Character>() {
			public int compare(Character o1, Character o2) {
				String string1 = o1.toString();
				String string2 = o2.toString();
				return string1.compareToIgnoreCase(string2);
			}
		});
		int i = 0, j = 0;
		while (i < list.size()) {
			if (array[j] == 'a') {
				array[j] = list.get(i);
				i++;
			}
			j++;
		}
		System.out.println(String.copyValueOf(array));

		/*
		 * InputStreamReader isr = new InputStreamReader(System.in);
		 * BufferedReader br = new BufferedReader(isr); String str = null; try {
		 * str = br.readLine(); int len = str.length(); char[]ch =
		 * str.toCharArray(); if (str != null && len > 1) { for (int i = 0; i <
		 * ch.length; i++) { boolean f = false; for (int j = len - 1; j >= i +
		 * 1; j--) { if ((ch[j] >= 'a' && ch[j] <= 'z') || (ch[j] >= 'A' &&
		 * ch[j] <= 'Z')) { char t1 = Character.toLowerCase(ch[j]); for (int k =
		 * j - 1; k >= i ; k--) { if ((ch[k] >= 'a' && ch[k] <= 'z') || (ch[k]
		 * >= 'A' && ch[k] <= 'Z')) { char t2 = Character.toLowerCase(ch[k]),t3;
		 * if (t2 > t1) { t3=ch[k]; ch[k]=ch[j]; ch[j]=t3; f=true; } k=i-1; } }
		 * } } if(!f){ break; } } } if(ch.length>0){ System.out.printf("%s",
		 * String.valueOf(ch)); } } catch (Exception e) { e.printStackTrace();
		 * }finally{ try { isr.close(); br.close(); } catch (IOException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * }
		 */

	}

	/**
	 * ���7�й����ֵĸ���������7�ı��������а���7�����֣���17��27��37...70��71��72��73...���ĸ���
	 */
	public static void Test1() {

		// ����
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = null;
		try {
			s = br.readLine();
			int n = Integer.parseInt(s);
			if (n <= 30000) {
				int count = 0;
				for (int i = 7; i <= n; i++) {
					Integer j = new Integer(i);
					String ss = j.toString();
					if (ss.contains("7") == true) {
						count++;
					} else if (i % 7 == 0)
						count++;
				}
				System.out.print(count);
			} else {
				System.out.print("�����������벻����30000");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * Scanner sc=new Scanner(System.in); int inp=sc.nextInt(),count=0;
		 * if(inp>6 && inp<=30000){ for (int i = 7; i <= inp; i++) { if(i%7==0){
		 * count++; }else{ String num=String.valueOf(i); if(num.contains("7")){
		 * count++; } } } } System.out.printf("%d",count);
		 */
	}

	public void beforeTest() {
		/* ��дһ�������������ַ����к��еĲ�ͬ�ַ��ĸ������ַ���ACSII�뷶Χ��(0~127)�����ڷ�Χ�ڵĲ���ͳ�ơ� */
		int num[] = new int[128], i, j, len, count = 0;
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] ch = str.toCharArray();
		/*
		 * for (i = 0; i < ch.length; i++) { j=(int)ch[i]; if (j>=0 && j<=127) {
		 * num[j]++; } } for (i = 0; i < num.length; i++) { if(num[i]==1){
		 * count++; } }
		 */
		len = ch.length;
		for (i = 0; i < len; i++) {
			boolean flag = true;
			if (ch[i] >= 0 && ch[i] <= 127) {
				for (int k = i + 1; k < len; k++)
					if (ch[k] == ch[i]) {
						flag = false;
						break;
					}
				if (flag)
					count++;
			}
		}
		System.out.println(count);

		// ���ַ����е������Ӵ����˼�*��
		/*
		 * Scanner scanner = new Scanner(System.in); String str =
		 * scanner.nextLine(); //System.out.printf("%1$-7s\n", str); String
		 * regex = "[0-9]+"; Matcher m = Pattern.compile(regex).matcher(str);
		 * StringBuilder sb = new StringBuilder(); while (m.find()) { int n =
		 * m.groupCount();//���ԡ�����pattern����������ֻ�ԡ���Pattern������ for (int i = 0; i <=
		 * n; i++) { String tempStr = m.group(i); int firstShowPlace =
		 * str.indexOf(tempStr); int tempStrLength = tempStr.length(); int
		 * length = str.length(); String newStr = str .substring(0,
		 * firstShowPlace + tempStrLength); str = str.substring(firstShowPlace +
		 * tempStrLength, length); sb.append(newStr.replaceAll(tempStr, "*" +
		 * tempStr + "*")); } } sb.append(str); System.out.print(sb.toString());
		 * scanner.close();
		 */

		// int a, b, m;
		// Scanner sc = new Scanner(System.in);
		// a = sc.nextInt();
		// b = sc.nextInt();
		// m = a * b;
		// if (a < b) {
		// int t = b;
		// b = a;
		// a = t;
		// }
		//
		// while (b != 0) {
		// int t = b;
		// b = a % b;
		// a = t;
		// }
		// System.out.println((m / a));

		// double h,s=0,t;
		// Scanner sc = new Scanner(System.in);
		// h=sc.nextDouble();
		// t=h;
		// for(int i=0;i<5;i++){
		// if(h==t){
		// s=s+h;
		// }else{
		// s=s+h*2;
		// }
		// h=h/2;
		// }
		// System.out.println(s);
		// System.out.println(h);
	}
}

class Student {
	private String name;
	private int score;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}