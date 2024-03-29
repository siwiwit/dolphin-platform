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
package com.canoo.dolphin.client.impl;

import com.canoo.dolphin.impl.AbstractPresentationModelBuilder;
import com.canoo.dolphin.impl.PresentationModelBuilderFactory;
import com.canoo.dolphin.internal.PresentationModelBuilder;
import org.opendolphin.core.client.ClientDolphin;
import org.opendolphin.core.client.ClientPresentationModel;

public class ClientPresentationModelBuilderFactory implements PresentationModelBuilderFactory<ClientPresentationModel> {

    private final ClientDolphin dolphin;

    public ClientPresentationModelBuilderFactory(ClientDolphin dolphin) {
        this.dolphin = dolphin;
    }

    @Override
    public PresentationModelBuilder createBuilder() {
        return new ClientPresentationModelBuilder(dolphin);
    }
}
