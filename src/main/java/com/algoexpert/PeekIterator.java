package com.algoexpert;

import java.util.Iterator;

public class PeekIterator implements Iterator<Integer>
{
    private Integer next = null;
    private Iterator<Integer> it;

    public PeekIterator(Iterator<Integer> iterator)
    {
        this.it = iterator;
        if(it.hasNext())
            this.next = it.next();
    }

    public Integer peek()
    {
        return next;
    }
    @Override
    public boolean hasNext()
    {
        return next!=null;
    }

    @Override
    public Integer next() {
        Integer res = next;
        next = it.hasNext() ? it.next(): null;
        return res;
    }
}
