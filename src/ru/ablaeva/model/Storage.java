package ru.ablaeva.model;

public final class Storage<T> {
    private final T object;

    public Storage(T object) {
        this.object = object;
    }

    public T get(T defaultValue) {
        return (this.object != null) ? this.object : defaultValue;
    }

    @Override
    public String toString() {
        return (this.object != null) ? this.object.toString() : "n/a";
    }
}