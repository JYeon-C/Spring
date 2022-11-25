package com.fastcampus.ch2;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// ��,��,���� �Է��ϸ� �ش� ��¥�� �˷��ִ� ���α׷� 
@Controller
public class YoilTellerMVC { // http://localhost/ch2/getYoilMVC?year=2021&month=10&day=1
	@RequestMapping("/getYoilMVC")
	
	// �޼ҵ��� ��ȯ Ÿ���� String���� ����!(=> view ����)
	public String main(int year, int month, int day , Model model) throws IOException{

		// 1. ��ȿ�� �˻�
			if(!isVaild(year,month,day))
				return "yoilError";
			
		// 2. ���� ���
		char yoil = getYoil(year, month, day);
		
		// 3. ����� ����� model�� ����(������ ��� �ȳ���!)
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("yoil", yoil);
		return "yoil"; // WEB-INF/views/yoil.jsp �並 ����
		

	}

private boolean isVaild(int year, int month, int day) {
		// TODO Auto-generated method stub
		return true;
	}

private char getYoil(int year, int month, int day) {
	Calendar cal = Calendar.getInstance(); 
	cal.set(year, month -1, day); 
	
	// get�޼ҵ� �̿��ؼ� ������ �˾Ƴ� �� ����. -> ������ ���ڷ� ����
	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1:�Ͽ���, 2:������ ... 
	return " �Ͽ�ȭ�������".charAt(dayOfWeek); // �� ���ڸ� ���ڷ� �ٲ���.  
}

}