import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // String url =
        // "https://api.nasa.gov/planetary/apod?api_key=jPARZgxn9D6y8F2Cd2SQ4DEwm35UQRnqV8grHAI8&start_date=2022-07-19&end_date=2022-07-22";
        // ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

        String url = "https://api.mocki.io/v2/549a5d8b";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        for (int i = 0; i<3; i++) {

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();

            String nomeArquivo = conteudo.getTitulo() + ".png";

            var geradora = new GeradorDeFigurinhas();
            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());

            System.out.println();
        }
    }
}
