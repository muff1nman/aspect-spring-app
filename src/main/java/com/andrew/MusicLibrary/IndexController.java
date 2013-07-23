package com.andrew.MusicLibrary;

import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
	
	@Resource
	private RandomService randomService;
	
	public static final String NEW_LINES = "\n\n\n\n";
	public static final String DIVIDER = "\n===========================================\n";
	
	@RequestMapping("/")
	public String homePage(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		//List<String> headersList = new ArrayList<String>();
		List<String> requestAttributes = Collections.list(request.getAttributeNames());
		Writer w = response.getWriter();
		
		w.write("Random number: " + randomService.doRandom());
		
		w.write(NEW_LINES);
		w.write("ServletRequest Attributes");
		w.write(DIVIDER);
		
		for( String key : requestAttributes ) {
			String toPrint = "key: " + key + "\nvalue: " + request.getAttribute(key) + "\n";
			w.write(toPrint);
			//headersList.add( toPrint );
		}
		
		w.write(NEW_LINES);
		w.write("Request Local IP");
		w.write(DIVIDER);
		
		w.write(request.getLocalAddr());
		
		w.write(NEW_LINES);
		w.write("Request Local Port");
		w.write(DIVIDER);
		
		w.write(request.getLocalPort());
		
		w.write(NEW_LINES);
		w.write("Request Remote IP");
		w.write(DIVIDER);
		
		w.write(request.getRemoteAddr());
		
		w.write(NEW_LINES);
		w.write("Request Remote Port");
		w.write(DIVIDER);
		
		w.write(request.getRemotePort());
		
		w.write(NEW_LINES);
		w.write("Request Header");
		w.write(DIVIDER);
		
		Enumeration<String> requestHeaderNames = request.getHeaderNames();
		while(requestHeaderNames.hasMoreElements()) {
			String headerName = requestHeaderNames.nextElement();
			w.write("Header Name: \n" + headerName + "\n");
			w.write("Value: \n" + request.getHeader(headerName) + "\n");
		}
		
		w.write(NEW_LINES);
		w.write("Request Parameters");
		w.write(DIVIDER);
		
		Map<String, String[]> requestMap = request.getParameterMap();
		System.out.println(request.getParameterMap());
		for( Map.Entry<String, String[]> entry : requestMap.entrySet() ) {
			w.write("KEY: \n" + entry.getKey() + "\n");
			w.write("VALUES: \n");
			for( String each : entry.getValue()) {
				w.write("    " + each + "\n");
			}
			
		}
		
		w.close();
		return null;
		//return "/jsp/index";
	}
	
	@RequestMapping("/pepboys_qa/cgi/csg")
	public @ResponseBody String getStoreResults(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "USER_REMOTE_ADDR", required = true) String userRemoteAddr) throws Exception {
		
//		URL url = new URL("http://freegeoip.net/json/50.58.217.226");
		
		String results = "{" +
			"\"statusCode\": \"0\", " +
			"\"statusString\": \"Success\", " +
			"\"count\": 2, " +
			"\"locations\": " +
				"[" +
				"{\"KEY\":\"07980\", \"ADDR\":\"8000 Stream Walk Ln\", \"CITY\": \"Manassas\", \"STATE\":\"VA\", \"ZIP\": \"20109\"}, " +
				"{\"KEY\":\"07922\", \"ADDR\":\"10275 North Fwy\", \"CITY\":\"Houston\", \"STATE\":\"TX\", \"ZIP\":\"77037\"} " +
				"]" +
			"}";
		
//		StoreSearchResult results = new StoreSearchResult();
//		
//		Store houston = new Store();
//		houston.setKey("07922");
//		houston.setAddress("10275 North Fwy");
//		houston.setCity("Houston");
//		houston.setState("TX");
//		houston.setZipCode("77037");
//		
//		Store manassas = new Store();
//		manassas.setKey("07980");
//		manassas.setAddress("8000 Stream Walk Ln");
//		manassas.setCity("Manassas");
//		manassas.setState("VA");
//		manassas.setZipCode("20109");
//		
//		List<Store> storeList = new ArrayList<Store>();
//		storeList.add(houston);
//		storeList.add(manassas);
//		
//		results.setStatusCode(0);
//		results.setStatus("Success");
//		results.setCount(2);
//		results.setStores(storeList);
		
		return results;
	}
}
