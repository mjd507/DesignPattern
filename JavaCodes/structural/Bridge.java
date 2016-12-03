package JavaSE_Senior.DesignPattern.JavaCodes.structural;

public class Bridge {
	public static void main(String[] args) {
		Video avi = new AVIVideo();
		OperationSystem mac = new Mac(avi);
		mac.playVideo();
	}

}


//--------------- 业务实现角色 ----------------

abstract class Video{
	abstract void makeVideo();
}

class AVIVideo extends Video{

	@Override
	void makeVideo() {
		System.out.println("制造了 avi 格式的视频");
	}
}

class WMVVideo extends Video{
	
	@Override
	void makeVideo() {
		System.out.println("制造了 wmv 格式的视频");
	}
}


//--------------- 业务抽象角色 ----------------
abstract class OperationSystem{
	protected Video video;
	public OperationSystem(Video video) {
		this.video = video;
	}
	protected void playVideo(){
		video.makeVideo();
	}
}


class Mac extends OperationSystem{

	public Mac(Video video) {
		super(video);
	}

	@Override
	protected void playVideo() {
		super.playVideo();
		System.out.println("mac os 播放了"+ video.getClass().getSimpleName().substring(0,3) +" 格式的视频");
	}

}

class Windows extends OperationSystem{
	public Windows(Video video) {
		super(video);
	}

	@Override
	protected void playVideo() {
		super.playVideo();
		System.out.println("mac os 播放了"+ video.getClass().getSimpleName().substring(0,3) +" 格式的视频");
	}
}
