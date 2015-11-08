package org.codeoshare.designpatterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class TemaFlyweightFactory {
    private static Map<Class<? extends TemaFlyweight>, TemaFlyweight> temas = new HashMap<>();
    public static final Class<TemaAsterisco> ASTERISCO = TemaAsterisco.class;
    public static final Class<TemaHifen> HIFEN = TemaHifen.class;
    public static final Class<TemaCodeOshare> Code_O_Share = TemaCodeOshare.class;
    
    public static TemaFlyweight getTema(Class<? extends TemaFlyweight> clazz) {
    	if (!temas.containsKey(clazz)) {
    		try {
				temas.put(clazz, clazz.newInstance());
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
    	}
    	return temas.get(clazz);
    }
}
