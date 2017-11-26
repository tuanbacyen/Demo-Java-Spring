package skay.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FilenameUtils;

import org.springframework.web.multipart.MultipartFile;

public class API_File {

	// file folder
	private String path = "";

	public API_File(String path) {
		super();
		this.path = path;
	}

	public String saveFile(MultipartFile file, String coupleid, Integer aniversarryid) {
		String fileName = "";
		try {
			fileName = file.getOriginalFilename();
			byte[] bytes = file.getBytes();
			String urlSaveFile = path + "/" + coupleid + "_" + aniversarryid + "_" + fileName;
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
					new FileOutputStream(new File(urlSaveFile)));

			bufferedOutputStream.write(bytes);
			bufferedOutputStream.close();
			return urlSaveFile;
		} catch (IOException e) {
			return "fail";
		}
	}

	public String saveFileWithName(MultipartFile file, String nameImage) {
		try {
			API_DateTimeToString api = new API_DateTimeToString();
			byte[] bytes = file.getBytes();
			String ext = FilenameUtils.getExtension(file.getOriginalFilename());
			String fileName = api.getNewNameWithNow(nameImage) + "." + ext;
			String urlSaveFile = path + "/" + fileName;
			System.out.println(urlSaveFile);
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
					new FileOutputStream(new File(urlSaveFile)));

			bufferedOutputStream.write(bytes);
			bufferedOutputStream.close();
			return fileName;
		} catch (IOException e) {
			return "fail";
		}
	}

	public Boolean deleteFile(String splitFirtName) {
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				if (API_CheckAll.checkPath(listOfFiles[i].getName(), splitFirtName)) {
					try {
						Path path = Paths.get(listOfFiles[i].getPath());
						Files.delete(path);
					} catch (Exception e) {
						System.err.format("%s: no such" + " file or directory%n", path);
						return false;
					}
				}
			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + listOfFiles[i].getName());
			}
		}
		return true;
	}

	public Boolean deleteFileWithFileName(String fileName) {
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				if (listOfFiles[i].getName().equals(fileName)) {
					try {
						Path path = Paths.get(listOfFiles[i].getPath());
						Files.delete(path);
						break;
					} catch (Exception e) {
						System.err.format("%s: no such" + " file or directory%n", path);
						return false;
					}
				}
			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + listOfFiles[i].getName());
			}
		}
		return true;
	}
}
