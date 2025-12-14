package core;

public enum statusCode_validator 
{
  //step:01 constant variables define
  //All status code implementation
  success(200,"The status code is successful"),
  created(201,"The status code is created"),
  no_content(204,"The status code is not available null"),
  bad_rquest(400,"The bad request"),
  unauthorized(401,"The unauthorized"),
  forbidden(403,"The forbidden response");
  
  //step:02 final variables define
  public final int code;
  public final String message;
	
  //step:03 parameterized constructor for calling constants
  statusCode_validator(int code,String message)
  {
	  this.code=code;
	  this.message=message;
  }
	
}