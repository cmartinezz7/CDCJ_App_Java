package org.simpleframework.xml.stream;

import java.io.InputStream;
import java.io.Reader;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.InputSource;

class DocumentProvider implements Provider {
    private final DocumentBuilderFactory factory;

    public DocumentProvider() {
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        this.factory = newInstance;
        newInstance.setNamespaceAware(true);
    }

    public EventReader provide(InputStream source) throws Exception {
        return provide(new InputSource(source));
    }

    public EventReader provide(Reader source) throws Exception {
        return provide(new InputSource(source));
    }

    private EventReader provide(InputSource source) throws Exception {
        return new DocumentReader(this.factory.newDocumentBuilder().parse(source));
    }
}
