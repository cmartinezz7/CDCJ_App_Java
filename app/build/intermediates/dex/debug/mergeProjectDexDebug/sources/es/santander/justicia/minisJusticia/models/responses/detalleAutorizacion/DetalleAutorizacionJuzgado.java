package es.santander.justicia.minisJusticia.models.responses.detalleAutorizacion;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class DetalleAutorizacionJuzgado {
    @Element(name = "codOrganismo", required = false)
    private String codOrganismo;
    @Element(name = "direccion", required = false)
    private String direccion;
    @Element(name = "nombre", required = false)
    private String nombre;

    public String getCodOrganismo() {
        return this.codOrganismo;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public String getNombre() {
        return this.nombre;
    }
}
