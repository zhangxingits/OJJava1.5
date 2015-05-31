package com.zx.testCode;

import java.math.BigDecimal;

/**
 * java ����߾��ȼ���
 * 
 * Double.valueOf(String) and Float.valueOf(String)���ᶪʧ���ȡ�
 * Ϊ�˽��������⣬��Ҫ�õ�BigDecimal�ࡣ
 * 
 * ʹ�õ�BigDecimal���ʱ����Ҫע��ĵط��� 1. ��ʵ����BigDecimal ��ʱ���� new BigDecimal(String) ����new
 * BigDecimal(double) ��new BigDecimal(float)�ڡ�Effective Java���������ᵽ 2.
 * �Ƚ���������ʱ����compareTo С�ڷ���-1 �� ���ڷ���0 �� ���ڷ���1
 * 
 * @author ZhangXin
 * 
 */
public class ArithmeticUtil {
	
	 /** 
     * �����õ�main����. 
     *  
     * @param argc 
     *            ���в���. 
     */  
    public static void main(String[] argc) {  
        //���涼�Ա���2λС��Ϊ��  
          
        //ROUND_UP  
        //ֻҪ��2λ������ڴ���0��С�������2λ��+1  
        System.out.println(round(12.3401,2,BigDecimal.ROUND_UP));//12.35  
        System.out.println(round(-12.3401,2,BigDecimal.ROUND_UP));//-12.35  
        //ROUND_DOWN  
        //��ROUND_UP�෴  
        //ֱ��������2λ���������С��  
        System.out.println(round(12.349,2,BigDecimal.ROUND_DOWN));//12.34  
        System.out.println(round(-12.349,2,BigDecimal.ROUND_DOWN));//-12.34  
        //ROUND_CEILING  
        //�������>0 ���ROUND_UP����һ��  
        //�������<0 ���ROUND_DOWN����һ��  
        System.out.println(round(12.3401,2,BigDecimal.ROUND_CEILING));//12.35  
        System.out.println(round(-12.349,2,BigDecimal.ROUND_CEILING));//-12.34  
        //ROUND_FLOOR  
        //�������>0 ���ROUND_DOWN����һ��  
        //�������<0 ���ROUND_UP����һ��  
        System.out.println(round(12.349,2,BigDecimal.ROUND_FLOOR));//12.34  
        System.out.println(round(-12.3401,2,BigDecimal.ROUND_FLOOR));//-12.35  
        //ROUND_HALF_UP [���ַ������]  
        //�����3λ����>=5,���2λ����+1  
        //��ע:ֻ����3λ���ֵ�ֵ,���ῼ�ǵ�3λ֮���С����  
        System.out.println(round(12.345,2,BigDecimal.ROUND_HALF_UP));//12.35  
        System.out.println(round(12.3449,2,BigDecimal.ROUND_HALF_UP));//12.34  
        System.out.println(round(-12.345,2,BigDecimal.ROUND_HALF_UP));//-12.35  
        System.out.println(round(-12.3449,2,BigDecimal.ROUND_HALF_UP));//-12.34  
        //ROUND_HALF_DOWN  
        //�����3λ����>=5,����ROUND_UP  
        //�����3λ����<5,����ROUND_DOWN  
        System.out.println(round(12.345,2,BigDecimal.ROUND_HALF_DOWN));//12.35  
        System.out.println(round(12.3449,2,BigDecimal.ROUND_HALF_DOWN));//12.34  
        System.out.println(round(-12.345,2,BigDecimal.ROUND_HALF_DOWN));//-12.35  
        System.out.println(round(-12.3449,2,BigDecimal.ROUND_HALF_DOWN));//-12.34  
        //ROUND_HALF_EVEN  
        //�����3λ��ż��,����ROUND_HALF_DOWN  
        //�����3λ������,����ROUND_HALF_UP  
        System.out.println(round(12.346,2,BigDecimal.ROUND_HALF_EVEN));//12.35  
        System.out.println(round(12.345,2,BigDecimal.ROUND_HALF_EVEN));//12.35  
    }  
	
	/** 
     * ��double���ݽ���ȡ����. 
     * <p> 
     * For example: <br> 
     * double value = 100.345678; <br> 
     * double ret = round(value,4,BigDecimal.ROUND_HALF_UP); <br> 
     * retΪ100.3457 <br> 
     *  
     * @param value 
     *            double����. 
     * @param scale 
     *            ����λ��(������С��λ��). 
     * @param roundingMode 
     *            ����ȡֵ��ʽ. 
     * @return ���ȼ���������. 
     */  
    public static double round(double value, int scale, int roundingMode) {  
        BigDecimal bd = new BigDecimal(value);  
        bd = bd.setScale(scale, roundingMode);  
        double d = bd.doubleValue();  
        bd = null;  
        return d;  
    }  
	
	/*
	 * С����ȷ��λ��
	 */
	private static final int DEF_DIV_SCALE = 10;

	/**
	 * �ṩ��ȷ�ļӷ����㡣
	 * 
	 * @param v1
	 *            ������
	 * @param v2
	 *            ����
	 * @return ���������ĺ�
	 */
	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}

	/**
	 * �ṩ��ȷ�ļӷ����㡣
	 * 
	 * @param v1
	 *            ������
	 * @param v2
	 *            ����
	 * @return ���������ĺ�
	 */
	public static BigDecimal add(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.add(b2);
	}

	/**
	 * �ṩ��ȷ�ļӷ����㡣 String
	 * 
	 * @param v1
	 *            ������
	 * @param v2
	 *            ����
	 * @return ���������ĺ�
	 */
	public static String strAdd(String v1, String v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.add(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
	}

	/**
	 * �ṩ��ȷ�ļ������㡣
	 * 
	 * @param v1
	 *            ������
	 * @param v2
	 *            ����
	 * @return ���������Ĳ�
	 */
	public static double sub(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * �ṩ��ȷ�ļ������㡣
	 * 
	 * @param v1
	 *            ������
	 * @param v2
	 *            ����
	 * @return ���������Ĳ�
	 */
	public static BigDecimal sub(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.subtract(b2);
	}

	/**
	 * ��һ������ȡ����
	 * 
	 * @param v
	 * @param scale
	 * @return
	 */
	public static BigDecimal round(String v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(v);
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * �ṩ��ȷ�ļ������㡣String
	 * 
	 * @param v1
	 *            ������
	 * @param v2
	 *            ����
	 * @return ���������Ĳ�
	 */
	public static String strSub(String v1, String v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.subtract(b2).setScale(scale, BigDecimal.ROUND_HALF_UP)
				.toString();
	}

	/**
	 * �ṩ��ȷ�ĳ˷����㡣
	 * 
	 * @param v1
	 *            ������
	 * @param v2
	 *            ����
	 * @return ���������Ļ�
	 */
	public static double mul(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}

	/**
	 * �ṩ��ȷ�ĳ˷����㡣
	 * 
	 * @param v1
	 *            ������
	 * @param v2
	 *            ����
	 * @return ���������Ļ�
	 */
	public static BigDecimal mul(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.multiply(b2);
	}

	/**
	 * �ṩ��ȷ�ĳ˷����㡣 ����scale λС��
	 * 
	 * @param v1
	 *            ������
	 * @param v2
	 *            ����
	 * @return ���������Ļ�
	 */
	public static double mul2(double v1, double v2, int scale) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return round(b1.multiply(b2).doubleValue(), scale);
	}

	/**
	 * �ṩ��ȷ�ĳ˷����㡣 ����scale λС�� String
	 * 
	 * @param v1
	 *            ������
	 * @param v2
	 *            ����
	 * @return ���������Ļ�
	 */
	public static String strMul2(String v1, String v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.multiply(b2).setScale(scale, BigDecimal.ROUND_HALF_UP)
				.toString();
	}

	/**
	 * �ṩ����ԣ���ȷ�ĳ������㣬�����������������ʱ����ȷ�� С�����Ժ�10λ���Ժ�������������롣
	 * 
	 * @param v1
	 *            ������
	 * @param v2
	 *            ����
	 * @return ������������
	 */
	public static BigDecimal div(String v1, String v2) {
		return div(v1, v2, DEF_DIV_SCALE);
	}

	/**
	 * �ṩ����ԣ���ȷ�ĳ������㣬�����������������ʱ����ȷ�� С�����Ժ�10λ���Ժ�������������롣
	 * 
	 * @param v1
	 *            ������
	 * @param v2
	 *            ����
	 * @return ������������
	 */
	public static double div(double v1, double v2) {
		return div(v1, v2, DEF_DIV_SCALE);
	}

	/**
	 * �ṩ����ԣ���ȷ�ĳ������㡣�����������������ʱ����scale����ָ �����ȣ��Ժ�������������롣
	 * 
	 * @param v1
	 *            ������
	 * @param v2
	 *            ����
	 * @param scale
	 *            ��ʾ��Ҫ��ȷ��С�����Ժ�λ��
	 * @return ������������
	 */
	public static double div(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * �ṩ����ԣ���ȷ�ĳ������㡣�����������������ʱ����scale����ָ �����ȣ��Ժ�������������롣
	 * 
	 * @param v1
	 *            ������
	 * @param v2
	 *            ����
	 * @param scale
	 *            ��ʾ��Ҫ��ȷ��С�����Ժ�λ��
	 * @return ������������
	 */
	public static BigDecimal div(String v1, String v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * ��ȷ�ĳ������㡣������ʱ����scale����ָ ������ �������롣string
	 * 
	 * @param v1
	 *            ������
	 * @param v2
	 *            ����
	 * @param scale
	 *            ��ʾ��Ҫ��ȷ��С�����Ժ�λ��
	 * @return ������������
	 */
	public static String strDiv(String v1, String v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).toString();
	}

	/**
	 * ��ȷ�ĳ������㡣������ʱ����scale����ָ ������ �������롣string
	 * 
	 * @param v1
	 *            ������
	 * @param v2
	 *            ����
	 * @param scale
	 *            ��ʾ��Ҫ��ȷ��С�����Ժ�λ��
	 * @return ������������
	 */
	public static BigDecimal bigDiv(String v1, String v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * ȡ���� string
	 * 
	 * @param v1
	 * @param v2
	 * @param scale
	 * @return
	 */
	public static BigDecimal strRemainder(String v1, String v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.remainder(b2).setScale(scale, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * ȡ���� string
	 * 
	 * @param v1
	 * @param v2
	 * @param scale
	 * @return string
	 */
	public static String strRemainder2Str(String v1, String v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.remainder(b2).setScale(scale, BigDecimal.ROUND_HALF_UP)
				.toString();
	}

	/**
	 * �Ƚϴ�С ���v1 ����v2 �� ����true ����false
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static boolean strcompareTo(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		int bj = b1.compareTo(b2);
		boolean res;
		if (bj > 0)
			res = true;
		else
			res = false;
		return res;
	}

	/**
	 * �Ƚϴ�С ���v1 ���ڵ���v2 �� ����true ����false
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static boolean strcompareTo2(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		int bj = b1.compareTo(b2);
		boolean res;
		if (bj >= 0)
			res = true;
		else
			res = false;
		return res;
	}

	/**
	 * �Ƚϴ�С ���v1 ����v2 �� ����true ����false
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static boolean strcompareTo3(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		int bj = b1.compareTo(b2);
		boolean res;
		if (bj == 0)
			res = true;
		else
			res = false;
		return res;
	}

	/**
	 * ȡ���� BigDecimal
	 * 
	 * @param v1
	 * @param v2
	 * @param scale
	 * @return
	 */
	public static BigDecimal bigRemainder(BigDecimal v1, BigDecimal v2,
			int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		return v1.remainder(v2).setScale(scale, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * �ṩ��ȷ��С��λ�������봦��
	 * 
	 * @param v
	 *            ��Ҫ�������������
	 * @param scale
	 *            С���������λ
	 * @return ���������Ľ��
	 */
	public static double round(double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * �ṩ��ȷ��С��λ�������봦��string
	 * 
	 * @param v
	 *            ��Ҫ�������������
	 * @param scale
	 *            С���������λ
	 * @return ���������Ľ��
	 */
	public static String strRound(String v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(v);
		return b.setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
	}
}
