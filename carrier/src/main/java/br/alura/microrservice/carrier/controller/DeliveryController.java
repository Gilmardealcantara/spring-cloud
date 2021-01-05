package br.alura.microrservice.carrier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.alura.microrservice.carrier.dto.EntregaDTO;
import br.alura.microrservice.carrier.dto.VoucherDTO;
import br.alura.microrservice.carrier.model.Entrega;
import br.alura.microrservice.carrier.service.EntregaService;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
	
	@Autowired
	private EntregaService entregaService;

	@RequestMapping(method = RequestMethod.POST)
	public VoucherDTO deliveryReservation(@RequestBody EntregaDTO orderDTO) {
		return entregaService.reservaEntrega(orderDTO);
	}
}
