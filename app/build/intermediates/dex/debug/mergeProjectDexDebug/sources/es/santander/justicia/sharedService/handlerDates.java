package es.santander.justicia.sharedService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class handlerDates {
    private Date fecha;

    public String getDate() {
        this.fecha = new Date();
        return new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(this.fecha.getTime()));
    }
}
