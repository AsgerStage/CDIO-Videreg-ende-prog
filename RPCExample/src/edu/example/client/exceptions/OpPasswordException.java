package edu.example.client.exceptions;

import java.io.Serializable;

public class OpPasswordException extends Exception  implements Serializable
{
    private static final long serialVersionUID = 4L;
    private final String password;

    public OpPasswordException(String password) {
        super("Koden overholder ikke reglerne for kodeord");
        this.password = password;
    }
}