package com.ovium.restfulservices.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired
	private ResourceBundleMessageSource messageSource;

	@GetMapping("/hello")
	public String hello() {
		return "Hello World1";
	}

	@GetMapping("/locale")
	public String INI18NFormat(@RequestHeader(name = "Accept-Language", required = false) String local) {

		return messageSource.getMessage("label.hello", null, new Locale(local));
	}

	@GetMapping("springlocale")
	public String INI18Locale() {
		return messageSource.getMessage("label.hello", null, LocaleContextHolder.getLocale());
	}

}
