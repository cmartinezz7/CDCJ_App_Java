package es.santander.justicia.minisJusticia.models.responses.listaMovimientos;

import java.util.ArrayList;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class ListaMovimientosReturnDetail {
    @ElementListUnion({@ElementList(inline = true, required = false, type = DatosOperacion.class), @ElementList(inline = true, required = false, type = TotalMovimiento.class)})
    private ArrayList<Object> datosOperacions;

    public ArrayList<Object> getDatosOperacions() {
        return this.datosOperacions;
    }
}
