package model.DTO;

public class GroupDTO {
       String groupName;
       String groupKategorie;
       String groupAdmin;
       String fileName;
       
       
       
       
	public String getGroupAdmin() {
		return groupAdmin;
	}
	public void setGroupAdmin(String groupAdmin) {
		this.groupAdmin = groupAdmin;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupKategorie() {
		return groupKategorie;
	}
	public void setGroupKategorie(String groupKategorie) {
		this.groupKategorie = groupKategorie;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
