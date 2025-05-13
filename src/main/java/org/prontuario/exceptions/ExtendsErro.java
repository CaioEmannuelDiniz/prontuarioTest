package org.prontuario.exceptions;

import java.time.Instant;

public record ExtendsErro(
        Instant timeStamp,
        Integer statusCode,
        String errorMessage,
        String path
) { }
