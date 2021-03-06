/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algoboss.erp.face;

import com.algoboss.erp.entity.GerCliente;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Agnaldo
 */
@Named
@SessionScoped
public class GerClienteBean extends GenericBean<GerCliente> {

    /**
     * Creates a new instance of ClienteBean
     */
    public GerClienteBean() {
        super.url = "views/cadastro/ger/cliente/clienteList.xhtml";
        super.urlForm = "clienteForm.xhtml";
        super.namedFindAll = "findAllGerCliente";
        super.type = GerCliente.class;
        super.subtitle = "Cadastro | Cliente";
    }
}
