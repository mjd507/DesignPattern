package JavaSE_Senior.DesignPattern.JavaCodes.behavioral;

/**
 * @author mjd
 *
 */
public class Chain {

	public static void main(String[] args) {
		System.out.println("准备请个长假了，好激动！");
		HolidayRequest request = new HolidayRequest(HolidayType.LONG);
		RequestHandler HRHandler = new HRHandler(null);
		RequestHandler PMHandler = new PMHandler(HRHandler);
		PMHandler.handleHoliday(request);
	}

}

enum HolidayType{
	SHORT, Medium, LONG;
}


/**
 * 假期申请
 */
class HolidayRequest{
	private HolidayType type;
	public HolidayRequest(HolidayType type) {
		this.type = type;
	}
	public HolidayType getHolidayType(){
		return type;
	}
}


/**
 * 请求处理
 */
abstract class RequestHandler{

	protected RequestHandler nextHandler;

	public RequestHandler(RequestHandler nextHandler) {
		this.nextHandler = nextHandler;
	}

	public abstract void handleHoliday(HolidayRequest holidayRequest);
}


/**
 * 项目经理审批
 */
class PMHandler extends RequestHandler{

	public PMHandler(RequestHandler nextHandler) {
		super(nextHandler);
	}

	@Override
	public void handleHoliday(HolidayRequest holidayRequest) {
		HolidayType type = holidayRequest.getHolidayType();
		if(type == HolidayType.SHORT){
			System.out.println("项目经理内部同意休假，不扣工资");
		}else{
			System.out.println("项目经理觉得假期过长，提交人事部处理");
			nextHandler.handleHoliday(holidayRequest);
		}
	}

}

/**
 * 人事部审批
 */
class HRHandler extends RequestHandler{

	public HRHandler(RequestHandler nextHandler) {
		super(nextHandler);
	}

	@Override
	public void handleHoliday(HolidayRequest holidayRequest) {
		System.out.println("人事部同意休假，要扣工资的哦~");
	}

}

