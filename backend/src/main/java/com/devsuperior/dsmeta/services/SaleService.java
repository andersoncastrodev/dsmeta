package com.devsuperior.dsmeta.services;


import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repositorySale;
	
	public Page<Sale> findSales(String minDate, String maxDate,Pageable pageable) {	
		//List<Sale> listaVenda =  repositorySale.findAll();
		
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		// .minusDays( - numero de dias que vc quer.)
		LocalDate min = minDate.equals("")? today.minusDays(365) : LocalDate.parse(minDate);
		
		//If ternario teste se a data esta vazio.
		LocalDate max = maxDate.equals("")? today : LocalDate.parse(maxDate);
		
		return repositorySale.findSales(min, max, pageable);
	}
}
