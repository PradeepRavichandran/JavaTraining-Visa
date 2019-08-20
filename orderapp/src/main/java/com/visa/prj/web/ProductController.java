package com.visa.prj.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Item;
import com.visa.prj.entity.Order;
import com.visa.prj.entity.Product;
import com.visa.prj.service.OrderService;

@Controller
public class ProductController {

	@Autowired
	private OrderService os;
	
	@Autowired
	private ProductValidator validator;
	@RequestMapping("Listproducts.do")
	public ModelAndView getProducts() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("list.jsp");
		
		//"products" we are using in list.jsp so we are sending that
		mav.addObject("products", os.fetchProducts());
		
		return mav;
	}
	
	@RequestMapping("productform.do")
	public ModelAndView getProductForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("form.jsp");
		
		//sending an empty product whose values will be binded with form fields
		mav.addObject("product",new Product());
		return mav;
	}
	
	@RequestMapping("addproduct.do")
	public String addProduct(@ModelAttribute("product") Product p, BindingResult errors, Model m) {
		validator.validate(p, errors);
		if(errors.hasErrors()) {
			return "form.jsp";
		}
		else {
			os.insertProduct(p);
			m.addAttribute("msg","Product added successfully!!");
			
			//use this when we don't have any model data to send to the view-.jsp page
			return "index.jsp";
		}
	}
	
	@RequestMapping("cart.do")
	@Transactional
	public String addToCart(HttpServletRequest req) {
		String[] prds = req.getParameterValues("prds");   //only product ids will be there
		HttpSession ses = req.getSession();
		String email = (String) ses.getAttribute("user");
		os.createOrder(prds, email );

		return "redirect:index.jsp";
	}
}
