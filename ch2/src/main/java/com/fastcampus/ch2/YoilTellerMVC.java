package com.fastcampus.ch2;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// 연,월,일을 입력하면 해당 날짜를 알려주는 프로그램 
@Controller
public class YoilTellerMVC { // http://localhost/ch2/getYoilMVC?year=2021&month=10&day=1
	@RequestMapping("/getYoilMVC")
	
	// 메소드의 반환 타입을 String으로 수정!(=> view 지정)
	public String main(int year, int month, int day , Model model) throws IOException{

		// 1. 유효성 검사
			if(!isVaild(year,month,day))
				return "yoilError";
			
		// 2. 요일 계산
		char yoil = getYoil(year, month, day);
		
		// 3. 계산한 결과를 model에 저장(없으면 결과 안나옴!)
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("yoil", yoil);
		return "yoil"; // WEB-INF/views/yoil.jsp 뷰를 지정
		

	}

private boolean isVaild(int year, int month, int day) {
		// TODO Auto-generated method stub
		return true;
	}

private char getYoil(int year, int month, int day) {
	Calendar cal = Calendar.getInstance(); 
	cal.set(year, month -1, day); 
	
	// get메소드 이용해서 요일을 알아낼 수 있음. -> 요일이 숫자로 나옴
	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1:일요일, 2:월요일 ... 
	return " 일월화수목금토".charAt(dayOfWeek); // 이 숫자를 문자로 바꿔줌.  
}

}