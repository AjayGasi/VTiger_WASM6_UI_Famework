package vTigerPractice;

import java.util.Random;

public class RandomNumberPractice {
	public static void main(String[] args) {
		Random ran=new Random();
		int value = ran.nextInt(500);
		System.out.println(value);
	}

}
