import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoIMDB implements ExtratorDeConteudo{
    public List<Conteudo> extraiConteudos(String json){

        var parser = new JsonParser();
        List<Map<String, String>> ListaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();
         
        for (Map<String, String> atributos : ListaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("image");
            var conteudo = new Conteudo(titulo, urlImagem);

           conteudos.add(conteudo);
        }

        return conteudos;

    }

}
