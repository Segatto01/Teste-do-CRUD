package com.senai;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.senai.domain.Cidade;
import com.senai.domain.Cliente;
import com.senai.domain.Endereco;
import com.senai.domain.Estado;
import com.senai.domain.enuns.TipoCliente;
import com.senai.domain.repositories.CidadeRepository;
import com.senai.domain.repositories.ClienteRepository;
import com.senai.domain.repositories.EnderecoRepository;
import com.senai.domain.repositories.EstadoRepository;

@SpringBootApplication
public class IsabelleApplication implements CommandLineRunner {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;


    public static void main(String[] args) {
        SpringApplication.run(IsabelleApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");
        estadoRepository.saveAll(Arrays.asList(est1,est2));

        Cidade c1 = new Cidade(null, "Uberlândia", est1);
        Cidade c2 = new Cidade(null, "Osasco", est2);
        cidadeRepository.saveAll(Arrays.asList(c1,c2));

        Cliente cli1 = new  Cliente(null, "Isabelle", "12245678908", "isabellesegatto10@gmail.com", 
                TipoCliente.PESSOAFISICA);
        Cliente cli2 = new  Cliente(null, "Maria", "987654321", "mariaeduarda@gmail.com",
        		TipoCliente.PESSOAFISICA);
        cli1.getTelefones().addAll(Arrays.asList("24000002345", "12124354987"));
        cli1.getTelefones().addAll(Arrays.asList("44444567789", "00000987656"));
        cli1.getTelefones().addAll(Arrays.asList("99999999999", "123456789087"));
        clienteRepository.saveAll(Arrays.asList(cli1,cli2));

        Endereco e1 = new Endereco(null, "Rua Gonçalves Dias", "435","", "Tabajaras", "38400288",cli1,c1);
        Endereco e2 = new Endereco(null, "Rua Adriano Bailone", "445","", "Roosevelt", "38401092",cli2,c2);
        cli1.getEnderecos().addAll(Arrays.asList(e1));
        cli2.getEnderecos().addAll(Arrays.asList(e2));
        enderecoRepository.saveAll(Arrays.asList(e1,e2));

    }

}