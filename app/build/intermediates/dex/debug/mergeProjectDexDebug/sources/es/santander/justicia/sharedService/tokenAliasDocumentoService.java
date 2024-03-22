package es.santander.justicia.sharedService;

public class tokenAliasDocumentoService {
    private static tokenAliasDocumentoService instance;
    private String token;

    private tokenAliasDocumentoService() {
    }

    public void setTokenSSOP(String token2) {
        this.token = token2;
    }

    public String getTokenAliasDocu() {
        return this.token;
    }

    public static synchronized tokenAliasDocumentoService getInstance() {
        tokenAliasDocumentoService tokenaliasdocumentoservice;
        synchronized (tokenAliasDocumentoService.class) {
            if (instance == null) {
                instance = new tokenAliasDocumentoService();
            }
            tokenaliasdocumentoservice = instance;
        }
        return tokenaliasdocumentoservice;
    }
}
