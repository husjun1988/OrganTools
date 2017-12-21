package com.gwxa.base.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@SuppressWarnings({ "rawtypes", "unchecked" })
public class StringUtil {
	/**
	 * 字符串连接
	 */
	public static String linkArray(String linker, Object... objects) {
		if (null == linker) {
			linker = "";
		}
		if (null == objects || 0 == objects.length) {
			return "";
		} else {
			String result = "";
			for (Object each : objects) {
				result += each + linker;
			}
			return substring(result, -linker.length());
		}
	}

	/**
	 * 字符串连接
	 */

	public static String linkCollection(Collection results, String linker) {
		if (null == results) {
			return null;
		} else {
			return linkArray(linker, results.toArray(new Object[0]));
		}
	}

	/**
	 * 验证是否手机号
	 */
	public static Boolean isMobileNo(String mobileNo) {
		Pattern pattern = Pattern.compile("^((1[358][0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		Matcher matcher = pattern.matcher(mobileNo);
		return matcher.matches();
	}

	/**
	 * 生成四位随机数
	 */
	public static String radomNumber(Integer width) {
		return new DecimalFormat(dup("#", width)).format(Math.random() * 10000);
	}

	/**
	 * 分割字符串为数组
	 */
	public static String[] split(String string, String spliter) {
		if (VerifyUtil.isEmpty(string) || VerifyUtil.isEmpty(spliter)) {
			return new String[0];
		} else {
			return string.split(spliter);
		}
	}

	/**
	 * splitToIntArray
	 */
	public static Integer[] splitToIntArray(String string, String spliter) {
		String[] strs = split(string, spliter);
		Integer[] ints = new Integer[strs.length];
		for (int i = 0; i < strs.length; i++) {
			ints[i] = Integer.valueOf(strs[i]);
		}
		return ints;
	}

	/**
	 * splitToIntList
	 */
	public static List<Integer> splitToIntList(String string, String spliter) {
		return Arrays.asList(splitToIntArray(string, spliter));
	}

	/**
	 * toIntArray
	 */
	public static Integer[] toIntArray(String[] strs) {
		Integer[] ints = new Integer[null == strs ? 0 : strs.length];
		for (int i = 0; i < ints.length; i++) {
			ints[i] = Integer.valueOf(strs[i]);
		}
		return ints;
	}

	/**
	 * @param string 不可为空 可能有越界异常
	 * @param endIndex 负数为反向截取
	 */
	public static String substring(String string, Integer endIndex) {
		if (string ==null || string.length() == 0) {
			return null;
		}
		if (string.length()  <= endIndex) {
			return string;
		}
		return substring(string, 0, endIndex);
	}

	/**
	 * @param string 不可为空 可能有越界异常
	 * @param startIndex 负数为反向截取
	 * @param endIndex 负数为反向截取
	 */
	public static String substring(String string, Integer startIndex, Integer endIndex) {
		if (startIndex < 0) {
			startIndex = string.length() + startIndex;
		}
		if (endIndex < 0) {
			endIndex = string.length() + endIndex;
		}
		return string.substring(startIndex, endIndex);
	}

	/**
	 * 首字母大写
	 */
	public static String upcaseFirst(String string) {
		return string.substring(0, 1).toUpperCase() + string.substring(1);
	}

	/**
	 * 判断是否包含
	 */
	public static Boolean containsIgnoreCase(String string, String str) {
		return null != string && null != str && string.toUpperCase().contains(str.toUpperCase());
	}

	/**
	 * 在数组中搜索包含特定字符串的项
	 */
	public static String searchContains(String[] values, String value, String defaultValue) {
		for (String _value : values) {
			if (containsIgnoreCase(_value, value)) {
				return _value;
			}
		}
		return defaultValue;
	}

	public static Boolean isNotEmpty(String string) {
		return null != string && !string.trim().isEmpty();
	}

	/**
	 * 16进制的字节转成字符串
	 * @param bytes
	 * @return
	 */
	public static String bytes2Hex(byte[] bytes) {
		String des = "";
		String tmp = null;
		for (int i = 0; i < bytes.length; i++) {
			tmp = (Integer.toHexString(bytes[i] & 0xFF));
			if (tmp.length() == 1) {
				des += "0";
			}
			des += tmp;
		}
		return des;
	}

	/**
	 * 十六进制转换字符串
	 * @param String str Byte字符串(Byte之间无分隔符 如:[616C6B])
	 * @return String 对应的字符串
	 */
	public static byte[] hexStr2Byte(String hexStr)
	{
	    String str = "0123456789abcdef";
	    char[] hexs = hexStr.toCharArray();
	    byte[] bytes = new byte[hexStr.length() / 2];
	    int n;

	    for (int i = 0; i < bytes.length; i++)
	    {
	        n = str.indexOf(hexs[2 * i]) * 16;
	        n += str.indexOf(hexs[2 * i + 1]);
	        bytes[i] = (byte) (n & 0xff);
	    }
	    return bytes;
	}

	/**
	 * bytes字符串转换为Byte值
	 * @param String src Byte字符串，每个Byte之间没有分隔符
	 * @return byte[]
	 */
	public static byte[] hexStr2Bytes(String src) {
	    int m=0,n=0;
	    int l=src.length()/2;
	    System.out.println(l);
	    byte[] ret = new byte[l];
	    for (int i = 0; i < l; i++)
	    {
	        m=i*2+1;
	        n=m+1;
	        ret[i] = Byte.decode("0x" + src.substring(i*2, m) + src.substring(m,n));
	    }
	    return ret;
	}

	/**
	 * bytes转换成十六进制字符串
	 * @param byte[] b byte数组
	 * @return String 每个Byte值之间空格分隔
	 */
	public static String byte2HexStr(byte[] b)
	{
	    String stmp="";
	    StringBuilder sb = new StringBuilder("");
	    for (int n=0;n<b.length;n++)
	    {
	        stmp = Integer.toHexString(b[n] & 0xFF);
	        sb.append((stmp.length()==1)? "0"+stmp : stmp);
	        sb.append(" ");
	    }
	    return sb.toString().toLowerCase().trim();
	}

	public static String encrypt(String strSrc) {
		MessageDigest md = null;
		String strDes = null;
		byte[] bt = strSrc.getBytes();
		try {
			md = MessageDigest.getInstance("SHA-1");
			md.update(bt);
			strDes = StringUtil.bytes2Hex(md.digest());
		} catch (NoSuchAlgorithmException e) {
			System.out.println("错误");
			return null;
		}
		return strDes;
	}

	public static Boolean startWith(String string, String str) {
		throw Errors.noImplement();
	}

	public static Boolean isEmpty(String string) {
		return null == string || string.trim().isEmpty();
	}

	/**
	 * 检测字符串是否为,间隔的数字列表的静态方法
	 */
	public static boolean isIntList(String numlist) {
		if (numlist == null || numlist.isEmpty())
			return false;
		return Pattern.matches("^-?[0-9]+(,-?[0-9]+)*$", numlist)
				|| Pattern.matches("^'-?[0-9]+'(,'-?[0-9]+')*$", numlist);
	}

	public static String alignLeft(Object o, int width, String c) {
		if (null == o)
			return null;
		String s = o.toString();
		int length = s.length();
		if (length >= width)
			return s;
		return new StringBuilder().append(s).append(dup(c, width - length)).toString();
	}

	public static String alignRight(Object o, int width, String c) {
		if (null == o)
			return null;
		String s = o.toString();
		int length = s.length();
		if (length >= width)
			return s;
		return new StringBuilder().append(dup(c, width - length)).append(s).toString();
	}

	public static String dup(String cs, int num) {
		if (null == cs || num <= 0)
			return "";
		StringBuilder sb = new StringBuilder(cs.length() * num);
		for (int i = 0; i < num; i++)
			sb.append(cs);
		return sb.toString();
	}

	public static Integer count(String line, char c) {
		int num = 0;
		char[] chars = line.toCharArray();
		for (char _c : chars) {
			if (_c == c) {
				num++;
			}
		}
		return num;
	}

	public static Boolean equals(String str1, String str2) {
		return null != str1 && null != str2 && str1.equals(str2);
	}

	public static String lowerFirst(String input) {
		return input.substring(0, 1).toLowerCase() + input.substring(1);
	}

	public static String subStrByRight(String str,Integer i){
		if (str.length() <= i) {
			return null;
		}
		return str.substring(0, str.length()-i);
	}

	/**
	 * 判断字符串是否存在于带符号的字符串中
	 * */
	public static Boolean isInString(String str1, String str2, String patten) {
		boolean ok =false;
		if(null == str1 || null == str2 || null == patten) return ok;
		String[] bhs = str1.split(patten);
		for(String bh : bhs) {
			if(bh.equals(str2)) ok = true;
		}
		return ok;
	}


	/*public static void main(String[] args) {
		System.out.println(isInString("4,5,6,13,23,33,43","3",","));
	}*/
}
