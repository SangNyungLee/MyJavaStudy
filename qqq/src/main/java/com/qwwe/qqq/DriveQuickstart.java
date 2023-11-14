package com.qwwe.qqq;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.List;

/* class to demonstrate use of Drive files list API */
public class DriveQuickstart {
    private static final String APPLICATION_NAME = "Google Drive API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";
    private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT)
            throws IOException {
        InputStream in = DriveQuickstart.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets =
                GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8080).build();
        Credential credential = new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
        return credential;
    }

    public static void main(String... args) throws IOException, GeneralSecurityException {
        String realFileId = "";
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        FileList result = service.files().list()
                .setPageSize(10)
                .setFields("nextPageToken, files(id, name)")
                .execute();

        List<File> files = result.getFiles();
        if (files == null || files.isEmpty()) {
            System.out.println("No files found.");
        } else {
            System.out.println("Files:");
            for (File file : files) {
                if(file.getName().equals("uploadtest.txt")){
                    System.out.println("uploadtest 파일 찾음");
                    realFileId = file.getId();
                    System.out.println(file.getId());
                    InputStream contentStream = service.files().get(file.getId()).executeMediaAsInputStream();
                    java.util.Scanner s = new java.util.Scanner(contentStream).useDelimiter("\\A");
                    String fileContent = s.hasNext() ? s.next() : "";
                    System.out.println("File Name: " + file.getName());
                    System.out.println("File Content : " + fileContent);
                }else{
                System.out.printf("%s (%s)\n", file.getName(), file.getId());
                }
            }
        }
        //파일 업로드
//        System.out.println("\n\n 파일 업로드 시작..");
//        File fileMetaData = new File();
//        fileMetaData.setName("uploadtest.txt"); //업로드 파일 이름
////        java.io.File f = new java.io.File("C:\\Users\\SangNyung\\Desktop\\ee\\uploadtest.txt");
//        java.io.File f = new java.io.File("C:\\Users\\SANGYOUNG\\Desktop\\ee\\uploadtest.txt");
//        FileContent fileContent = new FileContent("text/plain", f);
//
//        service.files().create(fileMetaData, fileContent).setFields("id").execute();

//        //파일 다운로드
//        String downFileName = "test.txt";
//        //파일 저장경로
//        String downloadFolderPath = System.getProperty("user.home") + java.io.File.separator + "Downloads" + java.io.File.separator;
//        String fullPath = downloadFolderPath + downFileName;
//        System.out.println("\n\n 다운로드 시작...");
//        try{
//            File downloadFile = files.stream()
//                    .filter(downFile -> downFile.getName().equals(downFileName))
//                    .findAny().orElseThrow(()-> new FileNotFoundException(downFileName+"not found?!?!"));
//            String downloadFileId = downloadFile.getId();
//            OutputStream outputStream = new ByteArrayOutputStream();
//            service.files().get(downloadFileId)
//                    .executeMediaAndDownloadTo(outputStream);
//            var byteArrayOutputStream = (ByteArrayOutputStream) outputStream;
//            try(OutputStream writeStream = new FileOutputStream(fullPath)){
//                System.out.println("success");
//                byteArrayOutputStream.writeTo(writeStream);
//            }
//        } catch (GoogleJsonResponseException e){
//            System.err.println("Unable to move file : " + e.getDetails());
//            throw e;
//        }

        //구글 드라이브에 있는 파일 삭제하는 방법
        try{
            service.files().delete(realFileId).execute();
            System.out.println("성공적으로 삭제했습니다.");
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("삭제 실패");
        }

    }
}