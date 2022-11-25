package com.fastcampus.ch2;

import java.lang.reflect.Method; // reflect패키지 내의 Method 클래스. 메소드 참조시 사용

public class PrivateMethodCall {
	public static void main(String[] args) throws Exception {
	//	Hello hello = new Hello();
	//	hello.main(); // private라서 외부 호출 불가
		
		// Relfection API를 사용 - 클래스 정보를 얻고 다룰 수 있는 강력한 기능 제공 
		// java.lang.reflect패키지를 제공
		// Hello클래스의 Class객체(클래스의 정보를 담고 있는 객체)를 얻어온다. 
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		Hello hello = (Hello)helloClass.newInstance(); // Class객체가 가진 정보로 객체 생성
		Method main = helloClass.getDeclaredMethod("main"); // main이란 메소드의 정보를 가지고 옴. 
		main.setAccessible(true); // private인 main()을 호출 가능하게 하는 것. 
		
		
		main.invoke(hello); //  = hello.main()
	}

}
