package br.com.dbc.vemcer.pessoaapi;

import br.com.dbc.vemcer.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemcer.pessoaapi.repository.PessoaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication

public class PessoaapiApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PessoaapiApplication.class, args);

		PessoaRepository pessoaRepository = context.getBean(PessoaRepository.class);
		ContatoRepository contatoRepository = new ContatoRepository(pessoaRepository);
	}
}
//
//
//	public static void main(String[] args) {
//		SpringApplication.run(PessoApiApplication.class, args);
//	}
//
//}
