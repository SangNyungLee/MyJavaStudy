package com.finaltest.good;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* class to demonstrate use of Drive files list API */
public class GoodApplication {
	private static final String APPLICATION_NAME = "Google Drive API Java Quickstart";
	private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
	private static final String TOKENS_DIRECTORY_PATH = "tokens";
	private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE_FILE);

	private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

	private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT)
			throws IOException {
		// Load client secrets.
		InputStream in = GoodApplication.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
		if (in == null) {
			throw new FileNotFoundException("리소스를 찾을 수 없습니다: " + CREDENTIALS_FILE_PATH);
		}
		GoogleClientSecrets clientSecrets =
				GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

		// Build flow and trigger user authorization request.
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
				HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
				.setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
				.setAccessType("offline")
				.build();
		LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8080).build();
		return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
	}

	public static void main(String... args) throws IOException, GeneralSecurityException {
		//파일이름
		String fileName = "test.txt";

		// Build a new authorized API client service.
		final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
				.setApplicationName(APPLICATION_NAME)
				.build();

		// Print the names and IDs for up to 10 files.
		FileList result = service.files().list()
//				.setQ("name='" + fileName + "'")
				.setPageSize(100)
				.setFields("files(id, name)")
				.execute();
		List<File> files = result.getFiles();
		if (files == null || files.isEmpty()) {
			System.out.println("파일을 찾을 수 없습니다: " + fileName);

		} else {
			for(File file : files){
				System.out.println(file.getName());
			}
			String fileId = files.get(0).getId();
			System.out.println(fileId);
//			ByteArrayOutputStream outputStream = DownloadFile.downloadFile(fileId);
//			byte[] downloadFileData = outputStream.toByteArray();
//			System.out.println(Arrays.toString(downloadFileData));
			System.out.println("파일 다운로드 완료: " + fileName);
		}

		//
		System.out.println("\n\n 파일 업로드 시작..");
		File fileMetaData = new File();
		fileMetaData.setName("uploadtest.txt"); //업로드할 파일
		java.io.File f = new java.io.File("uploadtest.txt");
		//따로 정해진 타입이 없으면 application.octet-stream (바이너리 데이터)
		FileContent fileContent = new FileContent("text/plain", f);
		service.files().create(fileMetaData, fileContent).execute();

		//
		String downFileName = "test.txt";
		System.out.println("\n\n 다운로드 시작..");
		try{
			File downloadFile = files.stream().filter(downFile->downFile.getName().equals(downFileName)).findAny().orElseThrow(()->new FileNotFoundException(downFileName+"은 존재하지 않는 파일입니다"));
			String downloadFileId = downloadFile.getId();
			OutputStream outputStream = new ByteArrayOutputStream();
			service.files().get(downloadFileId)
					.executeMediaAndDownloadTo(outputStream);
			var byteArrayOutputStream = (ByteArrayOutputStream) outputStream;
			try(OutputStream writeStream = new FileOutputStream(downFileName)){
				byteArrayOutputStream.writeTo(writeStream);
			}
		} catch (GoogleJsonResponseException e){
			System.err.println("Unable to move file : " + e.getDetails());
			throw e;
		}
//		try {
//			String fileId = UploadBasic.uploadBasic();
//			System.out.println("Uploaded file ID : " + fileId);
//		}catch (IOException e){
//			e.printStackTrace();
//		}
	}


}