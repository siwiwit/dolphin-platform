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
package com.canoo.dolphin.server.spring;

import com.canoo.dolphin.server.container.ContainerManager;
import com.canoo.dolphin.server.container.ModelInjector;
import com.canoo.dolphin.server.context.DolphinContext;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;

/**
 * SPring specific implementation of the {@link ContainerManager} interface
 *
 * @author Hendrik Ebbers
 */
public class SpringContainerManager implements ContainerManager {

    @Override
    public void init(ServletContext servletContext) {
        if(servletContext == null) {
            throw new IllegalArgumentException("servletContext must not be null!");
        }
        WebApplicationContext context = getContext(servletContext);
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getAutowireCapableBeanFactory();
        beanFactory.addBeanPostProcessor(SpringModelInjector.getInstance());
    }

    @Override
    public <T> T createManagedController(final Class<T> controllerClass, final ModelInjector modelInjector) {
        if(controllerClass == null) {
            throw new IllegalArgumentException("controllerClass must not be null!");
        }
        if(modelInjector == null) {
            throw new IllegalArgumentException("modelInjector must not be null!");
        }
        // SpringBeanAutowiringSupport kann man auch nutzen
        WebApplicationContext context = getContext(DolphinContext.getCurrentContext().getServletContext());
        AutowireCapableBeanFactory beanFactory = context.getAutowireCapableBeanFactory();
        SpringModelInjector.getInstance().prepare(controllerClass, modelInjector);
        return beanFactory.createBean(controllerClass);
    }

    @Override
    public void destroyController(Object instance, Class controllerClass) {
        if(instance == null) {
            throw new IllegalArgumentException("instance must not be null!");
        }
        ApplicationContext context = getContext(DolphinContext.getCurrentContext().getServletContext());
        context.getAutowireCapableBeanFactory().destroyBean(instance);
    }

    /**
     * Returns the Spring {@link org.springframework.context.ApplicationContext} for the current {@link javax.servlet.ServletContext}
     *
     * @return the spring context
     */
    private WebApplicationContext getContext(ServletContext servletContext) {
        if(servletContext == null) {
            throw new IllegalArgumentException("servletContext must not be null!");
        }
        return WebApplicationContextUtils.getWebApplicationContext(servletContext);
    }
}
