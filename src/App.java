import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "https://api.mocki.io/v2/549a5d8b"; 
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request= HttpRequest.newBuilder(endereco).GET().build();  
        HttpResponse<String> response= client.send(request, BodyHandlers.ofString());
        String body = response.body();
        var parser = new JsonParser();
        List<Map<String, String>> ListaDeFilmes = parser.parse(body);
        System.out.println(ListaDeFilmes.size());
        System.out.println(ListaDeFilmes.get(0));

        for (Map<String,String> filme : ListaDeFilmes) {

            String titulo = filme.get("title");
            InputStream inputStream = new URL(filme.get("image")).openStream();
            
            String nomeArquivo = titulo + ".png";

            var geradora = new GeradorDeFigurinhas();
            geradora.cria(inputStream, nomeArquivo);


            System.out.println(filme.get("title"));
            // System.out.println(filme.get("image"));
            // System.out.println(filme.get("imDbRating"));
            System.out.println();
        }
    }
}
