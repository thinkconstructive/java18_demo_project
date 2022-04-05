package com.thinkconstructive;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.file.FileSystems;
import com.sun.net.httpserver.SimpleFileServer;

import static com.sun.net.httpserver.SimpleFileServer.OutputLevel;

public class SWS_JRT {
    private static final InetSocketAddress LOOPBACK_ADDR =
            new InetSocketAddress(InetAddress.getLoopbackAddress(), 8888);

    public static void main( String[] args ) {
        var fileSystem = FileSystems.getFileSystem(URI.create("jrt:/"));
        var absolutePath = fileSystem.getPath("modules").toAbsolutePath();
        var httpServer = SimpleFileServer.createFileServer(LOOPBACK_ADDR, absolutePath, OutputLevel.INFO);
        httpServer.start();
    }
}