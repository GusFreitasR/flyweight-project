package flyweight.galaxia;

import java.awt.*;

public class TipoEstrela {
    private String classificacao;
    private Color corBase;
    private byte[] mapaEspectro;

    public TipoEstrela(String classificacao, Color corBase, byte[] mapaEspectro) {
        this.classificacao = classificacao;
        this.corBase = corBase;
        this.mapaEspectro = mapaEspectro;
    }

    public void renderizar(Graphics g, int x, int y, int tamanho) {
        g.setColor(corBase);
        g.fillOval(x, y, tamanho, tamanho);
    }
}