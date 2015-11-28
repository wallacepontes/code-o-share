package org.codeoshare.dado.sessionbeans;

import java.util.Map;
import java.util.concurrent.Future;

public interface LancadorDeDado {
	public int lanca();
	Future<Map<Integer, Integer>> calculaFrequencia();

}
