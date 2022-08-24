package registretion;

public class Register {
    public Register(String bundle, String appVersion, String email, String pass, String appKey) {
    }

    public class App {
        private String bundle_id;
        private String version;

        private String getBundle_id() {
            return bundle_id;
        }

        private String getVersion() {
            return version;
        }
    }

    public class Params {
        public App app;
        private String email;
        private String password;
        private String application_key;

        public App getApp() {
            return app;
        }

        private String getEmail() {
            return email;
        }

        private String getPassword() {
            return password;
        }

        private String getApplication_key() {
            return application_key;
        }
    }
}
