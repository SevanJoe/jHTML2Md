package com.runawaybits.html2markdown;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Testbed {
    private static final String HTML_FOLDER_PATH = "html";
    private static final String HTML_SUFFIX = "html";
    private static final String CHARSET = "Windows-1252";
    private static final String MARKDOWN_FOLDER_PATH = "markdown";
    private static final String MARKDOWN_SUFFIX = "md";
    
    public static void main(String[] args) {
        if (FilesUtil.isExistNotCreate(HTML_FOLDER_PATH)) {
            List<File> htmlFileList = FilesUtil.getAllFiles(HTML_FOLDER_PATH, HTML_SUFFIX);
            for (File htmlFile : htmlFileList) {
                try {
                    String mdString = HTML2Md.convertFile(htmlFile, CHARSET);
                    FilesUtil.newFile(MARKDOWN_FOLDER_PATH + "/" + 
                            FilesUtil.getNameNoSuffix(htmlFile.getName()) + "." + MARKDOWN_SUFFIX, mdString, CHARSET);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}