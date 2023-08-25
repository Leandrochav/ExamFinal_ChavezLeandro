package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

	 
	private final ProductoRepository repositoryP;
	private final VentaRepository repositoryV;
	private final VentadetalleRepository repositoryVD;

	@Autowired
	public DatabaseLoader(
		
		ProductoRepository repositoryP,
		VentaRepository repositoryV,
		VentadetalleRepository repositoryVD) {
		
		this.repositoryP = repositoryP;
		this.repositoryV = repositoryV;
		this.repositoryVD = repositoryVD;
	}

	@Override
	public void run(String... strings) throws Exception {
		
		Producto huevo = new Producto("zanahoria");
		Producto pan = new Producto("Arroz");
		Producto arroz = new Producto("Aceite");
		Producto leche = new Producto("Lechuga");
		

		
		this.repositoryP.save(huevo);
		this.repositoryP.save(pan);
		this.repositoryP.save(arroz);
		this.repositoryP.save(leche);
		

		Venta david = new Venta("Ventas");
		this.repositoryV.save(david);

		
		this.repositoryVD.save(new Ventadetalle(david, arroz));
		this.repositoryVD.save(new Ventadetalle(david, leche));
		
	}
}