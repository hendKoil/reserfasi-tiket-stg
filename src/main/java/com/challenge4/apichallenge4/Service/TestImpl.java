package com.challenge4.apichallenge4.Service;

import com.challenge4.apichallenge4.Repository.TestRepo;
import org.springframework.stereotype.Service;

@Service
public class TestImpl implements TestRepo {
    @Override
    public String test() {
        return null;
    }
}
