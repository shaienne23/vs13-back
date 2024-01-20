package br.com.dbc.vemcer.pessoaapi.repository;

import br.com.dbc.vemcer.pessoaapi.entity.Endereco;
import br.com.dbc.vemcer.pessoaapi.entity.TipoEndereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {
    private static List<Endereco> listaEnderecos;
    private static AtomicInteger COUNTER = new AtomicInteger();

    private final PessoaRepository pessoaRepository;

    public EnderecoRepository(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
        this.listaEnderecos = new ArrayList<>();
        initializeEnderecos();
    }
       private void initializeEnderecos() {
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),pessoaRepository.list().get(0).getIdPessoa(),TipoEndereco.RESIDENCIAL,
                "Rua das Estrelas",03, "prox mercado serve bem",
                "29162673", "Cantinho do céu", "Espirito Santo", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),pessoaRepository.list().get(1).getIdPessoa(),TipoEndereco.COMERCIAL,
                   "Rua das Palmeiras",14, "prox a sorveteria do alemão",
                   "39660000", "Governador Valadares", "Minas Gerais", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),pessoaRepository.list().get(2).getIdPessoa(),TipoEndereco.RESIDENCIAL,
                   "Avenida Olegario Marciel",103, "prox a escola estadual",
                   "35230000", "Resplendor", "Minas Gerais", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),pessoaRepository.list().get(3).getIdPessoa(),TipoEndereco.RESIDENCIAL,
                   "Rua tamoios",97, "prox ao posto de saude",
                   "29175570", "Jacaraipe", "Espirito Santo", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),pessoaRepository.list().get(4).getIdPessoa(),TipoEndereco.RESIDENCIAL,
                   "Rua São Paulo",107, "prox pracinha guarany",
                   "29175573", "Das Laranjeiras", "Espirito Santo", "Brasil"));
           listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), pessoaRepository.list().get(0).getIdPessoa(), TipoEndereco.COMERCIAL,
                   "Avenida Brasil", 205, "prox ao shopping",
                   "12345678", "Centro", "São Paulo", "Brasil"));
           listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), pessoaRepository.list().get(1).getIdPessoa(), TipoEndereco.RESIDENCIAL,
                   "Rua ABC", 123, "Complemento ABC", "12345678", "Cidade ABC", "Estado ABC", "Brasil"));
           listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), pessoaRepository.list().get(0).getIdPessoa(), TipoEndereco.COMERCIAL,
                   "Rua XYZ", 456, "Complemento XYZ", "87654321", "Cidade XYZ", "Estado XYZ", "Brasil"));

       }

    public static Endereco create(Endereco enderecoCriar) {
        enderecoCriar.setIdEndereco(COUNTER.incrementAndGet());
        enderecoCriar.setIdPessoa(enderecoCriar.getIdPessoa());
        enderecoCriar.setTipo(enderecoCriar.getTipo());
        enderecoCriar.setLogradouro(enderecoCriar.getLogradouro());
        enderecoCriar.setNumero(enderecoCriar.getNumero());
        enderecoCriar.setComplemento(enderecoCriar.getComplemento());
        enderecoCriar.setCep(enderecoCriar.getCep());
        enderecoCriar.setCidade(enderecoCriar.getCidade());
        enderecoCriar.setEstado(enderecoCriar.getEstado());
        enderecoCriar.setPais(enderecoCriar.getPais());
        listaEnderecos.add(enderecoCriar);
        return enderecoCriar;
    }

    public List<Endereco> list(){

        return listaEnderecos;
    }
    public List<Endereco> listByIdEndereco(Integer id) {
        return listaEnderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .collect(Collectors.toList());
    }

    public List<Endereco> listByIdPessoa(Integer idPessoa) {
        return listaEnderecos.stream()
                .filter(endereco -> endereco.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());

    }

    public List<Endereco> listByEstado(String estado) {
        return listaEnderecos.stream()
                .filter(endereco -> endereco.getEstado().toUpperCase().contains(estado.toUpperCase()))
                .collect(Collectors.toList());
    }

    public Endereco update(Integer id, Endereco enderecoAtualizar) {
        enderecoAtualizar.setTipo(enderecoAtualizar.getTipo());
        enderecoAtualizar.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoAtualizar.setNumero(enderecoAtualizar.getNumero());
        enderecoAtualizar.setComplemento(enderecoAtualizar.getComplemento());
        enderecoAtualizar.setCep(enderecoAtualizar.getCep());
        enderecoAtualizar.setCidade(enderecoAtualizar.getCidade());
        enderecoAtualizar.setEstado(enderecoAtualizar.getEstado());
        enderecoAtualizar.setPais(enderecoAtualizar.getPais());
        return enderecoAtualizar;
    }

    public void delete(Endereco endereco) {
        listaEnderecos.remove(endereco);
    }
}

