package util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ImagenesView2 {

	private List<String> images;

	@PostConstruct
	public void init() {
		images = new ArrayList<String>();
		for (int i = 1; i <= 3; i++) {
			images.add("jugador" + i + ".jpg");
		}
		
	}

	public List<String> getImages() {
		return images;
	}
}
