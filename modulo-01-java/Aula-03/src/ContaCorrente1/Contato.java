package ContaCorrente1;

public class Contato {
    public String descricao;
    public int tipo;
    public String telefone;

    public static void main(String[] args) {

        Contato primeiraPessoa = new Contato();
        primeiraPessoa.descricao = "Shaienne";
        primeiraPessoa.tipo = 1;
        primeiraPessoa.telefone = "99727-9376";

        Contato segundaPessoa = new Contato();
        segundaPessoa.descricao = "Daniel";
        segundaPessoa.tipo = 2;
        segundaPessoa.telefone = "99990-3122";

        Contato terceiraPessoa = new Contato();
        terceiraPessoa.descricao = "James";
        terceiraPessoa.tipo = 1;
        terceiraPessoa.telefone = "99876-1223";


    }
}
