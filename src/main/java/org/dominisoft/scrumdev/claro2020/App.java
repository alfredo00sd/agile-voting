package org.dominisoft.scrumdev.claro2020;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.loader.ClasspathLoader;
import io.javalin.Javalin;
import io.javalin.plugin.rendering.JavalinRenderer;
import io.javalin.plugin.rendering.template.JavalinPebble;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world.
 */
public final class App {
    /**
     * Default port.
     */
    public static final int DEFAULT_PORT = 7000;

    private static Javalin app;

    /**
     * Prevent instantiation.
     */
    private App() {
    }

    /**
     * Entry point.
     *
     * @param args Console arguments
     */
    public static void main(final String[] args) {
        configureWebApp();

        mapRoutes();
    }

    private static void configureWebApp() {
        app = Javalin.create(config -> {
            config.addStaticFiles("/html");
        }).start(DEFAULT_PORT);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            app.stop();
        }));

        app.events(event -> {
            event.serverStopping(() -> {
                System.out.println("The server is stopping.");
            });
            event.serverStopped(() -> {
                System.out.println("Server is gone!");
            });
        });

        app.after(ctx -> {
            // run after all requests
            final String whatHappened = ctx.req.getMethod() + " " + ctx.req.getRequestURI() + " -> " + ctx.res.getStatus();
            System.out.println("whatHappened: " + whatHappened);
        });

        JavalinRenderer.register(JavalinPebble.INSTANCE, ".peb", ".pebble");
        PebbleEngine engine = new PebbleEngine.Builder().loader(new ClasspathLoader()).cacheActive(true).build();
        JavalinPebble.configure(engine);
    }

    private static void mapRoutes() {
        app.get("", ctx -> {
            ctx.redirect("/index.html");
        });

        app.get("/index.html", ctx -> {
            ctx.render("index.pebble");
        });

        app.post("/init-voting", ctx -> {
            // ctx.contentType("text/html; charset=UTF-8");
            // final String rawCedula = ctx.req.getParameter("id");

            // DopNationalIdentificationNumber cedula2 = new
            // DopNationalIdentificationNumber(rawCedula);

            // ctx.result(
            // String.format("TODO: Validate ID '%s' (Cédula)!!!", rawCedula));
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("HasErrors", true);
            model.put("InvalidIdMessage", "You have an invalid Cedula!");
            ctx.render("index.pebble", model);
        });
    }

    /**
     * Stops the server.
     */
    public static void stop() {
        app.stop();
    }
}
