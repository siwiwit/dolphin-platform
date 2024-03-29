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
package com.canoo.dolphin.server.container;

import javax.servlet.ServletContext;

/**
 * <p>
 * This interface defines the platform / container specific controller management.
 * By default Dolphin Platform provides 2 implementations of this interface for Spring and JavaEE that
 * can be found in the specific modules. If you want to add the support for a different platform you need to
 * provide a custom implementation of this interface.
 * </p>
 * <p>
 * Here is a short overview how the architecture is defined:
 * <br>
 * <center><img src="doc-files/platform-impl.png" alt="model is synchronized between client and server"></center>
 * </p>
 */
public interface ContainerManager {

    void init(ServletContext servletContext);

    <T> T createManagedController(Class<T> controllerClass, ModelInjector modelInjector);

    void destroyController(Object instance, Class controllerClass);

}
