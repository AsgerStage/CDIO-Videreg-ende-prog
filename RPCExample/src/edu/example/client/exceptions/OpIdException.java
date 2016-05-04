package edu.example.client.exceptions;

import java.io.Serializable;

public class OpIdException extends Exception implements Serializable
{
    private static final long serialVersionUID = 5L;
    private final int oprId;

    public OpIdException(int oprId) {
        super("operat�r ID er forkert");
        this.oprId = oprId;
    }
}