package com.stc.ems.converter;

@FunctionalInterface
public interface Converter <T, R>{
    R convert(T t);
}
