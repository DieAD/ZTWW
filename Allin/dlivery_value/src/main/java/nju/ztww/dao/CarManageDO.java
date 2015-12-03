package nju.ztww.dao;

public class CarManageDO {
	
	private String carNumber;
	private String plateNUmber;
	private String serviceTime;
	private String carState;
	private int exe=0;
	private int state=0;
	private String id;
	private int index;

	public CarManageDO() {
		
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getPlateNUmber() {
		return plateNUmber;
	}

	public void setPlateNUmber(String plateNUmber) {
		this.plateNUmber = plateNUmber;
	}

	public String getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(String serviceTime) {
		this.serviceTime = serviceTime;
	}

	public String getCarState() {
		return carState;
	}

	public void setCarState(String carState) {
		this.carState = carState;
	}

	public int getExe() {
		return exe;
	}

	public void setExe(int exe) {
		this.exe = exe;
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

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	
}
