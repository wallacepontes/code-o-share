package org.codeoshare.designpatterns.behavioral.visitor;

public interface AtualizadorDeFuncionario {
    void atualiza(Gerente g);
    void atualiza(Telefonista t);
}
