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
	//字符串加密
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

	// 归并排序
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

	// 合并
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

	// 二进制转16进制
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

	// 16进制转二进制
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

	/* 字符串合并处理 */
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

	/* 字符，快速排序 */
	public static void QuickCharSort(char[] R, int l, int r) {
		if (l < r) {
			char temp;
			int i = l, j = r;
			temp = R[i]; // 通过tem挖出一个空缺R[i],temp暂时保存该值

			while (i < j) { // 找到右边第一个比temp小的数，j保存其下标
				while (i < j && R[j] >= temp) {
					j--;
				}
				if (i < j) {
					R[i++] = R[j];// 将其值移到R[i]空缺位置，i后移
				}
				while (i < j && R[i] <= temp) {
					i++;
				}
				if (i < j) {
					R[j--] = R[i];// 将其值移到R[j]空缺位置，j前移；又产生一个空缺位
				}
			}
			R[i] = temp;
			QuickCharSort(R, l, i - 1);// 递归对左段序列进行排序
			QuickCharSort(R, i + 1, r);// 递归对右段序列进行排序
		}
	}

	// 全排列(递归实现)
	public static void diguiFull(int array[], int k, int n) {
		int temp;
		if (k == n - 1) {
			print(array);// k和n-1相等，即一趟递归走完
		} else {
			for (int i = k; i < array.length; i++) {// 把当前节点元素与后续节点元素交换
				// 交换
				temp = array[k];
				array[k] = array[i];
				array[i] = temp;
				// 把下一个节点元素与后续节点元素交换
				diguiFull(array, k + 1, n);
				// 恢复原状
				temp = array[i];
				array[i] = array[k];
				array[k] = temp;
			}
		}
	}

	// 打印火车进站问题
	private static void print(int out[]) {
		int m;
		boolean flag = true;
		int[] b = new int[2];
		for (int i = 0; i < out.length; i++) {/* 对每个out[i] 判断其后比它小的数是否为降序序列 */
			m = 0;
			for (int j = i + 1; j < out.length && flag; j++) {
				if (out[i] > out[j]) {
					if (m == 0) {
						b[m++] = out[j];// 记录str[i]后比它小的数
					} else {
						// 如果之后出现的数比记录的数还大，改变标记变量
						if (b[0] < out[j]) {
							flag = false;
						} else {
							// 否则记录这个更小的数
							b[0] = out[j];
						}
					}
				}
			}
		}
		if (flag) {/* 满足出栈规则则输出 str[] 中的序列 */
			for (int i = 0; i < out.length - 1; i++) {
				System.out.print(out[i] + " ");
			}
			System.out.println(out[out.length - 1]);
		}
	}

	// 打印全排列（全部）
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
		System.out.println();// 换行
		return;
	}

	/**
	 * q:存放入栈序列 t:用于模拟入栈过程 o:用于存放可能的出栈序列
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
		if (q.size() != 0) {// 入栈
			int v = q.peek();
			t.push(v);
			q.pop();
			allPopSeq(q, t, o, n);
			t.pop();
			q.push(v);// 回溯恢复
		}
		if (t.size() != 0) {// 出栈
			int v = t.peek();
			t.pop();
			o.push(v);
			allPopSeq(q, t, o, n);
			o.pop();
			t.push(v);// 回溯恢复
		}
		return;
	}

	public static void huocheJinzhan() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		if (n > 0 && n < 10) {
			// 栈
			Stack<Integer> qStack = new Stack<Integer>();// 存放入栈序列
			Stack<Integer> tStack = new Stack<Integer>();// 用于模拟入栈过程
			Stack<Integer> output = new Stack<Integer>();// 用于存放可能的出栈序列
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

	/* 快速排序 */
	public static void QuickSort(int[] R, int l, int r) {
		if (l < r) {
			int temp;
			int i = l, j = r;
			temp = R[i]; // 通过tem挖出一个空缺R[i],temp暂时保存该值

			while (i < j) { // 找到右边第一个比temp小的数，j保存其下标
				while (i < j && R[j] >= temp) {
					j--;
				}
				if (i < j) {
					R[i++] = R[j];// 将其值移到R[i]空缺位置，i后移
				}
				while (i < j && R[i] <= temp) {
					i++;
				}
				if (i < j) {
					R[j--] = R[i];// 将其值移到R[j]空缺位置，j前移；又产生一个空缺位
				}
			}
			R[i] = temp;
			QuickSort(R, l, i - 1);// 递归对左段序列进行排序
			QuickSort(R, i + 1, r);// 递归对右段序列进行排序
		}
	}

	/* 记负均正 */
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

	/* 输入整型数组和排序标识，对其元素按照升序或降序进行排序 */
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
				if (f == 0) {// 升序
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

	/* 查找组成一个偶数最接近的两个素数 */
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

	/* 扑克牌大小 */
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
			String[] puke1 = tPukes[0].split(" ");// 每张牌
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

	/* 矩阵乘法 */
	public static void juzhenCheng() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int mh1 = Integer.parseInt(br.readLine());// 第一个矩阵的行数
		int mhl = Integer.parseInt(br.readLine()); // 第一个矩阵的列数和第二个矩阵的行数
		int ml2 = Integer.parseInt(br.readLine());// 第二个矩阵的列数
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

	/* 输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数 */
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

	/* 成绩排序 */
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
				if (f == 1) {// 升序
					if (stu1.getScore() >= stu2.getScore()) {
						return 1;
					} else {
						return -1;
					}
				} else {// 降序
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

	/* 自守数 */
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

	/* iNOC产品部--完全数计算 */
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

	/* 在字符串中找出连续最长的数字串 */
	public static void findLongNum() throws IOException {
		/*
		 * //使用匹配器 String input,tmp,maxDigitStr = ""; Scanner sc = new
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

	/* 取近似值 */
	public static void round() {
		Scanner scanner = new Scanner(System.in);
		double f = scanner.nextDouble();
		BigDecimal bd = new BigDecimal(Double.toString(f));
		BigDecimal d = new BigDecimal("1");
		System.out.println(bd.divide(d, 0, BigDecimal.ROUND_HALF_UP));

	}

	/* 统计每个月兔子的总数 */
	public static int sumNumRabbie(int n) {

		if (n > 0 && n <= 2) {
			return 1;
		} else {
			return sumNumRabbie(n - 1) + sumNumRabbie(n - 2);
		}
	}

	/* 整形数组合并 整形数组合并 */
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
	 * 查找两个字符串a,b中的最长公共子串 abcdefghijklmnop abcsafjklmnopqrstuvw
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

	/* 单词倒排 */
	public static void resWords() throws IOException {
		BufferedReader brBufferedReader = new BufferedReader(
				new InputStreamReader(System.in));
		String lStr = brBufferedReader.readLine();
		String strs[] = lStr.split("[^a-zA-Z]+");
		for (int i = strs.length - 1; i >= 0; i--) {
			System.out.print(strs[i] + " ");
		}
	}

	/* 输出单向链表中倒数第k个结点 */
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

	/* 汽水瓶 */
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
	 * 判断短字符串中的所有字符是否在长字符串中全部出现:输入两个字符串。第一个为短字符，第二个为长字符。 true -
	 * 表示短字符串中所有字符均在长字符串中出现 false- 表示短字符串中有字符在长字符串中没有出现
	 */
	/* 高手 */
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

	/* 统计 */
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
								return -1;// 降序排序
							} else if (c1.getNum() == c2.getNum()) {
								if ((int) c1.getC() <= (int) c2.getC()) {
									return -1;// ASCII小的放在前
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

	/* 简单密码破解 */
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
	 * 图片整理:Lily上课时使用字母数字图片教小朋友们学习英语单词，每次都需要把这些图片按照大小（ASCII码值从小到大）排列收好。请大家给Lily帮忙
	 * ，通过C语言解决。
	 */
	public static void dealPhotho() {

	}

	/* 百钱买百鸡问题:“百鸡问题”：鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？ */
	/*
	 * static void getResult(List<Integer> list){ for (int i = 0; i < 20; i++) {
	 * for (int j = 0; j < 34; j++) { for (int j2 = 0; j2 < 300; j2++) { int n
	 * =(int) (5*i+3*j+j2/3); if (n==100&&(i+j+j2==100)&&(j2%3==0)) {
	 * list.add(i); list.add(j); list.add(j2); } } } } for (int i = 0; i <
	 * list.size(); i++) { if (i%3!=2) { System.out.print(list.get(i)+" ");
	 * }else { System.out.println(list.get(i)); } } }
	 */
	public static List<String> GetResult(int n) {
		// 条件 a*5 + b*3+ c/3=n，此处n=100
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
	 * 字符串分割 :连续输入字符串(输出次数为N,字符串长度小于100)，请按长度为8拆分每个字符串后输出到新的字符串数组，
	 * 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。 首先输入一个整数，为要输入的字符串个数
	 */
	public static void sunStr() {
		// 高手
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
		 * //高手2 public static void main(String[] args) { Scanner sc = new
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
	 * 等差数列:功能:等差数列 2，5，8，11，14。。。。 输入:正整数N >0 输出:求等差数列前N项和 返回:转换成功返回 0
	 * ,非法输入与异常返回-1
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
	 * 名字的漂亮度
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
			Arrays.sort(b);// 排序
			for (int j = 25; j >= 0; j--) {
				sum[i] += b[j] * (j + 1);
			}
			Arrays.fill(b, 0);// 重新置0
		}
		for (int i = 0; i < sum.length; i++) {
			System.out.printf("%d\n", sum[i]);
		}
	}

	/**
	 * 删除字符串中出现次数最少的字符
	 * 
	 * @param num
	 * @return
	 * @throws IOException
	 */
	public static void deleMin() throws IOException {
		// //高手1
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
		// 高手2
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
		// 高手3
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

	// 查找输入整数二进制中1的个数
	public static int findNumberOf(int num) {
		// 高手 1
		System.out.println(Integer.bitCount(num));// 牛叉
		// 高手 2
		String str = Integer.toBinaryString(num);
		// System.out.println(str);
		String substr = str.replaceAll("1", "");
		int n = str.length() - substr.length();
		System.out.println(n);

		// 我的
		int sum = 0;
		while (num != 0) {
			num &= (num - 1);
			sum++;
		}
		return sum;
	}

	/**
	 * 合法IP
	 * 
	 * @throws IOException
	 */
	public static void okIP() throws IOException {
		// 高手
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
	 * 字符串排序:编写一个程序，将输入字符串中的字符按如下规则排序。 规则1：英文字母从A到Z排列，不区分大小写。 如，输入：Type 输出：epTy
	 * 规则2：同一个英文字母的大小写同时存在时，按照输入顺序排列。 如，输入：BabA 输出：aABb 规则3：非英文字母的其它字符保持原来的位置。
	 * 如，输入：By?e 输出：Be?y
	 * 
	 * @throws IOException
	 */
	public static void strSort() throws IOException {

		// 高手
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String inputString = reader.readLine();
		char[] array = inputString.toCharArray();
		List<Character> list = new ArrayList<Character>();
		// 将字母放到list里面，并标记为a
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
	 * 输出7有关数字的个数，包括7的倍数，还有包含7的数字（如17，27，37...70，71，72，73...）的个数
	 */
	public static void Test1() {

		// 高手
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
				System.out.print("输入整数必须不大于30000");
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
		/* 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)。不在范围内的不作统计。 */
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

		// 在字符串中的数字子串两端加*号
		/*
		 * Scanner scanner = new Scanner(System.in); String str =
		 * scanner.nextLine(); //System.out.printf("%1$-7s\n", str); String
		 * regex = "[0-9]+"; Matcher m = Pattern.compile(regex).matcher(str);
		 * StringBuilder sb = new StringBuilder(); while (m.find()) { int n =
		 * m.groupCount();//不对“整个pattern”计数，而只对“子Pattern”计数 for (int i = 0; i <=
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