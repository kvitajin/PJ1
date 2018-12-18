package components;

import java.awt.image.BufferedImage;

public interface IResizeable {
  BufferedImage resize(BufferedImage img, int newW, int newH);
}
