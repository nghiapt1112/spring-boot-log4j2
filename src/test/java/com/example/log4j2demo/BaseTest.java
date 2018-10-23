package com.example.log4j2demo;

import com.nghia.libraries.commons.mss.utils.JsonUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Objects;

public class BaseTest {
    protected BaseTest testFolder(String folderPath, int sec) {
//        try {
//            File[] files = new File(BaseTest.class.getResource(folderPath).getFile()).listFiles();
//            if (Objects.isNull(files)) {
//                LOGGER.error("Folder is empty");
//                return this;
//            }
//            for (File file : files) {
//                this.execFile(new FileInputStream(file), sec);
//            }
//            return this;
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
        return null;
    }


//    private void execFile(InputStream stream, int sec) throws IOException, InterruptedException {
//        String fileContent = IOUtils.toString(stream, Charset.defaultCharset());
//        ArrayList<TestCase> testCases = JsonUtils.toCollection(fileContent, ArrayList.class, TestCase.class);
//
//        for (TestCase testCase : testCases) {
//            Thread.sleep(1000 * sec);
//            String tcInfo = this.STORED_VARIABLES.parseReqFromVariables(testCase.getDesc());
//            LOGGER.info("{} is Executing.", tcInfo);
//            long start = System.currentTimeMillis();
//            testCase
//                    .injectDependencies(webTestClient, STORED_VARIABLES)
//                    .execTest();
//            LOGGER.info("Testcase {} DONE in {} (s)", tcInfo, (System.currentTimeMillis() - start) / 1000.0);
//        }
//    }
}
