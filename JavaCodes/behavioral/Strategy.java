public class Strategy {
	public static void main(String[] args) {
		PicDisplay picShow = new NormalPicDisplay();
		picShow.showOrder();
	}
}

/**
 * 背景：正常情况下，手机上看图片，先请求的先加载，
 * 当滑动加载很多小图片的时候，应该最后请求的最先加载，保证用户体验
*/

interface PicDisplay{
	void showOrder(); //图片显示顺序
}

class NormalPicDisplay implements PicDisplay{

	@Override
	public void showOrder() {
		System.out.println("先入队列的先显示");
	}
}

class SpecialPicDisplay implements PicDisplay{

	@Override
	public void showOrder() {
		System.out.println("后入队列的先显示");
	}
}