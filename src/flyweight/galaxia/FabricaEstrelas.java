package flyweight.galaxia;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class FabricaEstrelas {
    static Map<String, TipoEstrela> cacheEstrelas = new HashMap<>();

    public static TipoEstrela obterTipoEstrela(String classificacao, Color corBase) {
        TipoEstrela result = cacheEstrelas.get(classificacao);
        if (result == null) {
            result = new TipoEstrela(classificacao, corBase, new byte[10240]);
            cacheEstrelas.put(classificacao, result);
        }
        return result;
    }
}
