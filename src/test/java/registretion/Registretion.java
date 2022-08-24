package registretion;

public class Registretion {
    public class App{
        public String bundle_id;
        public String version;

        public String getBundle_id() {
            return bundle_id;
        }

        public String getVersion() {
            return version;
        }
    }

    public class Device{
        public String version;
        public String os;
        public String push_token;

        public String getVersion() {
            return version;
        }

        public String getOs() {
            return os;
        }

        public String getPush_token() {
            return push_token;
        }
    }

    public class Params{
        public App app;
        public String email;
        public String password;
        public Device device;
        public String application_key;

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public Device getDevice() {
            return device;
        }

        public String getApplication_key() {
            return application_key;
        }

        public App getApp() {
            return app;
        }
    }

    public Registretion() {

    }
}
