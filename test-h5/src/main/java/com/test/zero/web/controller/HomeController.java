package com.test.zero.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.test.zero.model.entity.user.UserInfoEntity;
import com.test.zero.service.common.user.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.util.*;

/**
 * Handles requests for the application home page.
 */
@Controller
@Slf4j
@RequestMapping("/test")
public class HomeController {

	@Resource
	private UserInfoService userInfoService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/{id}/{id2}/*", method = RequestMethod.GET)
    
	public @ResponseBody
	ModelAndView home(@PathVariable("id") String uid, @PathVariable("id2") String uid2, Locale locale, ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response) {
		log.info("Welcome home! The client locale is {}.", locale);
		System.out.println("uid="+uid);
		System.out.println("uid2="+uid2);
		System.out.println(request.getCharacterEncoding());
		System.out.println(response.getCharacterEncoding());
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		Map map=new HashMap<String,String>();
		map.put("name", "梁卫平" );
	

		modelAndView.addObject("serverTime", formattedDate );
		modelAndView.addObject("name", "梁卫平" );
	
		modelAndView.setViewName("hello");
		return modelAndView;
	}

	@RequestMapping(value = "/user", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject JSONObject(@RequestParam(value = "id",defaultValue ="0") int id, HttpServletRequest request, HttpServletResponse response, HttpSession session)throws Exception{
		JSONObject json = new JSONObject();
		log.info("213");
		System.out.println("啦啦啦啦啦");
		try
		{
          if(id!=0){
			  UserInfoEntity  userInfoEntity= userInfoService.getUserInfoById(id);
			  json.put("userInfo",userInfoEntity);
		  }
		  else{
			  List<UserInfoEntity> list= userInfoService.findUserInfo();
			  json.put("userInfo",list);
		  }
		}
		catch (Exception e)
		{
			log.info(e.getMessage(), e);
		}

		return json;
	}
}
