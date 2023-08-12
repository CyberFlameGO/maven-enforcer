/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.maven.enforcer.rules.dependency.selector;

import org.eclipse.aether.collection.DependencyCollectionContext;
import org.eclipse.aether.collection.DependencySelector;
import org.eclipse.aether.graph.Dependency;

/**
 * Dependency selector discarding {@code optional} dependencies on all levels.
 * The standard {@link org.eclipse.aether.util.graph.selector.OptionalDependencySelector}
 * does not discard direct dependencies.
 */
public class AllLevelsOptionalDependencySelector implements DependencySelector {
    @Override
    public boolean selectDependency(Dependency dependency) {
        return !dependency.isOptional();
    }

    @Override
    public DependencySelector deriveChildSelector(DependencyCollectionContext context) {
        return this;
    }
}