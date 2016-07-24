package edu.hhu.share.test;

import com.jfinal.core.JFinal;

public class Main {
	public static void main(String args[]){
		JFinal.start("WebRoot", 8080, "/", 5);
	}
}
