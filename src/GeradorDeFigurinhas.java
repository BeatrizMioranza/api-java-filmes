import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class GeradorDeFigurinhas {

  public void cria(InputStream inputStream, String nomeArquivo) throws Exception {
    // InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg"));
    // InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_10.jpg").openStream();
    BufferedImage imagemOriginal = ImageIO.read(inputStream);

    int largura = imagemOriginal.getWidth();
    int altura = imagemOriginal.getHeight();
    int novaAltura = altura + 200;
    BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

    Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
    graphics.drawImage(imagemOriginal, 0, 0, null);

    var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
    graphics.setFont(fonte);
    graphics.setColor(Color.YELLOW);
    graphics.drawString("Javeiro", 0, novaAltura - 100);

    ImageIO.write(novaImagem, "png", new File("saida/" + nomeArquivo));
  }
}
