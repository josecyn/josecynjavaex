package com.cloudcontrolled.sample.jetty;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;


public class App
{
    public static void main(String[] args) throws Exception
    {
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ContextHandler context = new ContextHandler("/");
        context.setHandler(new ResourceHandler());
        context.setResourceBase("target/classes/template/hello.html");

        ContextHandler resources = new ContextHandler("/static");
        resources.setHandler(new ResourceHandler());
        resources.setResourceBase("target/classes/static");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] {resources, context});
        server.setHandler(handlers);

        server.start();
        server.join();
    }
}