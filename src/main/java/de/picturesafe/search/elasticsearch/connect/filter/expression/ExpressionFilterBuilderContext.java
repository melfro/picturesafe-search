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

package de.picturesafe.search.elasticsearch.connect.filter.expression;

import de.picturesafe.search.elasticsearch.connect.dto.QueryDto;
import de.picturesafe.search.elasticsearch.connect.filter.ExpressionFilterFactory;
import de.picturesafe.search.elasticsearch.config.MappingConfiguration;
import de.picturesafe.search.elasticsearch.connect.context.SearchContext;
import de.picturesafe.search.expression.Expression;

public class ExpressionFilterBuilderContext {
    private final Expression expression;
    private final SearchContext searchContext;
    private final ExpressionFilterFactory initiator;

    public ExpressionFilterBuilderContext(Expression expression, SearchContext searchContext, ExpressionFilterFactory initiator) {
        this.expression = expression;
        this.searchContext = searchContext;
        this.initiator = initiator;
    }

    public Expression getExpression() {
        return expression;
    }

    public QueryDto getQueryDto() {
        return searchContext.getQueryDto();
    }

    public SearchContext getSearchContext() {
        return searchContext;
    }

    public MappingConfiguration getMappingConfiguration() {
        return searchContext.getMappingConfiguration();
    }

    public boolean isProcessed() {
        return searchContext.isProcessed(expression);
    }

    public void setProcessed() {
        searchContext.setProcessed(expression);
    }

    public boolean isNestedQuery() {
        return searchContext.isNestedQuery();
    }

    ExpressionFilterFactory getInitiator() {
        return initiator;
    }
}
