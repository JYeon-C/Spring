package com.fastcampus.ch2;

import java.lang.reflect.Method; // reflect��Ű�� ���� Method Ŭ����. �޼ҵ� ������ ���

public class PrivateMethodCall {
	public static void main(String[] args) throws Exception {
	//	Hello hello = new Hello();
	//	hello.main(); // private�� �ܺ� ȣ�� �Ұ�
		
		// Relfection API�� ��� - Ŭ���� ������ ��� �ٷ� �� �ִ� ������ ��� ���� 
		// java.lang.reflect��Ű���� ����
		// HelloŬ������ Class��ü(Ŭ������ ������ ��� �ִ� ��ü)�� ���´�. 
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		Hello hello = (Hello)helloClass.newInstance(); // Class��ü�� ���� ������ ��ü ����
		Method main = helloClass.getDeclaredMethod("main"); // main�̶� �޼ҵ��� ������ ������ ��. 
		main.setAccessible(true); // private�� main()�� ȣ�� �����ϰ� �ϴ� ��. 
		
		
		main.invoke(hello); //  = hello.main()
	}

}
