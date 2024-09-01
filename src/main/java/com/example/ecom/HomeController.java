package com.example.ecom;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {
	
	
	@RequestMapping("/nestest")
	@ResponseBody
	public HashMap<String, String> newtest() {
		System.out.println("this is new testing");
		HashMap<String, String> ob = new HashMap<>();
		ob.put("sname", "name1");
		ob.put("sname1", "name1");
		ob.put("sname2", "name1");
		ob.put("sname3", "name1");
		return ob;
	}

}
