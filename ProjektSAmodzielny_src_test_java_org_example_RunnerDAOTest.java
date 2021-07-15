package org.example;

import static org.junit.jupiter.api.Assertions.*;

class RunnerDAOTest {

    @org.junit.jupiter.api.Test
    void getAll() {
        RunnerDAO runnerDAO = new RunnerDAO();
    runnerDAO.getAll();
    }
}