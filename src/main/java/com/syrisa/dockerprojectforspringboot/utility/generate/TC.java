package com.syrisa.dockerprojectforspringboot.utility.generate;

import java.util.Random;
import java.util.function.Supplier;

public final class TC {
    private TC() {

    }

    public static Supplier<Long> generateTC = () -> {
        StringBuilder builder = new StringBuilder();
        builder.append(1 + new Random().nextInt(9));
        for (int i = 0; i < 10; i++) {
            builder.append(new Random().nextInt(10));
        }
        return Long.parseLong(builder.toString());
    };
}
