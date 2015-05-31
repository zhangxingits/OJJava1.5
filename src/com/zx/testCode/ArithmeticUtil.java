package com.zx.testCode;

import java.math.BigDecimal;

/**
 * java 处理高精度计算
 * 
 * Double.valueOf(String) and Float.valueOf(String)都会丢失精度。
 * 为了解决这个问题，需要用到BigDecimal类。
 * 
 * 使用的BigDecimal类的时候需要注意的地方： 1. 在实例化BigDecimal 的时候用 new BigDecimal(String) 代替new
 * BigDecimal(double) ，new BigDecimal(float)在《Effective Java》书中有提到 2.
 * 比较两个数的时候用compareTo 小于返回-1 ， 等于返回0 ， 大于返回1
 * 
 * @author ZhangXin
 * 
 */
public class ArithmeticUtil {
	
	 /** 
     * 测试用的main方法. 
     *  
     * @param argc 
     *            运行参数. 
     */  
    public static void main(String[] argc) {  
        //下面都以保留2位小数为例  
          
        //ROUND_UP  
        //只要第2位后面存在大于0的小数，则第2位就+1  
        System.out.println(round(12.3401,2,BigDecimal.ROUND_UP));//12.35  
        System.out.println(round(-12.3401,2,BigDecimal.ROUND_UP));//-12.35  
        //ROUND_DOWN  
        //与ROUND_UP相反  
        //直接舍弃第2位后面的所有小数  
        System.out.println(round(12.349,2,BigDecimal.ROUND_DOWN));//12.34  
        System.out.println(round(-12.349,2,BigDecimal.ROUND_DOWN));//-12.34  
        //ROUND_CEILING  
        //如果数字>0 则和ROUND_UP作用一样  
        //如果数字<0 则和ROUND_DOWN作用一样  
        System.out.println(round(12.3401,2,BigDecimal.ROUND_CEILING));//12.35  
        System.out.println(round(-12.349,2,BigDecimal.ROUND_CEILING));//-12.34  
        //ROUND_FLOOR  
        //如果数字>0 则和ROUND_DOWN作用一样  
        //如果数字<0 则和ROUND_UP作用一样  
        System.out.println(round(12.349,2,BigDecimal.ROUND_FLOOR));//12.34  
        System.out.println(round(-12.3401,2,BigDecimal.ROUND_FLOOR));//-12.35  
        //ROUND_HALF_UP [这种方法最常用]  
        //如果第3位数字>=5,则第2位数字+1  
        //备注:只看第3位数字的值,不会考虑第3位之后的小数的  
        System.out.println(round(12.345,2,BigDecimal.ROUND_HALF_UP));//12.35  
        System.out.println(round(12.3449,2,BigDecimal.ROUND_HALF_UP));//12.34  
        System.out.println(round(-12.345,2,BigDecimal.ROUND_HALF_UP));//-12.35  
        System.out.println(round(-12.3449,2,BigDecimal.ROUND_HALF_UP));//-12.34  
        //ROUND_HALF_DOWN  
        //如果第3位数字>=5,则做ROUND_UP  
        //如果第3位数字<5,则做ROUND_DOWN  
        System.out.println(round(12.345,2,BigDecimal.ROUND_HALF_DOWN));//12.35  
        System.out.println(round(12.3449,2,BigDecimal.ROUND_HALF_DOWN));//12.34  
        System.out.println(round(-12.345,2,BigDecimal.ROUND_HALF_DOWN));//-12.35  
        System.out.println(round(-12.3449,2,BigDecimal.ROUND_HALF_DOWN));//-12.34  
        //ROUND_HALF_EVEN  
        //如果第3位是偶数,则做ROUND_HALF_DOWN  
        //如果第3位是奇数,则做ROUND_HALF_UP  
        System.out.println(round(12.346,2,BigDecimal.ROUND_HALF_EVEN));//12.35  
        System.out.println(round(12.345,2,BigDecimal.ROUND_HALF_EVEN));//12.35  
    }  
	
	/** 
     * 对double数据进行取精度. 
     * <p> 
     * For example: <br> 
     * double value = 100.345678; <br> 
     * double ret = round(value,4,BigDecimal.ROUND_HALF_UP); <br> 
     * ret为100.3457 <br> 
     *  
     * @param value 
     *            double数据. 
     * @param scale 
     *            精度位数(保留的小数位数). 
     * @param roundingMode 
     *            精度取值方式. 
     * @return 精度计算后的数据. 
     */  
    public static double round(double value, int scale, int roundingMode) {  
        BigDecimal bd = new BigDecimal(value);  
        bd = bd.setScale(scale, roundingMode);  
        double d = bd.doubleValue();  
        bd = null;  
        return d;  
    }  
	
	/*
	 * 小数精确的位数
	 */
	private static final int DEF_DIV_SCALE = 10;

	/**
	 * 提供精确的加法运算。
	 * 
	 * @param v1
	 *            被加数
	 * @param v2
	 *            加数
	 * @return 两个参数的和
	 */
	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}

	/**
	 * 提供精确的加法运算。
	 * 
	 * @param v1
	 *            被加数
	 * @param v2
	 *            加数
	 * @return 两个参数的和
	 */
	public static BigDecimal add(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.add(b2);
	}

	/**
	 * 提供精确的加法运算。 String
	 * 
	 * @param v1
	 *            被加数
	 * @param v2
	 *            加数
	 * @return 两个参数的和
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
	 * 提供精确的减法运算。
	 * 
	 * @param v1
	 *            被减数
	 * @param v2
	 *            减数
	 * @return 两个参数的差
	 */
	public static double sub(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * 提供精确的减法运算。
	 * 
	 * @param v1
	 *            被减数
	 * @param v2
	 *            减数
	 * @return 两个参数的差
	 */
	public static BigDecimal sub(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.subtract(b2);
	}

	/**
	 * 对一个数字取精度
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
	 * 提供精确的减法运算。String
	 * 
	 * @param v1
	 *            被减数
	 * @param v2
	 *            减数
	 * @return 两个参数的差
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
	 * 提供精确的乘法运算。
	 * 
	 * @param v1
	 *            被乘数
	 * @param v2
	 *            乘数
	 * @return 两个参数的积
	 */
	public static double mul(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}

	/**
	 * 提供精确的乘法运算。
	 * 
	 * @param v1
	 *            被乘数
	 * @param v2
	 *            乘数
	 * @return 两个参数的积
	 */
	public static BigDecimal mul(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.multiply(b2);
	}

	/**
	 * 提供精确的乘法运算。 保留scale 位小数
	 * 
	 * @param v1
	 *            被乘数
	 * @param v2
	 *            乘数
	 * @return 两个参数的积
	 */
	public static double mul2(double v1, double v2, int scale) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return round(b1.multiply(b2).doubleValue(), scale);
	}

	/**
	 * 提供精确的乘法运算。 保留scale 位小数 String
	 * 
	 * @param v1
	 *            被乘数
	 * @param v2
	 *            乘数
	 * @return 两个参数的积
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
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @return 两个参数的商
	 */
	public static BigDecimal div(String v1, String v2) {
		return div(v1, v2, DEF_DIV_SCALE);
	}

	/**
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2) {
		return div(v1, v2, DEF_DIV_SCALE);
	}

	/**
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @param scale
	 *            表示需要精确到小数点以后几位。
	 * @return 两个参数的商
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
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @param scale
	 *            表示需要精确到小数点以后几位。
	 * @return 两个参数的商
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
	 * 精确的除法运算。除不尽时，由scale参数指 定精度 四舍五入。string
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @param scale
	 *            表示需要精确到小数点以后几位。
	 * @return 两个参数的商
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
	 * 精确的除法运算。除不尽时，由scale参数指 定精度 四舍五入。string
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @param scale
	 *            表示需要精确到小数点以后几位。
	 * @return 两个参数的商
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
	 * 取余数 string
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
	 * 取余数 string
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
	 * 比较大小 如果v1 大于v2 则 返回true 否则false
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
	 * 比较大小 如果v1 大于等于v2 则 返回true 否则false
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
	 * 比较大小 如果v1 等于v2 则 返回true 否则false
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
	 * 取余数 BigDecimal
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
	 * 提供精确的小数位四舍五入处理。
	 * 
	 * @param v
	 *            需要四舍五入的数字
	 * @param scale
	 *            小数点后保留几位
	 * @return 四舍五入后的结果
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
	 * 提供精确的小数位四舍五入处理。string
	 * 
	 * @param v
	 *            需要四舍五入的数字
	 * @param scale
	 *            小数点后保留几位
	 * @return 四舍五入后的结果
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
