package flyweight.galaxia;

import java.awt.*;

public class Estrela {
    private int x;
    private int y;
    private int tamanho;
    private TipoEstrela tipo;

    public Estrela(int x, int y, int tamanho, TipoEstrela tipo) {
        this.x = x;
        this.y = y;
        this.tamanho = tamanho;
        this.tipo = tipo;
    }

    public void desenhar(Graphics g) {
        tipo.renderizar(g, x, y, tamanho);
    }
}