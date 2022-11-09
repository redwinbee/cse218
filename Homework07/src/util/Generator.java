package util;

import app.App;

import java.util.UUID;

public class Generator {
    private Generator() {
    }

    public static UUID createUniqueAccountId() {
        UUID randUuid = UUID.randomUUID();
        while (App.getStorageManager().exists(randUuid)) {
            randUuid = UUID.randomUUID();
        }

        return randUuid;
    }
}
