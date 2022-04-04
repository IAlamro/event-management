package com.stc.ems.services;

public interface ServiceFactory {
    
    Query<?, ?> getQuery(String name);

    EmptyQuery<?> getEmptyQuery(String name);

    Command<?> getCommand(String name);
}
