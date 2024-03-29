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
package com.canoo.dolphin.impl;

import com.canoo.dolphin.mapping.DolphinBean;
import com.canoo.dolphin.mapping.Property;

@DolphinBean(PlatformConstants.CONTROLLER_REGISTRY_BEAN_NAME)
public class ControllerRegistryBean {

    private Property<String> controllerName;

    private Property<String> controllerId;

    private Property<Object> model;

    public String getControllerName() {
        return controllerName.get();
    }

    public void setControllerName(String controllerName) {
        this.controllerName.set(controllerName);
    }

    public String getControllerId() {
        return controllerId.get();
    }

    public void setControllerId(String controllerId) {
        this.controllerId.set(controllerId);
    }

    public Object getModel() {
        return model.get();
    }

    public void setModel(Object model) {
        this.model.set(model);
    }
}
