/*
 *
 *  * Copyright 2016 Skymind,Inc.
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *        http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 *
 */
package org.deeplearning4j.ui.components.text;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.deeplearning4j.ui.api.Component;
import org.deeplearning4j.ui.components.text.style.StyleText;

/**
 * Simple text component with styling
 *
 * @author Alex Black
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ComponentText extends Component {
    public static final String COMPONENT_TYPE = "ComponentText";
    private String text;

    public ComponentText() {
        super(COMPONENT_TYPE, null);
        //No arg constructor for Jackson deserialization
        text = null;
    }

    public ComponentText(String text, StyleText style) {
        super(COMPONENT_TYPE, style);
        this.text = text;
    }

    private ComponentText(Builder builder) {
        this(builder.text, builder.style);
    }


    @Override
    public String toString() {
        return "ComponentText(" + text + ")";
    }

    public static class Builder {

        private StyleText style;
        private String text;

        public Builder(String text, StyleText style) {
            this.text = text;
            this.style = style;
        }

        public ComponentText build() {
            return new ComponentText(this);
        }
    }

}
