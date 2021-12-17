package com.senai;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.senai.domain.Cliente;
import com.senai.domain.repositories.ClienteRepository;

@SpringBootTest
public class ClienteTest {

	@Autowired
	ClienteRepository clienteRepo;

	@Test
	void Cliente() {
		com.senai.domain.Cliente cli = new Cliente();
		cli.setIdCliente(null);
		cli.setNome("Bunitão da Malacaxita");
		cli.setCpfOuCnpj("342734732");
		cli.setEmail("bunitao@bunitao.com.br");
		clienteRepo.save(cli);
	}

	@Test
	public void listaCliente() {
		List<Cliente> list = clienteRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	public void idCLiente() {
		Cliente cliente = clienteRepo.findById(1).get();
		assertEquals("Isabelle", cliente.getNome());
	}

	@Test
	public void updateCliente() {
		Cliente cliente = clienteRepo.findById(1).get();
		cliente.setNome("Isabelle Segatto");
		clienteRepo.save(cliente);
		assertNotEquals("Isabelle", cliente.getNome());
	}

	@Test
	public void deleteCLiente() {
		clienteRepo.deleteById(2);
		assertThat(clienteRepo.existsById(2));
	}


	@Test
	public void somar() {
		double num1 = 9.0;
		double num2 = 20.0;
		Cliente cliente = new Cliente();
		double soma = cliente.somar(num1, num2);
		assertEquals(29, soma);
	}


	@Test
	public void subtrair() {
		double num1 = 18.0;
		double num2 = 7.0;
		Cliente cliente = new Cliente();
		double subtração = cliente.subtrair(num1, num2);
		assertEquals(11, subtração);
	}


	@Test
	public void multiplicar() {
		double num1 = 4.0;
		double num2 = 8.0;
		Cliente cliente = new Cliente();
		double multiplicação = cliente.multiplicar(num1, num2);
		assertEquals(32, multiplicação);
	}


	@Test
	public void dividir() {
		double num1 = 20.0;
		double num2 = 2.0;
		Cliente cliente = new Cliente();
		double divisão = cliente.dividir(num1, num2);
		assertEquals(10, divisão);
	}

}
