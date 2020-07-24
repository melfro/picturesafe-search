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

package de.picturesafe.search.elasticsearch.impl.mapping;

import de.picturesafe.search.elasticsearch.config.FieldConfiguration;
import org.apache.commons.lang3.NotImplementedException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("unchecked")
public class MappingResolver {

    public static MappingFields resolveFields(Map<String, Object> mapping, String indexName) {
        final List<FieldConfiguration> fieldConfigurations = new ArrayList<>();
        final Set<Locale> locales = new HashSet<>();

        final Map<String, Object> properties = properties(mapping, indexName, "mappings", "properties");
        properties.forEach((name, value) -> {
            final MappingField field = resolveField(name, (Map<String, Object>) value);
            fieldConfigurations.add(field.getFieldConfiguration());
            locales.addAll(field.getLocales());
        });
        return new MappingFields(fieldConfigurations, new ArrayList<>(locales));
    }

    private static MappingField resolveField(String name, Map<String, Object> properties) {
        throw new NotImplementedException("Not yet implemented!"); // ToDo
    }

    @SuppressWarnings("unchecked")
    private static Map<String, Object> properties(Map<String, Object> doc, String... names) {
        Map<String, Object> props = doc;
        for (final String name : names) {
            props = (Map<String, Object>) props.get(name);
        }
        return props;
    }
}