package com.englishtown.vertx.jersey.integration;

import com.englishtown.vertx.jersey.inject.VertxRequestProcessor;
import org.glassfish.jersey.server.ContainerRequest;
import org.vertx.java.core.Handler;
import org.vertx.java.core.Vertx;
import org.vertx.java.core.http.HttpServerRequest;

import javax.inject.Inject;

/**
 *
 */
public class ReqProcessor2 implements VertxRequestProcessor {

    private final Vertx vertx;

    @Inject
    public ReqProcessor2(Vertx vertx) {
        this.vertx = vertx;
    }

    /**
     * Provide additional async request processing
     *
     * @param vertxRequest  the vert.x http server request
     * @param jerseyRequest the jersey container request
     * @param done          the done async callback handler
     */
    @Override
    public void process(HttpServerRequest vertxRequest, ContainerRequest jerseyRequest, final Handler<Void> done) {
        vertx.runOnContext(new Handler<Void>() {
            @Override
            public void handle(Void event) {
                done.handle(event);
            }
        });
    }
}
