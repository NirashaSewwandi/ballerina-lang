/*
 * Copyright (c) 2023, WSO2 LLC. (https://www.wso2.com) All Rights Reserved.
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.ballerina.runtime.api.utils;

import io.ballerina.runtime.api.types.AnydataType;
import io.ballerina.runtime.api.types.Type;
import io.ballerina.runtime.api.values.BError;
import io.ballerina.runtime.internal.ValueConverter;

/**
 * This class provides APIs needed for the type conversion in Ballerina.
 *
 * @since 2201.5.0
 */
public class ValueUtils {

    private ValueUtils() {}

    /**
     * Converts the given value which is a subtype of {@link AnydataType} to another subtype of {@link AnydataType}
     * given by the target type.
     *
     * @param   value       value to be converted
     * @param   targetType  target type
     * @return              converted value
     * @throws              BError if the conversion fails.
     */
    public static Object convert(Object value, Type targetType) throws BError {
        return ValueConverter.convert(value, targetType);
    }
}
