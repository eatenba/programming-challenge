package de.bcxp.challenge.controller.handler;

import java.util.List;

public interface IHandler<T> {
    List<T> getEntries();
}
