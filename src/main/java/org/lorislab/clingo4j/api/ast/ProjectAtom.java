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
import org.lorislab.clingo4j.api.ast.Statement.StatementData;
import org.lorislab.clingo4j.api.c.clingo_ast_body_literal;
import org.lorislab.clingo4j.api.c.clingo_ast_project;
import org.lorislab.clingo4j.api.c.clingo_ast_statement;
import org.lorislab.clingo4j.util.ASTObject;
import org.lorislab.clingo4j.util.ClingoUtil;

/**
 *
 * @author andrej
 */
public class ProjectAtom implements ASTObject<clingo_ast_project>, StatementData {

    private final Term atom;
    private final List<BodyLiteral> body;

    public ProjectAtom(clingo_ast_project p) {
        this(new Term(p.atom()), new BodyLiteral.BodyLiteralList(p.body(), p.size()));
    }
    
    public ProjectAtom(Term atom, List<BodyLiteral> body) {
        this.atom = atom;
        this.body = body;
    }

    public Term getAtom() {
        return atom;
    }

    public List<BodyLiteral> getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "#project " + atom + ClingoUtil.printBody(body);
    }

    @Override
    public clingo_ast_project create() {
        clingo_ast_project ret = new clingo_ast_project();
        ret.atom(atom.create());
        ret.body(ClingoUtil.createASTObjectArray(body, clingo_ast_body_literal.class));
        ret.size(ClingoUtil.arraySize(body));
        return ret;
    }

    @Override
    public void updateStatement(clingo_ast_statement ret) {
        ret.field1().project_atom(createPointer());
    }

    @Override
    public StatementType getStatementType() {
        return StatementType.PROJECT_ATOM;
    }

}
