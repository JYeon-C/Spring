package com.fastcampus.ch2;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// ��,��,���� �Է��ϸ� �ش� ��¥�� �˷��ִ� ���α׷� 
@Controller
public class YoilTeller {
	@RequestMapping("/getYoil")
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// args�� String ���ڿ��� ������ ���� ������ �� ���� ����
		// 1. �Է�
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		 
		int yyyy = Integer.parseInt(year); // ���ڷ� �ٲ�
		int mm = Integer.parseInt(month); 
		int dd = Integer.parseInt(day);
		
		// 2. �۾�
		// ��¥ ����
		Calendar cal = Calendar.getInstance(); 
		cal.set(yyyy, mm -1, dd);
		
		// get�޼ҵ� �̿��ؼ� ������ �˾Ƴ� �� ����. -> ������ ���ڷ� ����
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1:�Ͽ���, 2:������ ... 
		char yoil  = " �Ͽ�ȭ�������".charAt(dayOfWeek); // �� ���ڸ� ���ڷ� �ٲ���.  
		
		// 3. ���
		response.setContentType("text/thml");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter(); // response��ü���� �귯�������� ��� ��Ʈ���� ��´�. 
		out.println("<html>"); // ��� 
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println(year + "�� " + month + "�� " + day + "���� ");  // �ٷ� out���� 
		out.println(yoil + "�����Դϴ�.");
		out.println("<body>");
		out.println("</body>");
		out.println("</html>");
		

	}

}
