package net.mdrjr.m1db.test;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Carro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private String fabricante;
	private String modelo;
	private Integer ano;
	private String cor;
	private String motor;
	private List<String> acessorios = new ArrayList<String>();
	
	public void adicionaAcessorio(String aaa) {
		List<String> aa = getAcessorios();
		aa.add(aaa);
	}
	
	public String calculaAnoCarro() {
		String ret = "";
		Integer calc_ano = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Date y = new Date();
		calc_ano = Integer.parseInt(sdf.format(y)) - getAno();
		ret = "Seu carro tem " + calc_ano.toString() + " anos de uso.";
		return ret;
	}
	
	public String contaAcessorios() {
		String ret = "";
		
		List<String> acessorios = getAcessorios();
		
		Integer counter = acessorios.size();
		
		ret = "Seu carro possui " + counter.toString() + " acessorios.";
		return ret;
	}
	
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getMotor() {
		return motor;
	}
	public void setMotor(String motor) {
		this.motor = motor;
	}
	public List<String> getAcessorios() {
		return acessorios;
	}
	public void setAcessorios(List<String> acessorios) {
		this.acessorios = acessorios;
	}
	
	
	

}
