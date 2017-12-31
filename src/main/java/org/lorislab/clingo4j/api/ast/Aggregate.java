/*
 * Copyright 2017 andrej.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.lorislab.clingo4j.api.ast;

import java.util.List;
import java.util.Optional;
import org.lorislab.clingo4j.api.ast.BodyLiteral.BodyLiteralData;
import org.lorislab.clingo4j.api.ast.ConditionalLiteral.ConditionalLiteralList;
import org.lorislab.clingo4j.api.ast.HeadLiteral.HeadLiteralData;
import org.lorislab.clingo4j.api.c.clingo_ast_aggregate;
import org.lorislab.clingo4j.api.c.clingo_ast_body_literal;
import org.lorislab.clingo4j.api.c.clingo_ast_head_literal;
import org.lorislab.clingo4j.util.ClingoUtil;

/**
 *
 * @author andrej
 */
public class Aggregate implements HeadLiteralData, BodyLiteralData {

    private final List<ConditionalLiteral> elements;
    private final Optional<AggregateGuard> leftGuard;
    private final Optional<AggregateGuard> rightGuard;

    public Aggregate(clingo_ast_aggregate ag) {
       this(new ConditionalLiteralList(ag.elements(), ag.size()), ClingoUtil.optional(AggregateGuard::new, ag.left_guard()), ClingoUtil.optional(AggregateGuard::new, ag.right_guard()));
    }
    
    public Aggregate(List<ConditionalLiteral> elements, Optional<AggregateGuard> leftGuard, Optional<AggregateGuard> rightGuard) {
        this.elements = elements;
        this.leftGuard = leftGuard;
        this.rightGuard = rightGuard;
    }

    public List<ConditionalLiteral> getElements() {
        return elements;
    }

    public Optional<AggregateGuard> getLeftGuard() {
        return leftGuard;
    }

    public Optional<AggregateGuard> getRightGuard() {
        return rightGuard;
    }

    @Override
    public clingo_ast_head_literal createHeadLiteral() {
        return ASTToC.visitHeadLiteral(this);
    }

    @Override
    public clingo_ast_body_literal createBodyLiteral() {
        return ASTToC.visitBodyLiteral(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (leftGuard.isPresent()) {
            sb.append(leftGuard.get().getTerm()).append(" ").append(leftGuard.get().getOperator()).append(" ");
        }
        sb.append("{ ");
        sb.append(ClingoUtil.print(elements, "", "; ", "", false));
        sb.append(" }");
        if (rightGuard.isPresent()) {
            sb.append(" ").append(rightGuard.get().getOperator()).append(" ").append(rightGuard.get().getTerm());
        }
        return sb.toString();
    }

}
