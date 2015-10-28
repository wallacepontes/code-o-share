package org.codeoshare.designpatterns.creational.abstractfactory;

import org.codeoshare.designpatterns.creational.factorymethod.Emissor;

public interface ComunicadorFactory {
    Emissor createEmissor();
    Receptor createReceptor();
}
