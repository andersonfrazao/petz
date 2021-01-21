package com.br.petz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/petz")
public class VersaoInfoController {
	
	@GetMapping("/info")
	public String getVersion() {
		
		String version = "1.0.0";
		
		return version;
		
	}

}
