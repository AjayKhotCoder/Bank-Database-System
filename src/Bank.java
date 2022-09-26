
public class Bank 
{
    String name;
    String opAmt;
    String dob;
    String gender;
    String ms;
    String typAcc;
    String add;
    String serReq;
    String idProof;
    String addProof;
    String accNo;
	public String getAccNo()
	{
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOpAmt() {
		return opAmt;
	}
	public void setOpAmt(String opAmt) {
		this.opAmt = opAmt;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMs() {
		return ms;
	}
	public void setMs(String ms) {
		this.ms = ms;
	}
	public String getTypAcc() {
		return typAcc;
	}
	public void setTypAcc(String typAcc) {
		this.typAcc = typAcc;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getSerReq() {
		return serReq;
	}
	public void setSerReq(String serReq) {
		this.serReq = serReq;
	}
	public String getIdProof() {
		return idProof;
	}
	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}
	public String getAddProof() {
		return addProof;
	}
	public void setAddProof(String addProof) {
		this.addProof = addProof;
	}
	Bank(
		    String name,String opAmt,String dob,String gender,String ms,String typAcc,String add,
		    String serReq,String idProof,String addProof)
	{
		super();
		this.name=name;
		this.opAmt=opAmt;
		this.dob= dob;
		this.gender=gender;
		this.ms=ms;
		this.typAcc=typAcc;
		this.add=add;
		this.serReq=serReq;
		this.idProof=idProof;
		this.addProof=addProof;
	}
	public Bank(String accNo,String opAmt) {
		super();
		this.opAmt=opAmt;
		this.accNo=accNo;
	}
	public Bank(String accNO) {
		// TODO Auto-generated constructor stub
		this.accNo=accNo;
	}
	Bank(
		   String accNo, String name,String opAmt,String dob,String gender,String ms,String typAcc,String add,
		    String serReq,String idProof,String addProof)
	{
		super();
		this.accNo=accNo;
		this.name=name;
		this.opAmt=opAmt;
		this.dob= dob;
		this.gender=gender;
		this.ms=ms;
		this.typAcc=typAcc;
		this.add=add;
		this.serReq=serReq;
		this.idProof=idProof;
		this.addProof=addProof;
	}
}
