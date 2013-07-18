package com.andrew.MusicLibrary;

import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	public static final String NEW_LINES = "\n\n\n\n";
	public static final String DIVIDER = "\n===========================================\n";
	
	@RequestMapping("/")
	public String homePage(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		//List<String> headersList = new ArrayList<String>();
		List<String> requestAttributes = Collections.list(request.getAttributeNames());
		Writer w = response.getWriter();
		
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
}
