public class Adapter {
	public static void main(String[] args) {
		TuHuWeatherAdapter adapter = new TuHuWeatherAdapter();
		String weather = adapter.getWeatherFromAliBaBa();
		System.out.println(weather);
	}
}
/**
 * 背景：途虎app天气接口使用的是中国气象网的，后来与阿里巴巴合作，需要改用阿里的天气
 */

/**
 * 途虎数据接口
 */
interface TuHuData{
	String getWeatherFromChina();
}

/**
 * 途虎app实现该接口获取中国气象网天气
 */
class TuHuApp implements TuHuData{

	@Override
	public String getWeatherFromChina() {
		return "TuHuWeather：上海：25℃...";
	}

}
/**
 * 阿里巴巴的数据接口
 */
interface AliBaBaDate{
	String getWeatherFromAliBaBa();
}

/**
 * 阿里获取自家的天气数据
 */
class AliBaBaServer implements AliBaBaDate{

	@Override
	public String getWeatherFromAliBaBa() {
		return "AliBaBaWeather：上海：24℃...";
	}
}

/**
 * 途虎使用了适配器，不改变原有业务逻辑的基础上，使用阿里的天气数据
 */
//类的适配器模式
class TuHuWeatherAdapter extends AliBaBaServer implements TuHuData{

	@Override
	public String getWeatherFromChina() {
		return getWeatherFromAliBaBa();
	}

}

//对象的适配器模式
class TuHuWeatherAdapter2 extends AliBaBaServer implements TuHuData{
	AliBaBaServer aliBaBaServer;
	public TuHuWeatherAdapter2(AliBaBaServer aliBaBaServe) {
		this.aliBaBaServer = aliBaBaServe;
	}
	@Override
	public String getWeatherFromChina() {
		return aliBaBaServer.getWeatherFromAliBaBa();
	}

}

