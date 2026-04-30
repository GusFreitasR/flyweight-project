package flyweight.galaxia;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Galaxia extends JFrame {
    private List<Estrela> estrelas = new ArrayList<>();

    public void adicionarEstrela(int x, int y, int tamanho, String classificacao, Color cor) {
        TipoEstrela tipo = FabricaEstrelas.obterTipoEstrela(classificacao, cor);
        Estrela estrela = new Estrela(x, y, tamanho, tipo);
        estrelas.add(estrela);
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, getWidth(), getHeight());

        for (Estrela estrela : estrelas) {
            estrela.desenhar(graphics);
        }
    }

    // --- EXECUÇÃO E DEMONSTRAÇÃO ---

    static int CANVAS_SIZE = 800;
    static int ESTRELAS_PARA_RENDERIZAR = 50000;
    static int TIPOS_DE_ESTRELAS = 3;

    public static void main(String[] args) {
        Galaxia galaxia = new Galaxia();
        for (int i = 0; i < Math.floor(ESTRELAS_PARA_RENDERIZAR / TIPOS_DE_ESTRELAS); i++) {
            galaxia.adicionarEstrela(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
                    random(1, 3), "Anã Vermelha", Color.RED);

            galaxia.adicionarEstrela(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
                    random(2, 4), "Sequência Principal", Color.YELLOW);

            galaxia.adicionarEstrela(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
                    random(3, 5), "Gigante Azul", Color.CYAN);
        }
        galaxia.setTitle("Simulador de Galáxia - Padrão Flyweight");
        galaxia.setSize(CANVAS_SIZE, CANVAS_SIZE);
        galaxia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        galaxia.setVisible(true);

        System.out.println(ESTRELAS_PARA_RENDERIZAR + " estrelas renderizadas");
        System.out.println("---------------------");
        System.out.println("Uso de memória estimado:");
        System.out.println("Tamanho da Estrela (~24 bytes) * " + ESTRELAS_PARA_RENDERIZAR);
        System.out.println("+ Tamanho do TipoEstrela (~10280 bytes) * " + TIPOS_DE_ESTRELAS);
        System.out.println("---------------------");

        long memoriaComFlyweight = ((long) ESTRELAS_PARA_RENDERIZAR * 24 + (long) TIPOS_DE_ESTRELAS * 10280) / 1024 / 1024;
        long memoriaSemFlyweight = ((long) ESTRELAS_PARA_RENDERIZAR * (24 + 10280)) / 1024 / 1024;

        System.out.println("Total: " + memoriaComFlyweight +
                "MB (ao invés de " + memoriaSemFlyweight + "MB)");
    }

    private static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}