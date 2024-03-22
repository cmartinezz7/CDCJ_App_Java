package es.santander.justicia.minisJusticia.models.requests.contratos;

import org.simpleframework.xml.Element;

public class ContratosConexionBody {
    @Element(name = "v1:listarContratosConexion_LA", required = false)
    private ContratosEntrada contratosEntrada;

    public ContratosConexionBody(ContratosEntrada contratosEntrada2) {
        this.contratosEntrada = contratosEntrada2;
    }
}
