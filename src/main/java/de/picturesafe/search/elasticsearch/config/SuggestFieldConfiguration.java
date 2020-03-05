/*
 * Copyright 2020 picturesafe media/data/bank GmbH
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

package de.picturesafe.search.elasticsearch.config;

import org.apache.commons.lang3.Validate;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class SuggestFieldConfiguration implements FieldConfiguration {

    private String name;
    private String elasticsearchType;

    public SuggestFieldConfiguration(String name) {
        Validate.isTrue(!name.contains("."), "Parameter 'name' must not contain a '.'!");
        this.name = name;
        this.elasticsearchType = ElasticsearchType.COMPLETION.toString();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getElasticsearchType() {
        return elasticsearchType;
    }

    public boolean isCopyToFulltext() {
        return false;
    }

    @Override
    public boolean isSortable() {
        return false;
    }

    @Override
    public boolean isAggregatable() {
        return false;
    }

    @Override
    public boolean isMultilingual() {
        return false;
    }

    @Override
    public String getAnalyzer() {
        return null;
    }

    @Override
    public List<FieldConfiguration> getNestedFields() {
        return Collections.emptyList();
    }

    @Override
    public FieldConfiguration getNestedField(String name) {
        return null;
    }

    @Override
    public boolean isNestedObject() {
        return false;
    }

    @Override
    public Set<String> getCopyToFields() {
        return null;
    }

    @Override
    public FieldConfiguration getParent() {
        return null;
    }
}
