package edu.hhu.share.test;

import java.util.Date;

public class TestMain {

	public static void main(String args[]){
		Date a = new Date(2016, 7, 8, 10, 10, 10);
		System.out.println(a.getTime());
		Date b = new Date(2016, 7, 9, 10, 20, 10);
		System.out.println(b.getTime());
		long deta = b.getTime() - a.getTime();
		double x = (double)deta/(24*3600*1000);
		System.out.println(x);
	}
}
