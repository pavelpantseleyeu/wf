package by.epam.wf.testtask.domain;

import java.util.concurrent.atomic.AtomicLong;

public class DomainObject {

    private static AtomicLong nextId = new AtomicLong(0);

    private Long id;

    public void getNextId() { this.id = nextId.incrementAndGet(); }
}
