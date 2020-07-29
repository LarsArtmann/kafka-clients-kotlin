/*
 * Copyright 2020 StreamThoughts.
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.streamthoughts.kafka.clients

import org.apache.kafka.clients.producer.ProducerRecord
import java.time.Instant

data class KafkaRecord<K, V>(
    /**
     * The record key.
     */
    var key: K? = null,
    /**
     * The record value.
     */
    var value: V? = null,
    /**
     * The record topic.
     */
    var topic: String? = null,
    /**
     * The record partition
     */
    var partition: Int? = null,
    /**
     * The record timestamp
     */
    var timestamp: Instant? = null
) {

    fun toProducerRecord() : ProducerRecord<K?, V?> {
        return ProducerRecord(
            topic,
            partition,
            timestamp?.toEpochMilli(),
            key,
            value
        )
    }
}