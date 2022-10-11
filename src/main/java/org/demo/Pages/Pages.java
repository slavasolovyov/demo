package org.demo.Pages;

import lombok.Getter;
import org.demo.Pages.user.PrematchPage;

import static com.codeborne.selenide.Selenide.open;

public class Pages {

    public static <T> T openPage(Entrypoint<T> entrypoint) {
        return open(entrypoint.getPath(), entrypoint.getClazz());
    }

    @Getter
    public static class Entrypoint<T> {
        private final String path;
        private final Class<T> clazz;

        // admin portal
        public static Entrypoint<PrematchPage> SPORTS_PREMATCH = new Entrypoint<>("/sports/prematch/popular", PrematchPage.class);
        public static Entrypoint<GoogleAuthPage> AUTH_PAGE = new Entrypoint<>("", GoogleAuthPage.class);

        private Entrypoint(String path, Class<T> clazz) {
            this.path = path;
            this.clazz = clazz;
        }
    }
}
