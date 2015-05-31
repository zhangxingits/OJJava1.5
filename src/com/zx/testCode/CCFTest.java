package com.zx.testCode;

import java.io.*;
import java.util.*;


public class CCFTest {
	public static void main(String[] args) throws IOException {
		
	}
}

class StockItem {
	private String action;
	private double price;
	private int index;
	private int num;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public static void stockSort(List<StockItem> list, final int f) {
		Collections.sort(list, new Comparator<StockItem>() {
			public int compare(StockItem stockItem1, StockItem stockItem2) {
				if (f == 1) {// 升序
					if (stockItem1.getPrice() >= stockItem2.getPrice()) {
						return 1;
					} else {
						return -1;
					}
				} else {
					if (stockItem1.getPrice() > stockItem2.getPrice()) {
						return -1;
					} else {
						return 1;
					}
				}
			}
		});
	}
}


class TestCCf {
	/* 集合竞价 */
	/**
	 * 输入格式:
	 * 输入数据有任意多行，每一行是一条记录。保证输入合法。股数为不超过108的正整数，出价为精确到恰好小数点后两位的正实数，且不超过10000.00。
	 * 输出格式: 你需要输出一行，包含两个数，以一个空格分隔。第一个数是开盘价，第二个是此开盘价下的成交量。开盘价需要精确到小数点后恰好两位。
	 * 
	 * @throws IOException
	 */
	public static void gupiaoJingjia() throws IOException {
		Scanner scanner = new Scanner(System.in);
		List<StockItem> list = new ArrayList<StockItem>();
		int n = 0;
		String sItem="";
		do{
			sItem=scanner.nextLine();
			if (!sItem.isEmpty()) {
				String[] item = sItem.split(" ");
				StockItem stockItem = new StockItem();
				if ("cancel".equals(item[0])) {
					// stockItem.setAction("cancel");
					// stockItem.setIndex(Integer.parseInt(item[1]));
					list.set(Integer.parseInt(item[1]) - 1, null);// 指定下标先置空，不删除为了占位
					list.add(null);// cancel 占位
				} else {
					stockItem.setAction(item[0]);
					stockItem.setPrice(Double.parseDouble(item[1]));
					stockItem.setNum(Integer.parseInt(item[2]));
					list.add(stockItem);
				}
				n++;
			}
		}while (n < 5001 && !sItem.isEmpty());

		for (int i = 0; i < list.size(); i++) {// 清洗null
			if (null == list.get(i)) {
				list.remove(i);
				i--;// 防止漏删
			}
		}

		List<StockItem> buyList = new ArrayList<StockItem>();
		List<StockItem> sellList = new ArrayList<StockItem>();
		for (int i = 0; i < list.size(); i++) {// 清洗null
			if ("buy".equals(list.get(i).getAction())) {
				buyList.add(list.get(i));
			} else {
				sellList.add(list.get(i));
			}
		}
		StockItem.stockSort(buyList, 0);
		StockItem.stockSort(sellList, 1);

		double startPrice = 0.0;
		int dealSum = 0, buySum = 0;
		for (int i = 0; i < buyList.size(); i++) {
			int temSum = 0, sellSum = 0;
			double temPrice = 0.00;
			buySum += buyList.get(i).getNum();
			for (int j = 0; j < sellList.size(); j++) {
				if (sellList.get(j).getPrice() <= buyList.get(i).getPrice()) {
					sellSum += sellList.get(j).getNum();
				}
			}
			if (i == 0) {
				dealSum = (buySum < sellSum ? buySum : sellSum);
				startPrice = buyList.get(i).getPrice();
			} else {
				temSum = (buySum < sellSum ? buySum : sellSum);
				temPrice = buyList.get(i).getPrice();
				if (dealSum < temSum) {
					dealSum = temSum;
					startPrice = temPrice;
				} else if (dealSum == temSum) {
					startPrice = (startPrice >= temPrice ? startPrice
							: temPrice);
				}
			}
		}
		
		System.out.printf("%.2f %d", startPrice,dealSum);

	}

	
	/* Z字形扫描 */
	public static void ZScanf() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] numArray = new int[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				numArray[i][j] = scanner.nextInt();
			}
		}
		// int []nums=new int[n*n];
		int tem = 2;// 起始最小值
		for (int i = 1; i < (2 * n); i++) {
			int sumIndex = i + 1, min = 1;// 下标和，
			if (i <= n) {// 小于等于n
				min = 1;
				for (int j = 1; j <= i; j++) {// 每个组数
					if (i % 2 == 1) {// 第奇数次扫描
						int pre = sumIndex - min;
						System.out.print(numArray[pre][min] + " ");
						min++;
						// pre--;
					} else {
						int last = sumIndex - min;
						System.out.print(numArray[min][last] + " ");
						min++;
						// last--;
					}
				}
				// System.out.println();//换行
			} else {// 下半部矩
				min = tem;
				for (int j = 1; j <= (2 * n - i); j++) {
					if (i % 2 == 1) {// 第奇数次扫描
						int pre = sumIndex - min;
						System.out.print(numArray[pre][min] + " ");
						min++;
					} else {
						int last = sumIndex - min;
						System.out.print(numArray[min][last] + " ");
						min++;
					}
				}
				tem++;// 保存当前行min值
			}
		}
	}

	/* 门禁系统 */
	public static void doorForbidden() throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if (n > 0 && n < 1001) {
			String[] numStr = br.readLine().trim().split(" ");
			if (numStr.length == n) {
				int[] times = new int[n];
				times[0] = 1;
				System.out.print(1 + " ");
				for (int i = 1; i < n; i++) {
					int count = 1;
					for (int j = 0; j < i; j++) {
						if (numStr[i].equals(numStr[j])) {
							count++;
						}
					}
					System.out.print(count + " ");
				}
			}
		}
	}
}
