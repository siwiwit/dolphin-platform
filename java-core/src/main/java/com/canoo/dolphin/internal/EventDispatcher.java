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
package com.canoo.dolphin.internal;

import org.opendolphin.core.ModelStoreListener;

/**
 * Created by hendrikebbers on 25.09.15.
 */
public interface EventDispatcher extends ModelStoreListener {

    void addAddedHandler(DolphinEventHandler handler);

    void addRemovedHandler(DolphinEventHandler handler);

    void addListElementAddHandler(DolphinEventHandler handler);

    void addListElementDelHandler(DolphinEventHandler handler);

    void addListElementSetHandler(DolphinEventHandler handler);
}
