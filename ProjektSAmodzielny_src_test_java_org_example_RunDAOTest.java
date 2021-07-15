package org.example;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RunDAOTest extends TestCase {

    @Test
    void getAll() {
        RunDAO runDAO = new RunDAO();
        runDAO.getAll();
    }
}