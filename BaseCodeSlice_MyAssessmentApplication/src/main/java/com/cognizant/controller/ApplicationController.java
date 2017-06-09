package com.cognizant.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApplicationController {

	// Add appropriate annotations and code wherever required
	
	@Autowired
    private MessageSource messageSource;
	
	@RequestMapping(value="/i18nPage", method=RequestMethod.GET)
	public String getI18n(@RequestParam("language") String language, Model model){
		
		Locale setCurrentLocale = new Locale(language);

        String welcome = messageSource.getMessage("welcome", new Object[]{"Carl Mark"}, setCurrentLocale);
        System.out.println(welcome);
        model.addAttribute("message", welcome);
        
		return "i18nPage";
	}


}
