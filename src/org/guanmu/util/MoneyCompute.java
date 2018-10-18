package org.guanmu.util;

import java.math.BigDecimal;

/**
 * <p>
 * 类描述:
 * <p>
 * 
 * 所属插件:
 * @author wangquan 2018-10-18
 * 
 */
public class MoneyCompute {
	
	static double[] TAX_RATE = { 0.03,  0.1,   0.2,  0.25,   0.3,  0.35,  0.45 };
	static int[] BEFORE_LINE = { 3500, 5000,  8000, 12500, 38500, 58500, 83500 };
	static int[] NOW_LINE    = { 5000, 8000, 17000, 30000, 40000, 60000, 85000 };
	
	
	public static void main(String[] args) {
		double money = 8000;
		
		double beforeTax = beforeComputeTax(money);
		System.out.println("before tax   :    " + beforeTax);
		System.out.println("before money :    " + formatValue(money - beforeTax));
		
		double nowTax = nowComputeTax(money);
		System.out.println("now tax      :    " + nowTax);
		System.out.println("now money    :    " + formatValue(money - nowTax));		
		
		System.out.println("more get     :    " + formatValue(beforeTax - nowTax));
		System.out.println("more get rate:    " + formatValue((beforeTax - nowTax) * 100/beforeTax) + "%");
	}

	/**
	 * @param money
	 * @return
	 */
	private static double beforeComputeTax(double money) {
		
		return computeTax(money,BEFORE_LINE);
	}

	/**
	 * @param money
	 * @return
	 */
	private static double nowComputeTax(double money) {
		
		return computeTax(money,NOW_LINE);
	}	
	
	/**
	 * @param money
	 * @param moneyLines
	 * @return
	 */
	private static double computeTax(double money, int[] moneyLines) {
		double tax = 0;
		
		double remainMoney = money;
		for(int i = moneyLines.length - 1;i >= 0;i--) {
			int line = moneyLines[i];
			
			double tmpTaxMoney = remainMoney - line;
			if (tmpTaxMoney <= 0) {
				continue;
			}
			
			tax += tmpTaxMoney * TAX_RATE[i];
			remainMoney -= tmpTaxMoney;
		}
		return formatValue(tax);
	}

	/**
	 * @param tax
	 * @return
	 */
	private static double formatValue(double tax) {
		BigDecimal bd = new BigDecimal(tax);
		return bd.setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	
}
