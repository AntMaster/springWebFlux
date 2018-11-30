package com.example.demo.stream;

import java.util.List;

public interface PlainResult<T> {


    boolean isAvailable();

    T getData();
}
