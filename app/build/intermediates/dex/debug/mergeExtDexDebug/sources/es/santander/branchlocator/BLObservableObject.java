package es.santander.branchlocator;

import java.util.Observable;

class BLObservableObject extends Observable {
    private static BLObservableObject instance = new BLObservableObject();

    private BLObservableObject() {
    }

    public static BLObservableObject getInstance() {
        return instance;
    }

    public void updateValue(Object data) {
        synchronized (this) {
            setChanged();
            notifyObservers(data);
        }
    }
}
