package de.bcxp.challenge.controller.services;

import java.util.List;

public interface IService<T> {
    List<T> getEntries();
}
