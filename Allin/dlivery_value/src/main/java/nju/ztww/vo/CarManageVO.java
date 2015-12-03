package nju.ztww.vo;

/**
 * 车辆管理VO
 * 
 * @author TQ
 *
 */
public class CarManageVO extends OrderVO {

	private int idOfOrde;
	private String id;
	private String carNumber;
	private String plateNUmber;
	private String serviceTime;
	private String carState;
	private int exe=0;
	private int state=0;
	
	public CarManageVO(int idOfOrder) {
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
	public String getCarState() {
		return carState;
	}

	public void setCarState(String carState) {
		this.carState = carState;
	}

	public int getIdOfOrde() {
		return idOfOrde;
	}

	public void setIdOfOrde(int idOfOrde) {
		this.idOfOrde = idOfOrde;
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

}
