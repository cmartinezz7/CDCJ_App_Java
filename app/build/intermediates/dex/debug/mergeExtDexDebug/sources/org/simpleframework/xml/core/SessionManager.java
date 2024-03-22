package org.simpleframework.xml.core;

class SessionManager {
    private ThreadLocal<Reference> local = new ThreadLocal<>();

    public Session open() throws Exception {
        return open(true);
    }

    public Session open(boolean strict) throws Exception {
        Reference session = this.local.get();
        if (session != null) {
            return session.get();
        }
        return create(strict);
    }

    private Session create(boolean strict) throws Exception {
        Reference session = new Reference(strict);
        this.local.set(session);
        return session.get();
    }

    public void close() throws Exception {
        Reference session = this.local.get();
        if (session == null) {
            throw new PersistenceException("Session does not exist", new Object[0]);
        } else if (session.clear() == 0) {
            this.local.remove();
        }
    }

    private static class Reference {
        private int count;
        private Session session;

        public Reference(boolean strict) {
            this.session = new Session(strict);
        }

        public Session get() {
            int i = this.count;
            if (i >= 0) {
                this.count = i + 1;
            }
            return this.session;
        }

        public int clear() {
            int i = this.count - 1;
            this.count = i;
            return i;
        }
    }
}
