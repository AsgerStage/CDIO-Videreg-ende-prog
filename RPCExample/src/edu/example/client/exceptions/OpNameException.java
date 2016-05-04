package edu.example.client.exceptions;

import java.io.Serializable;

public class OpNameException extends Exception  implements Serializable
{
    private static final long serialVersionUID = 3L;
    private final String name;

    public OpNameException(String name) {
        super("Navnet overholder ikke reglerne for et navn.");
        this.name = name;
    }
}