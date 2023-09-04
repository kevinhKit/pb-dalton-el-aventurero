package org.openjfx.classes;

import javafx.scene.shape.Rectangle;

public class Animation {
    
    private Rectangle location[];
    private String currentFrame;
    private double duration;

    public Animation( double duration, Rectangle[] location){
        this.duration = duration;
        this.location = location;
    }

    
		public double getDuration() {
			return duration;
		}
		
		public void setDuration(double duration) {
			this.duration = duration;
		}
		
		public Rectangle[] getLocation() {
			return location;
		}
		
		public void setLocation(Rectangle[] location) {
			this.location = location;
		}
		
		public String getCurrentFrame() {
			return currentFrame;
		}
		
		public void setCurrentFrame(String currentFrame) {
			this.currentFrame = currentFrame;
		}
		
		
		public Rectangle calculateCurrentFrame(double t) {
			int countFrames = this.location.length;
			int currentIndex = (int)(t%(countFrames*duration)/duration);
			return location[currentIndex];
		}

}
