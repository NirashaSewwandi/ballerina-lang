/*
 * Copyright (c) 2023, WSO2 LLC. (https://www.wso2.com) All Rights Reserved.
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.ballerinalang.test.observe.syntaxtree;

import org.ballerinalang.test.BCompileUtil;
import org.ballerinalang.test.CompileResult;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLClassLoader;
import java.nio.file.Paths;

/**
 * Test class to test the equality of the syntax tree generated by the ObservabilitySymbolCollector.
 *
 * @since 2201.6.0
 */
public class SyntaxTreeEqualityTest {

    private static final String testPkgLocation = Paths.get("test-src", "syntaxtree").toFile().getPath();

    @Test
    public void testSyntaxTreeEquality() throws IOException {
        String jsonFilePath = "syntax-tree/syntax-tree.json";

        // Build the package
        CompileResult firstBuildResult = BCompileUtil.compile(testPkgLocation);
        URLClassLoader firstBuildClassLoader = (URLClassLoader) firstBuildResult.getClassLoader();
        InputStream jsonFile = firstBuildClassLoader.getResourceAsStream(jsonFilePath);
        String firstBuildJsonFileContent = new String(jsonFile.readAllBytes());

        // Build the package again
        CompileResult secondBuildResult = BCompileUtil.compile(testPkgLocation);
        URLClassLoader secondBuildClassLoader = (URLClassLoader) secondBuildResult.getClassLoader();
        InputStream secondJsonFile = secondBuildClassLoader.getResourceAsStream(jsonFilePath);
        String secondBuildJsonFileContent = new String(secondJsonFile.readAllBytes());

        // Compare the syntax trees
        Assert.assertEquals(secondBuildJsonFileContent, firstBuildJsonFileContent);
    }
}
