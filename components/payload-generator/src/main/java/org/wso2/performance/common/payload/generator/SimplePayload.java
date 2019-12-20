/*
 * Copyright 2018 WSO2 Inc. (http://wso2.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.performance.common.payload.generator;

/**
 * Generate a simple payload.
 */
public class SimplePayload extends Payload {

    public SimplePayload(int payloadSize) {
        super(payloadSize);
    }

    @Override
    protected void generatePayloadObject(StringBuilder payloadBuilder) {
        payloadBuilder.append("\"");
        final String payloadCompletionString = "\"}";
        final int limit = payloadSize - (payloadBuilder.toString().getBytes(payloadCharset).length +
                payloadCompletionString.length());
        char c = START_CHAR;
        for (int i = 0; i < limit; i++) {
            payloadBuilder.append(c);
            c = getNextChar(c);
        }
        payloadBuilder.append(payloadCompletionString);
    }
}
