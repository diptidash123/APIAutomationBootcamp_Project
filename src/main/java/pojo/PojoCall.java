package pojo;
import java.util.List;

public class PojoCall 
{
   //private fields
   private String name;
   private String job;
   private List<String> languages;
   private List<CityCall> city;
   private String updatedAt;
   private String id;
   private String createdAt;
   
   public String getName() {
	return name;
   }
   public void setName(String name) {
	this.name = name;
   }
   public String getJob() {
	return job;
   }
   public void setJob(String job) {
	this.job = job;
   }
   public List<String> getLanguages() {
	return languages;
   }
   public void setLanguages(List<String> languages) {
	this.languages = languages;
   }
   public List<CityCall> getCity() {
	return city;
   }
   public void setCity(List<CityCall> city) {
	this.city = city;
   }
   public String getUpdatedAt() {
	return updatedAt;
   }
   public void setUpdatedAt(String updatedAt) {
	this.updatedAt = updatedAt;
   }
   public String getId() {
	return id;
   }
   public void setId(String id) {
	this.id = id;
   }
   public String getCreatedAt() {
	return createdAt;
   }
   public void setCreatedAt(String createdAt) {
	this.createdAt = createdAt;
   }
   
   
   //setter and getter
}