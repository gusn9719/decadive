package kr.ac.kopo.framework;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Controller {
	public String handleRequest(HttpServletRequest request, 
						HttpServletResponse response) throws Exception;
}
