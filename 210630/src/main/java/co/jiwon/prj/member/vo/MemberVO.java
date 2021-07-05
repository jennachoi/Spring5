package co.jiwon.prj.member.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MemberVO {

	/*
	이름        널        유형            
	--------- -------- ------------- 
	EMAIL     NOT NULL VARCHAR2(20)  
	NAME      NOT NULL VARCHAR2(20)  
	PASSWORD  NOT NULL VARCHAR2(20)  
	STATUS    NOT NULL VARCHAR2(2)   
	FILENAME           VARCHAR2(200) 
	DIRECTORY          VARCHAR2(200) 
	FILEUUID           VARCHAR2(200) 
	GUBUN              VARCHAR2(20)  
	 */
	
	private String email;
	private String name;
	private String password;
	private String status;
	private String fileName;
	private String directory;
	private String fileUuid;
	private String gubun;
	private MultipartFile file;
	
}
