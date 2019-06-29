package ru.wkn.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ImmutablePair<Q, G> {

    private Q qObject;
    private G gObject;
}
