package net.mdrjr.m1db.test;

import java.util.ArrayList;
import java.util.List;

import net.mdrjr.m1db.config.M1DBConfig;
import net.mdrjr.m1db.object.M1ObjectControl;

public class TestClass {
	
	public static void main(String[] args) {
		
		List<String> tables = new ArrayList<String>();
		tables.add("clientes");
		tables.add("carros");
		M1DBConfig dbConfig = new M1DBConfig("/home/mdrjr/Develop/m1-db/storage", tables, "dblog.txt");
		
		M1ObjectControl m1objc = new M1ObjectControl();
		
		Carro gol = (Carro) m1objc.restore(dbConfig, "carros", 1);
		
		System.out.println(gol.calculaAnoCarro());
		System.out.println(gol.contaAcessorios());
		
		
		/*gol.setAno(2009);
		gol.setCor("Preto");
		gol.setFabricante("Volkswagen");
		gol.setModelo("Gol G5");
		gol.setMotor("1.6");
		
		gol.adicionaAcessorio("Vidro Eletrico");
		gol.adicionaAcessorio("Trava Eletrica");
		gol.adicionaAcessorio("Rodas de Liga Leve");*/
		
		// bjc.save(dbConfig, "carros", gol, 1);
		
		
		/*SimplePojo sp = new SimplePojo();
		sp.setAge(26);
		sp.setName("Mauro Ribeiro");
		sp.setId(1);
		
		m1objc.save(dbConfig, "clientes", sp, sp.getId());		*/

	}
}
