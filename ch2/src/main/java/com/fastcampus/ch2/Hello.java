package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. 원격 호출가능한 프로그램으로 등록

@Controller
public class Hello {
	int iv = 10; // 인스턴스 변수
	static int cv = 20; // static 변수 
	
	// 2. URL과 메서드를 연결
	// hello라는 URL과 main메소드가 연결된 것.
	@RequestMapping("/hello")
	private void main() { // 인스턴스 메서드 - iv, cv 둘 다 사용 가능
		System.out.println("Hello - private");
		System.out.println(cv); // OK
	//	System.out.println(iv); // OK 
		// -> 가능하면 인스턴스 메서드가 더 사용하기 좋은 것
		
	}
	public static void main2() { // static메서드 - cv만 사용 가능
		System.out.println(cv); // ok
//		System.out.println(iv); // 에러
	}
}
/*static이 없는데 어떻게 호출될 수 있었을까 ? 
 * 이유는 호출했을 때 현재 main은 인스턴스 메소드
 * 인스턴스 메소드는 객체 생성 후 호출 가능 
 * 객체를 생성해야하는데, 인스턴스 메소드가 호출 가능하다는 얘기는
 * 중간에서 누군가 객체 생성을 해준다는 얘기 
 * URL로 원격 프로그램을 호출하면 tomcat이 객체 생성을 해주고, 
 * 그 다음에 메서드 호출이 이루어짐. 
 * tomcat 내부에서 객체를 생성해주는 것.
 * static 넣어도 되긴 한다. 
 * */
