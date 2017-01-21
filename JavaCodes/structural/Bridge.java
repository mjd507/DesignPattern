public class Bridge {
	public static void main(String[] args) {
		Video avi = new AVIVideo();
		VideoPlayer macplayer = new MacVideoPlayer(avi);
		macplayer.playVideo();
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

abstract class VideoPlayer{
	protected Video video;
	public VideoPlayer(Video video) {
		this.video = video;
	}
	protected void playVideo(){
		video.makeVideo();
	}
}

class MacVideoPlayer extends VideoPlayer{

	public MacVideoPlayer(Video video) {
		super(video);
	}

	@Override
	protected void playVideo() {
		super.playVideo();
		System.out.println("mac os 播放了"+ video.getClass().getSimpleName().substring(0,3) +" 格式的视频");
	}
}

class WindowsVideoPlayer extends VideoPlayer{
	public WindowsVideoPlayer(Video video) {
		super(video);
	}

	@Override
	protected void playVideo() {
		super.playVideo();
		System.out.println("windows os 播放了"+ video.getClass().getSimpleName().substring(0,3) +" 格式的视频");
	}
}
