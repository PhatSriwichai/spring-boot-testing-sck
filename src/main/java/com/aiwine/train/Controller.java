package com.aiwine.train;

interface Repository {
    public String getData(int id);
}

public class Controller {
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    Repository repository;

    public String getById(int id) {
        return repository.getData(id);
    }
}

//class Repository {
//
//    public String getData(int id) {
//        throw new RuntimeException("don't call.");
//    }
//}
