package nju.ztww.po;

public class DriverMessagePO extends OrderPO {

	private int idOfOrde;
	private String driverNumber;
	private String driverName;
	private String driverBirthday;
	private String driverId;
	private String driverTelephone;
	private String driverSex;
	private String driverServiceDeadline;
	private String id;
	private int exe=0;
	private int state=0;
	
	public DriverMessagePO(int idOfOrder) {
		super(idOfOrder);
		this.idOfOrde=idOfOrder;
	}

	public void setExe(int exe) {
		this.exe = exe;
	}

	public int getExe() {
		return exe;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public int getIdOfOrde() {
		return idOfOrde;
	}
	public String getDriverNumber() {
		return driverNumber;
	}
	public void setDriverNumber(String driverNumber) {
		this.driverNumber = driverNumber;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getDriverBirthday() {
		return driverBirthday;
	}
	public void setDriverBirthday(String driverBirthday) {
		this.driverBirthday = driverBirthday;
	}
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	public String getDriverTelephone() {
		return driverTelephone;
	}
	public void setDriverTelephone(String driverTelephone) {
		this.driverTelephone = driverTelephone;
	}
	public String getDriverSex() {
		return driverSex;
	}
	public void setDriverSex(String driverSex) {
		this.driverSex = driverSex;
	}
	public String getDriverServiceDeadline() {
		return driverServiceDeadline;
	}
	public void setDriverServiceDeadline(String driverServiceDeadline) {
		this.driverServiceDeadline = driverServiceDeadline;
	}
	public void setIdOfOrde(int idOfOrde) {
		this.idOfOrde = idOfOrde;
	}

}
