package steps.data.users;

import requests.AuthInfo;
import storage.USER;

public class UserInfoProvider {

    public AuthInfo getUser(USER email) {
        return switch (email) {
            case EMAIL_INFO -> new AuthInfo(
                    new AuthInfo.Params(
                            new AuthInfo.Params.App()
                                    .withBundleId(USER.BUNDLE_ID.getUserData())
                                    .withVersion(USER.APP_VERSION.getUserData())
                            , USER.EMAIL_INFO.getUserData()
                            , USER.PASSWORD.getUserData(),
                            new AuthInfo.Params.Device()
                                    .withVersion(USER.DEVICE_VERSION.getUserData())
                                    .withOs(USER.OS.getUserData())
                                    .withPushToken(USER.PUSH_TOKEN.getUserData()),
                            USER.APPLICATION_KEY.getUserData()));
            default -> null;
        };
    }
}
