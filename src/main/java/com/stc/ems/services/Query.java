package com.stc.ems.services;

public interface Query <T, R>{

    R execute(T t);
}
