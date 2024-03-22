package es.santander.branchlocator;

public interface BLOnLogUser {
    void onLogin(BLUserType bLUserType);

    void onLogout();
}
