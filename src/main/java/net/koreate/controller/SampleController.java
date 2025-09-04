package net.koreate.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.koreate.vo.ProductVO;



/**
 * spring 이 관리하는 Bean 으로 등록되는 annotation
 * @Controller - mapping 정보가 등록된 Controller class
 * @Service    - Business Logic 을 처리하는 Service class 임을 명시
 * @Repository - 저장 데이터 처리 Class 임을 명시
 * 
 * @Component  - Spring Bean
 * Component 란 재사용이 가능한 각각의 독립된 모듈을 의미하며 Spring 에서 Spring IoC 관리하에
 * 지정된 범위 내에서 재사용 가능한 객체를 의미함.
 */
@Controller
public class SampleController {
	/**
	 * method 전송방식이 따로 지정되지 않으면
	 * GET, POST 전송방식에 상관없이 doA 요청 처리
	 */
	@RequestMapping("doA")
	public String doA() {
		System.out.println("SampleController doA() 호출");
		// /WEB-INF/views/doA.jsp
		return "doA";
	}
	
	// [/WEB-INF/views/doB.jsp]을(를) 찾을 수 없습니다.
	/**
	 * 반환타입이 void 일 경우에는 처리할 요청 URL 이 파일 이름으로 사용
	 * 처리할 mapping 경로가 doB 이므로
	 * 처리 후 출력할 웹 페이지는 
	 *  "/WEB-INF/views" + "doB" + ".jsp" 로 조합
	 */
	@RequestMapping(value="doB", method=RequestMethod.GET)
	public void doB() {
		System.out.println("doB () 호출");
	}
	
	// @RequestMapping(value="doC", method=RequestMethod.GET)와 동일한 mapping
	@GetMapping("doC") // import 추가 
	public String doC(HttpServletRequest request, Model model) {
		/**
		 * Model model - request 요청 처리 후 출력되는 jsp 페이지에 
		 * 				 model data를 추가하는 Spring 객체
		 */
		request.setAttribute("message", "doC request attribute");
		model.addAttribute("msg", "doC model attribute");
		// /WEB-INF/views/result.jsp
		return "result";
	}
	
	// <a href="doD?msg=doDgetRequest">doD</a>
	@GetMapping("doD")
	public String doD(HttpServletRequest request) {
		String msg = request.getParameter("msg");
		System.out.println("doD Get 호출 : msg - " + msg);
		request.setAttribute("msg", msg); // 출력 페이지에 데이터 추가
		return "result";
	}
	
	// @RequestMapping(value="doD", method=RequestMethod.POST)와 동일한 mapping
	@PostMapping("doD")
	public String doDPost(HttpServletRequest request) {
		String name = request.getParameter("name");
		String paramPrice = request.getParameter("price");
		int price = Integer.parseInt(paramPrice);
		System.out.println("상품 이름 : " + name);
		System.out.println("상품 가격 : " + price);
		request.setAttribute("name", name);
		request.setAttribute("price", price);
		return "result";
	}
	
	@PostMapping("doE")
	public String doE(
				@RequestParam(name="name", required=true, defaultValue = "RADIO") String productName,
				@RequestParam(name="price") int productPrice,
				Model model
			) {
		System.out.println("param name : " + productName);
		System.out.println("param price : " + productPrice);
		model.addAttribute("name", productName);
		model.addAttribute("price", productPrice);
		return "result";
	}
	
	/**
	 * 매개변수 타입이 SpringFramework에 지정된 타입이 아니면
	 * request 에서 파라미터 검색 - 매개변수의 이름이 파라미터 이름으로 사용
	 * required = true : 필수 값으로 전달되는 파라미터가 없으면 예외 발생
	 */
	@PostMapping("doF")
	public String doF(String name, int price, Model model) {
		System.out.println("name : " + name);
		System.out.println("price : " + price);
		
		ProductVO product = new ProductVO(1, name, price);
		model.addAttribute("product", product);
		
		// /WEB-INF/views/product.jsp
		return "product";
	}
	
	/**
	 * 기본 생성자로 ProductVO 객체 생성,
	 * ProductVO 에 명시된 필드 이름과 일치하는 파라미터를 우선 검색
	 * 필드이름과 일치하는 setter method를 이용해서 파라미터 데이터를 필드에 추가 한 후
	 * doG(mav, product); method 호출
	 */
	@PostMapping("doG")
	public ModelAndView doG(ModelAndView mav, ProductVO product) {
		System.out.println("doG() 호출");
		System.out.println("product : " + product);
		/**
		 * model 정보를 추가할때 key 가 생략이 되면
		 * 추가되는 객체의 class 이름의 첫글자만 소문자로 변경된 key 값이 자동으로 추가
		 * ProductVO == productVO
		 */
		mav.addObject(product);
		mav.addObject("product", product);
		mav.setViewName("product");
		return mav;
	}
	
	@GetMapping("redirect")
	public String redirect() {
		System.out.println("redirect 요청");
		/**
		 * 반환뷰 페이지 정보가 redirect: 로 시작하면
		 * 반환된 문자열에 명시된 경로로 재요청 할 수 있도록 sendRedirect 실행
		 * response.sendRedirect("/main.home");
		 */
		return "redirect:/main.home";
	}
	
}


























