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
package com.canoo.dolphin.event;

import com.canoo.dolphin.mapping.Property;

/**
 * Defines a value changed event for a {@link Property}. A {@link Property} fires {@link ValueChangeEvent} to all
 * registered change listeners (see {@link ValueChangeListener}) for each change of internal value.
 * @param <T> Type of the {@link Property} that created this event.
 */
public interface ValueChangeEvent<T> {

    /**
     * The {@link Property} that fired this event.
     * @return the {@link Property} that fired this event.
     */
    Property<T> getSource();

    /**
     * Old internal value of the {@link Property} that fired this event.
     * @return Old internal value
     */
    T getOldValue();

    /**
     * New internal value of the {@link Property} that fired this event.
     * @return New internal value
     */
    T getNewValue();
}
