/*
 * Copyright 2015 Canoo Engineering AG.
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
package com.canoo.dolphin.client.javafx.impl.numeric;

import javafx.beans.property.DoubleProperty;

/**
 * Created by hendrikebbers on 27.09.15.
 */
public class DoubleJavaFXBidirectionalBinder extends AbstractNumericJavaFXBidirectionalBinder<Double> {

    public DoubleJavaFXBidirectionalBinder(final DoubleProperty javaFxProperty) {
        super(javaFxProperty);
    }

    @Override
    public Double convertNumber(Number value) {
        if (value == null) {
            return null;
        }
        return value.doubleValue();
    }

}
