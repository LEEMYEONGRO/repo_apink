package com.blackpink.infra.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class TestController {

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/testList")
	public String testList(Model model) throws Exception {
		
		String apiUrl = "http://apis.data.go.kr/1471000/CovidDagnsRgntProdExprtStusService/getMmCovidDagnsRgntExprtStusInq?serviceKey=oTO8CGvbxM3M1rTITP6utisQ6gOjYvwqWznKivddm46vqtg8lpLpqIkA9GW0lc3zbHifPhWKruCWvnaQzDlWdA%3D%3D&numOfRows=3&pageNo=1&type=json";

		URL url = new URL(apiUrl);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");
		
		BufferedReader bufferedReader;
		if (httpURLConnection.getResponseCode() >= 200 && httpURLConnection.getResponseCode() <= 300) {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		} else {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println("line: " + line);
			stringBuilder.append(line);
		}
		
		bufferedReader.close();
		httpURLConnection.disconnect();
		
      ObjectMapper objectMapper = new ObjectMapper();
      
      Map<String, Object> map = objectMapper.readValue(stringBuilder.toString(), Map.class);
      
      System.out.println("######## Map");
		for (String key : map.keySet()) {
			String value = String.valueOf(map.get(key));	// ok
			System.out.println("[key]:" + key + ", [value]:" + value);
		}
		
		Map<String, Object> header = new HashMap<String, Object>();
		header = (Map<String, Object>) map.get("header");
		
		System.out.println("######## Header");
		for (String key : header.keySet()) {
			String value = String.valueOf(header.get(key));	// ok
			System.out.println("[key]:" + key + ", [value]:" + value);
		}
		
		String aaa = (String) header.get("resultCode");
		
		System.out.println("header.get(\"resultCode\"): " + header.get("resultCode"));
		System.out.println("header.get(\"resultMsg\"): " + header.get("resultMsg"));
		
		Map<String, Object> body = new HashMap<String, Object>();
		body = (Map<String, Object>) map.get("body");
		
//		List<Home> items = new ArrayList<Home>();
//		items = (List<Home>) body.get("items");
//		
//		System.out.println("items.size(): " + items.size());
//		
//		System.out.println("items.toString(): " + items.toString());
		
//		model.addAllAttributes(map);
		model.addAllAttributes(header);
		model.addAllAttributes(body);
		
//		model.addAttribute("header", header);
//		model.addAttribute("body", body);
		
		return "v1/infra/test/testList";
	}
	
}
