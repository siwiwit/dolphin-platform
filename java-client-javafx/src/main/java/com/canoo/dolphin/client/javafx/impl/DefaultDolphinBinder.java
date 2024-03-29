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
package com.canoo.dolphin.client.javafx.impl;

import com.canoo.dolphin.client.javafx.BidirectionalConverter;
import com.canoo.dolphin.client.javafx.Binding;
import com.canoo.dolphin.client.javafx.Converter;
import com.canoo.dolphin.client.javafx.DolphinBinder;
import com.canoo.dolphin.event.Subscription;
import com.canoo.dolphin.mapping.Property;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * Created by hendrikebbers on 28.09.15.
 */
public class DefaultDolphinBinder<S> implements DolphinBinder<S> {

    private final Property<S> property;

    public DefaultDolphinBinder(final Property<S> property) {
        if (property == null) {
            throw new IllegalArgumentException("property must not be null");
        }
        this.property = property;
    }

    @Override
    public <T> Binding to(final ObservableValue<T> observableValue, final Converter<? super T, ? extends S> converter) {
        if (observableValue == null) {
            throw new IllegalArgumentException("observableValue must not be null");
        }
        if (converter == null) {
            throw new IllegalArgumentException("converter must not be null");
        }
        final ChangeListener<T> listener = (obs, oldVal, newVal) -> property.set(converter.convert(newVal));
        observableValue.addListener(listener);
        property.set(converter.convert(observableValue.getValue()));
        return () -> observableValue.removeListener(listener);
    }


    @Override
    public <T> Binding bidirectionalTo(javafx.beans.property.Property<T> javaFxProperty, BidirectionalConverter<T, S> converter) {
        if (javaFxProperty == null) {
            throw new IllegalArgumentException("javaFxProperty must not be null");
        }
        if (converter == null) {
            throw new IllegalArgumentException("converter must not be null");
        }
        Binding unidirectionalBinding = to(javaFxProperty, converter);
        Subscription subscription = property.onChanged(e -> javaFxProperty.setValue(converter.convertBack(property.get())));
        return () -> {
            unidirectionalBinding.unbind();
            subscription.unsubscribe();
        };
    }
}
