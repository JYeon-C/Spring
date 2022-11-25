package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. ���� ȣ�Ⱑ���� ���α׷����� ���

@Controller
public class Hello {
	int iv = 10; // �ν��Ͻ� ����
	static int cv = 20; // static ���� 
	
	// 2. URL�� �޼��带 ����
	// hello��� URL�� main�޼ҵ尡 ����� ��.
	@RequestMapping("/hello")
	private void main() { // �ν��Ͻ� �޼��� - iv, cv �� �� ��� ����
		System.out.println("Hello - private");
		System.out.println(cv); // OK
	//	System.out.println(iv); // OK 
		// -> �����ϸ� �ν��Ͻ� �޼��尡 �� ����ϱ� ���� ��
		
	}
	public static void main2() { // static�޼��� - cv�� ��� ����
		System.out.println(cv); // ok
//		System.out.println(iv); // ����
	}
}
/*static�� ���µ� ��� ȣ��� �� �־����� ? 
 * ������ ȣ������ �� ���� main�� �ν��Ͻ� �޼ҵ�
 * �ν��Ͻ� �޼ҵ�� ��ü ���� �� ȣ�� ���� 
 * ��ü�� �����ؾ��ϴµ�, �ν��Ͻ� �޼ҵ尡 ȣ�� �����ϴٴ� ����
 * �߰����� ������ ��ü ������ ���شٴ� ��� 
 * URL�� ���� ���α׷��� ȣ���ϸ� tomcat�� ��ü ������ ���ְ�, 
 * �� ������ �޼��� ȣ���� �̷����. 
 * tomcat ���ο��� ��ü�� �������ִ� ��.
 * static �־ �Ǳ� �Ѵ�. 
 * */
