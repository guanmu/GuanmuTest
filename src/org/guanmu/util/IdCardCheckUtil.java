/* Copyright 2002-2012 the original author or authors. */
package org.guanmu.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 类描述:
 * <p>
 * 
 * 所属包:org.guanmu.util
 * 
 * @author guanmu 2018-2-5
 * 
 */
public class IdCardCheckUtil {

	private static int ID_LENGTH = 18;

	private static int MALE_POSITION = 16;	
	
	private static int[] WEIGHTS = new int[] { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };

	private static int DIVIDEND = 11;
	
	/**
	 * T = sum % DIVIDEND;
	 * R = (12 -T) % DIVIDEND;
	 * 	R == 10, 结果为"X"；
	 * 	R != 10, 结果为R。
	 */
	private static String[] MOD_VALUES = new String[] { "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" };
	
	private static List<String> MOD_VALUES_LIST = Arrays.asList(MOD_VALUES);
	
	public static void main(String[] args) {
		String idNum = "421381199310086458";
		
		boolean isCheck = valid(idNum);
		if (!isCheck) {
			System.out.println("the id card not right.");
			return;
		}
		
		String maleStr = readMaleInfo(idNum);
		System.out.println("性别：" + maleStr);
		
		String lastChar = calculateLastChar(idNum);
		System.out.println("校验位：" + lastChar);
		
		boolean isOk = lastChar.equals("" + idNum.charAt(ID_LENGTH - 1));
		System.out.println("是否校验通过：" + (isOk ? "是":"否"));
	}



	/**
	 * @param idNum
	 * @return
	 */
	private static String calculateLastChar(String idNum) {
		String preStr = idNum.substring(0, ID_LENGTH - 1);
		int[] numbers = new int[ID_LENGTH - 1];
		for(int i = 0;i < ID_LENGTH - 1;i++) {
			String tmp = "" + preStr.charAt(i);
			int number = Integer.valueOf(tmp);
			numbers[i] = number;
		}
		
		int sum = 0;
		for(int i = 0;i < ID_LENGTH - 1;i++) {
			sum += numbers[i] * WEIGHTS[i];
		}
		
		int mod = sum % DIVIDEND;
		
		return MOD_VALUES[mod];
	}



	/**
	 * @return
	 */
	private static String readMaleInfo(String idNum) {
		String maleStr = "" + idNum.charAt(MALE_POSITION);
		
		int maleInt = Integer.parseInt(maleStr);
		
		boolean isMale = ((maleInt & 1) != 0);
		
		if (isMale) {
			return "男";
		} else {
			return "女";
		}
	}



	/**
	 * @param idNum
	 * @return
	 */
	public static boolean valid(String idNum) {
		if (idNum == null) {
			return false;
		}
		
		if (idNum.length() != ID_LENGTH) {
			return false;
		}
		
		String pre = idNum.substring(0, ID_LENGTH - 1);
		
		for(int i = 0;i < pre.length();i++) {
			char c = pre.charAt(i);
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		
		String last = "" + idNum.charAt(ID_LENGTH - 1);
		
		if (!MOD_VALUES_LIST.contains(last)) {
			return false;
		}
		
		return true;
	}
}
