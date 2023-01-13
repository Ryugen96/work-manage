package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class AttendanceListController {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private String string = "select hizuke,start,finish,rest,total from \"attendances\" ";
	
	@GetMapping("/attendanceList")
	public String attendanceList(Model model) {
	String sql = string;
		//String sql = "select id,date from \"attendances\"";
		List<Map<String, Object>> attendances = jdbcTemplate.queryForList(sql);
		model.addAttribute("attendances", attendances);
		System.out.println("hello");
		System.out.println(attendances);
		return "attendanceList";
	}

	@GetMapping("/attendanceListTest")
	public String hello() {
		//String sql = "INSERT INTO Attendances (id,date) Values (811,'2023-11-22')";
		//jdbcTemplate.update(sql);
		return "workplace";
	}
}