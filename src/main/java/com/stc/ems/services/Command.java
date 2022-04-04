package com.stc.ems.services;

public interface Command <T>{

    void execute(T t);
}
