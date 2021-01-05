package br.alura.microrservice.carrier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.alura.microrservice.carrier.dto.DeliveryDTO;
import br.alura.microrservice.carrier.dto.VoucherDTO;
import br.alura.microrservice.carrier.model.Delivery;
import br.alura.microrservice.carrier.repository.EntregaRepository;

@Service
public class EntregaService {
	
	@Autowired
	private EntregaRepository repository;

	public VoucherDTO reservaEntrega(DeliveryDTO pedidoDTO) {
		
		Delivery entrega = new Delivery();
		entrega.setQuestForDate(pedidoDTO.getQuestForDate());
		entrega.setDeliveryForecast(pedidoDTO.getQuestForDate().plusDays(1l));
		entrega.setTargetAddress(pedidoDTO.getTargetAddress());
		entrega.setSourceAddress(pedidoDTO.getSourceAddress());
		entrega.setOrderId(pedidoDTO.getOrderId());
		
		repository.save(entrega);
		
		VoucherDTO voucher = new VoucherDTO();
		voucher.setNumber(entrega.getId());
		voucher.setDeliveryForecast(entrega.getDeliveryForecast());
		return voucher;
	}

}
