package br.alura.microrservice.carrier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.alura.microrservice.carrier.dto.DeliveryDTO;
import br.alura.microrservice.carrier.dto.VoucherDTO;
import br.alura.microrservice.carrier.service.EntregaService;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
	
	@Autowired
	private EntregaService entregaService;

	@RequestMapping(method = RequestMethod.POST)
	public VoucherDTO deliveryReservation(@RequestBody DeliveryDTO orderDTO) {
		return entregaService.reservaEntrega(orderDTO);
	}
}
