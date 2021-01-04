package br.com.alura.microservices.supplier.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservices.supplier.model.InfoSupplier;
import br.com.alura.microservices.supplier.service.InfoService;

@RestController
@RequestMapping("/info")
public class InfoController {
	private static final Logger LOG = LoggerFactory.getLogger(InfoController.class);

	@Autowired
	private InfoService infoService;
	
	@RequestMapping("/{state}")
	public InfoSupplier getInfoByState(@PathVariable String state) {
		LOG.info("Received request for information of {} supplier", state);
		return infoService.getInfoByState(state);
	}
}
