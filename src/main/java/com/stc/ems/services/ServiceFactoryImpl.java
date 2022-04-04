package com.stc.ems.services;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import lombok.Data;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Component
public class ServiceFactoryImpl implements ServiceFactory {

    private final Map<String, Query<?, ?>> queries = new HashMap<>();
    private final Map<String, EmptyQuery<?>> emptyQueries = new HashMap<>();
    private final Map<String, Command<?>> commands = new HashMap<>();

    public ServiceFactoryImpl(ApplicationContext applicationContext) {
        try (JsonReader queriesReader = new JsonReader(new FileReader(""));
             JsonReader emptyQueriesReader = new JsonReader(new FileReader(""));
             JsonReader commandsReader = new JsonReader(new FileReader(""))) {

            Gson gson = new Gson();
            List<ServiceBean> queryBeans = gson.fromJson(queriesReader, List.class);
            queryBeans.forEach(b -> queries.put(b.getName().toUpperCase(), applicationContext.getBean(getaClass(b))));

            List<ServiceBean> emptyQueryBeans = gson.fromJson(emptyQueriesReader, List.class);
            List<ServiceBean> commandBeans = gson.fromJson(commandsReader, List.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Class<? extends Query> getaClass(ServiceBean b) {
        try {
            return (Class<? extends Query>) ClassLoader.getSystemClassLoader().loadClass(b.getClassPath());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Query<?, ?> getQuery(String name) {
        Query<?, ?> query = queries.get(name);
        if (query != null)
            return query;
        else
            throw new RuntimeException();
    }

    @Override
    public EmptyQuery<?> getEmptyQuery(String name) {
        return null;
    }

    @Override
    public Command<?> getCommand(String name) {
        return null;
    }

    @Data
    private static class ServiceBean {
        private String name;
        private String classPath;
    }
}
